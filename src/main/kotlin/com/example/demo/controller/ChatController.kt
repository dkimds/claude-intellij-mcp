package com.example.demo.controller

import com.example.demo.dto.ChatRequestDto
import com.example.demo.service.ChatService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ChatController(private val chatService: ChatService) {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("request", ChatRequestDto(""))
        model.addAttribute("response", "")
        model.addAttribute("chatHistory", chatService.getChatHistory())
        return "chat"
    }

    @GetMapping("/chat")
    fun chat(@RequestParam question: String, model: Model): String {
        val chatRequestDto = ChatRequestDto(question)
        val responseDto = chatService.sendQuestion(chatRequestDto)
        
        model.addAttribute("request", ChatRequestDto("")) // 입력창 비우기
        model.addAttribute("response", responseDto.answer)
        model.addAttribute("chatHistory", chatService.getChatHistory())
        return "chat"
    }
}