package com.ivo.portfolio.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/kafka")
class KafkaController(
    private val producer: KafkaProducerService,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @PostMapping("/test")
    fun test(): String {

        producer.publish(
            "Hello from Spring Boot"
        )

        return "Message sent"
    }

    @GetMapping("/test")
    fun testFull(): String {

        kafkaTemplate.send(
            "portfolio-events",
            "Hello from Spring Boot"
        )

        return "Message sent"
    }
}