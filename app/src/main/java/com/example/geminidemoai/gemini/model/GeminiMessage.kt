package com.example.geminidemoai.gemini.model

enum class MessageSender {
    USER, AI
}

data class GeminiMessage(
    val text: String,
    val sender: MessageSender,
)
