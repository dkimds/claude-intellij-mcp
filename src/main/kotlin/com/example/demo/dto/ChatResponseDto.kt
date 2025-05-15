package com.example.demo.dto

data class ChatResponseDto(
    val answer: String,
    val id: Long = System.currentTimeMillis() // 각 응답에 고유 ID 부여
)