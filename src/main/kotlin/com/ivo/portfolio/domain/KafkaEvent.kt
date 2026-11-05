package com.ivo.portfolio.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "kafka_events")
class KafkaEvent(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var message: String = "",

    var direction: String = "",

    var status: String = "",

    var timestamp: LocalDateTime =
        LocalDateTime.now()
)