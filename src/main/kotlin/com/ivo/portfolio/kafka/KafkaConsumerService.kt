package com.ivo.portfolio.kafka

import com.ivo.portfolio.domain.KafkaEvent
import com.ivo.portfolio.repository.KafkaEventRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
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