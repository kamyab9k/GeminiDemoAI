package com.example.geminidemoai.gemini.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class GeminiRepository(
    private val apiKey: String,
    private val modelName: String,
) {
    private val client = OkHttpClient()

    // The media type for the request body is always JSON.
    private val mediaType = "application/json".toMediaType()

    suspend fun generateContent(history: List<GeminiMessage>): Result<String> {
        // 1. Build the API URL with your model name and key.
        val url =
            "https://generativelanguage.googleapis.com/v1beta/models/$modelName:generateContent?key=$apiKey"

        // 2. Create the JSON array for the conversation history.
        val contentsArray = JSONArray()
        history.forEach { message ->
            val role = when (message.sender) {
                MessageSender.USER -> "user"
                MessageSender.AI -> "model"
            }
            contentsArray.put(JSONObject().apply {
                put("role", role)
                put("parts", JSONArray().apply {
                    put(JSONObject().apply {
                        put("text", message.text)
                    })
                })
            })
        }

        // 3. Combine the conversation history and a system instruction into a single JSON object.
        val jsonBody = JSONObject().apply {
            put("system_instruction", JSONObject().apply {
                put("parts", JSONArray().apply {
                    put(JSONObject().apply {
                        put(
                            "text",
                            "You are an AI fitness coach named FitCore only answer to Fitness and exercise questions ... (your instructions here)"
                        )
                    })
                })
            })
            put("contents", contentsArray)
        }.toString()

        // 4. Create the OkHttp request with the JSON body.
        val requestBody = jsonBody.toRequestBody(mediaType)
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

// Use withContext(Dispatchers.IO) to perform the network call on a background thread.
        val responseString = withContext(Dispatchers.IO) {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException("API returned error: ${response.code} - ${response.message}")
                }
                response.body?.string() ?: throw IOException("Empty response body.")
            }
        }

// Now, parse the successful JSON response.
        val jsonResponse = JSONObject(responseString)
        val candidates = jsonResponse.optJSONArray("candidates")

        if (candidates != null && candidates.length() > 0) {
            val firstCandidate = candidates.getJSONObject(0)
            val content = firstCandidate.optJSONObject("content")
            if (content != null) {
                val parts = content.optJSONArray("parts")
                if (parts != null && parts.length() > 0) {
                    val firstPart = parts.optJSONObject(0)
                    if (firstPart != null) {
                        val text = firstPart.optString("text")
                        // Success! Return the generated text.
                        if (!text.isNullOrEmpty()) {
                            return Result.Success(text)
                        }
                    }
                }
            }
        }
        return Result.Failure(IOException("Failed to parse API response."))
    }
}