package com.ivo.portfolio.kafka

import org.springframework.context.annotation.Profile
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
@Profile("!gcp")
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