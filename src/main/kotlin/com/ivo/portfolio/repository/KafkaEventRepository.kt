package com.ivo.portfolio.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.ivo.portfolio.domain.KafkaEvent

interface KafkaEventRepository : JpaRepository<KafkaEvent, Long>