package com.ivo.portfolio.repository

import com.ivo.portfolio.domain.ProfileTranslation
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileTranslationRepository : JpaRepository<ProfileTranslation, Long> {
    fun findByProfileIdAndLocale(profileId: Long, locale: String): ProfileTranslation?
}
