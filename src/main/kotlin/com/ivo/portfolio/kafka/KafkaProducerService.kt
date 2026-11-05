package com.ivo.portfolio.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun publish(message: String) {

        kafkaTemplate.send(
            "portfolio-events",
            message
        )
    }
}