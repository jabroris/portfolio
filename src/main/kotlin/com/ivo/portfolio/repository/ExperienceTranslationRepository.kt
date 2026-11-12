package com.ivo.portfolio.repository

import com.ivo.portfolio.domain.ExperienceTranslation
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceTranslationRepository : JpaRepository<ExperienceTranslation, Long> {
    fun findByExperienceIdInAndLocale(experienceIds: List<Long>, locale: String): List<ExperienceTranslation>
}
