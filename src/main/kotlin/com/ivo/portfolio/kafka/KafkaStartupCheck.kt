package com.ivo.portfolio.kafka

import org.springframework.boot.CommandLineRunner
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

//@Component
//class KafkaStartupCheck(
//    private val kafkaTemplate: KafkaTemplate<String, String>
//) : CommandLineRunner {
//
//    override fun run(vararg args: String) {
//
//        kafkaTemplate.send(
//            "portfolio-events",
//            "startup-test"
//        )
//
//        println("Kafka test message sent")
//    }
//}