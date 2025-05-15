package com.example.demo.model

import java.time.LocalDateTime

data class ChatMessage(
    val id: Long = System.currentTimeMillis(),
    val question: String,
    val answer: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)