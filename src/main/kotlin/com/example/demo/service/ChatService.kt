package com.example.demo.service

import com.example.demo.dto.ChatRequestDto
import com.example.demo.dto.ChatResponseDto
import com.example.demo.model.ChatMessage
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class ChatService(
    private val restTemplate: RestTemplate,
    private val fastApiBaseUrl: String
) {
    // 채팅 기록을 저장할 컬렉션 (스레드 안전한 ConcurrentLinkedQueue 사용)
    private val chatHistory = ConcurrentLinkedQueue<ChatMessage>()

    fun sendQuestion(chatRequestDto: ChatRequestDto): ChatResponseDto {
        val uri = UriComponentsBuilder.fromUriString(fastApiBaseUrl)
            .path("/async/chat")
            .queryParam("question", chatRequestDto.question)
            .build()
            .toUriString()

        try {
            val response = restTemplate.getForObject(uri, String::class.java) ?: "No response received"
            val responseDto = ChatResponseDto(response)
            
            // 채팅 기록에 대화 추가
            val chatMessage = ChatMessage(
                id = responseDto.id,
                question = chatRequestDto.question,
                answer = responseDto.answer,
                timestamp = LocalDateTime.now()
            )
            chatHistory.add(chatMessage)
            
            return responseDto
        } catch (e: Exception) {
            val errorResponse = ChatResponseDto("Error: ${e.message}")
            
            // 에러 응답도 기록
            val chatMessage = ChatMessage(
                id = errorResponse.id,
                question = chatRequestDto.question,
                answer = errorResponse.answer,
                timestamp = LocalDateTime.now()
            )
            chatHistory.add(chatMessage)
            
            return errorResponse
        }
    }
    
    // 채팅 기록 가져오기
    fun getChatHistory(): List<ChatMessage> {
        return chatHistory.toList().reversed() // 최신 메시지가 먼저 오도록 역순 정렬
    }
}