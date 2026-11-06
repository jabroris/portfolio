package com.ivo.portfolio.controller

import com.ivo.portfolio.dto.request.PublishEventRequest
import com.ivo.portfolio.kafka.KafkaProducerService
import com.ivo.portfolio.repository.KafkaEventRepository
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
@Profile("!gcp")
class KafkaEventController(
    private val repository: KafkaEventRepository,
    private val producer: KafkaProducerService
) {

    @GetMapping
    fun findAll() =
        repository.findAll()

    @PostMapping("/publish")
    fun publish(
        @RequestBody request: PublishEventRequest
    ): Map<String, String> {

        producer.publish(request.message)

        return mapOf(
            "result" to "Message published"
        )
    }
}