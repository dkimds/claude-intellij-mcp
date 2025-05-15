package com.example.demo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {

    @Value("\${fastapi.base-url:http://localhost:8000}")
    private lateinit var fastApiBaseUrl: String

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
    
    @Bean
    fun fastApiBaseUrl(): String {
        return fastApiBaseUrl
    }
}