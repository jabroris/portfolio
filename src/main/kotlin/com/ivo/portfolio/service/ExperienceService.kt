package com.ivo.portfolio.service

import com.ivo.portfolio.repository.ExperienceRepository
import com.ivo.portfolio.domain.Experience
import com.ivo.portfolio.dto.response.ExperienceDto
import com.ivo.portfolio.repository.ExperienceTranslationRepository
import org.springframework.stereotype.Service
import java.util.Locale

@Service
class ExperienceService(
    private val repository: ExperienceRepository,
    private val experienceTranslationRepository: ExperienceTranslationRepository
) {

    fun findAll(locale: Locale): List<ExperienceDto> =
        localizeExperiences(repository.findAll(), resolveLocale(locale))

    fun searchByTechnology(
        technology: String,
        locale: Locale
    ): List<ExperienceDto> =
        localizeExperiences(repository.findByTechnology(technology), resolveLocale(locale))

    private fun localizeExperiences(
        experiences: List<Experience>,
        locale: String
    ): List<ExperienceDto> {
        if (experiences.isEmpty() || locale == "en") {
            return experiences.map { it.toDto() }
        }

        val experienceIds = experiences.mapNotNull { it.id }
        if (experienceIds.isEmpty()) {
            return experiences.map { it.toDto() }
        }

        val translations = experienceTranslationRepository
            .findByExperienceIdInAndLocale(experienceIds, locale)
            .associateBy { it.experience?.id }

        return experiences.map { experience ->
            val translation = translations[experience.id]
            experience.toDto(
                translatedTitle = translation?.title,
                translatedLocation = translation?.location,
                translatedDescription = translation?.description
            )
        }
    }

    private fun Experience.toDto(
        translatedTitle: String? = null,
        translatedLocation: String? = null,
        translatedDescription: String? = null
    ): ExperienceDto =
        ExperienceDto(
            id = id,
            company = company,
            title = translatedTitle ?: title,
            location = translatedLocation ?: location,
            startDate = startDate,
            endDate = endDate,
            description = translatedDescription ?: description,
            technologies = technologies.toList()
        )

    private fun resolveLocale(locale: Locale): String {
        val language = locale.language.lowercase(Locale.ROOT)
        return if (language in supportedLocales) language else "en"
    }

    companion object {
        private val supportedLocales = setOf("en", "bg", "fr")
    }
}