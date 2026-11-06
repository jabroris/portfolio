package com.ivo.portfolio.kafka

import com.ivo.portfolio.domain.KafkaEvent
import com.ivo.portfolio.repository.KafkaEventRepository
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
@Profile("!gcp")
class KafkaConsumerService(
    private val repository: KafkaEventRepository,
) {

    @KafkaListener(
        topics = ["portfolio-events"],
        groupId = "portfolio"
    )
    fun consume(message: String) {

        repository.save(
            KafkaEvent(
                message = message,
                direction = "CONSUMED",
                status = "OK"
            )
        )
    }
}