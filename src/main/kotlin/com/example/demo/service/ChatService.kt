package com.example.demo.service

import com.example.demo.dto.ChatRequestDto
import com.example.demo.dto.ChatResponseDto
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class ChatService(
    private val restTemplate: RestTemplate,
    private val fastApiBaseUrl: String
) {

    fun sendQuestion(chatRequestDto: ChatRequestDto): ChatResponseDto {
        val uri = UriComponentsBuilder.fromUriString(fastApiBaseUrl)
            .path("/async/chat")
            .queryParam("question", chatRequestDto.question)
            .build()
            .toUriString()

        try {
            val response = restTemplate.getForObject(uri, String::class.java)
            return ChatResponseDto(response ?: "No response received")
        } catch (e: Exception) {
            return ChatResponseDto("Error: ${e.message}")
        }
    }
}