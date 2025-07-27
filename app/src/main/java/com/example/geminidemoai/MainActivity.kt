package com.example.geminidemoai

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.geminidemoai.gemini.model.GeminiMessage
import com.example.geminidemoai.gemini.model.GeminiRepository
import com.example.geminidemoai.gemini.model.MessageSender
import com.example.geminidemoai.gemini.model.Result
import com.example.geminidemoai.ui.theme.GeminiDemoAITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val TAG = "GeminiDemoAI"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // TODO: **WARNING: Do not do this for production or public code.
        // This is a significant security risk.
        // This is only for a quick, private sample.
        val apiKey = "AIzaSyCOjQ8OQ8DJjGj3_VpjmirwZx-6tfjuttE"
        val modelName = "gemini-2.5-flash"
        val geminiRepository = GeminiRepository(
            apiKey = apiKey,
            modelName = modelName
        )
        var aiResponse by mutableStateOf("Fetching AI response...")

        lifecycleScope.launch {
            Log.d(TAG, "Starting API call...")
            val history = listOf(
                // This is the message that user sends to AI model
                GeminiMessage("Hello, what is a good beginner workout plan?", MessageSender.USER)
            )

            when (val result = geminiRepository.generateContent(history)) {
                is Result.Success -> {
                    aiResponse = result.data
                    Log.d(TAG, "API Success: ${result.data}")
                }

                is Result.Failure -> {
                    aiResponse = "Error: ${result.exception.message}"
                    Log.e(TAG, "API Error: ${result.exception.message}")
                }
            }
        }

        setContent {
            GeminiDemoAITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                    ) {
                        ResponseDisplay(
                            text = aiResponse,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }

    // A simple Composable to display the text
    @Composable
    fun ResponseDisplay(text: String, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)

        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
