package com.ivo.portfolio.service

import com.ivo.portfolio.repository.ExperienceRepository
import com.ivo.portfolio.domain.Experience
import org.springframework.stereotype.Service

@Service
class ExperienceService(
    private val repository: ExperienceRepository
) {

    fun findAll(): List<Experience> =
        repository.findAll()

    fun searchByTechnology(
        technology: String
    ): List<Experience> =
        repository.findByTechnology(technology)
}