package com.ivo.portfolio.service

import com.ivo.portfolio.dto.response.EducationDto
import com.ivo.portfolio.dto.response.LanguageDto
import org.springframework.stereotype.Service
import com.ivo.portfolio.dto.response.ProfileDto
import com.ivo.portfolio.repository.ProfileRepository
import com.ivo.portfolio.repository.ProfileTranslationRepository
import org.springframework.context.MessageSource
import java.util.Locale

@Service
class ProfileService(
    private val profileRepository: ProfileRepository,
    private val profileTranslationRepository: ProfileTranslationRepository,
    private val messageSource: MessageSource,
) {

    fun getProfile(locale: Locale): ProfileDto {
        val resolvedLocale = resolveLocale(locale)
        val profile = profileRepository.findAll().firstOrNull() ?: return ProfileDto(
            name = "Ivaylo Blagoev",
            title = message("profile.default.title", resolvedLocale),
            summary =
                """
                        Versatile and results-driven Software Engineer with over a decade of experience across fintech,
                        environmental tech, automotive, and betting platforms. Proven expertise in building scalable backend
                        systems using Java, Kotlin, Spring Boot, and Kafka. Adept at working in distributed teams, delivering
                        secure and compliant solutions, and integrating with complex enterprise ecosystems.
                        Passionate about clean architecture, continuous improvement, and solving real-world problems through code.
                    """.trimIndent(),
            email = "inblagoev@gmail.com",
            phone = "+359 887 260 937",
            github = "www.github.com/jabroris",
            education = education(resolvedLocale),
            language = languages(resolvedLocale),
            softSkills = softSkills(resolvedLocale)
        )

        val profileTranslation = if (profile.id != null && resolvedLocale.language != "en") {
            profileTranslationRepository.findByProfileIdAndLocale(profile.id!!, resolvedLocale.language)
        } else {
            null
        }

        return ProfileDto(
            name = profile.name,
            title = profileTranslation?.title ?: profile.title,
            email = profile.email,
            phone = profileTranslation?.phone ?: profile.phone,
            summary = profileTranslation?.summary ?: profile.summary,
            github = profile.github,
            education = education(resolvedLocale),
            language = languages(resolvedLocale),
            softSkills = softSkills(resolvedLocale)
        )
    }

    private fun education(locale: Locale): EducationDto =
        EducationDto(
            period = message("profile.education.period", locale),
            institution = message("profile.education.institution", locale),
            degree = message("profile.education.degree", locale)
        )

    private fun languages(locale: Locale): MutableList<LanguageDto> =
        mutableListOf(
            LanguageDto(name = message("profile.language.english", locale), level = message("profile.level.fluent", locale), percentage = 90),
            LanguageDto(name = message("profile.language.bulgarian", locale), level = message("profile.level.native", locale), percentage = 100),
            LanguageDto(name = message("profile.language.french", locale), level = message("profile.level.beginner", locale), percentage = 20)
        )

    private fun softSkills(locale: Locale): MutableList<String> =
        mutableListOf(
            message("profile.softskill.1", locale),
            message("profile.softskill.2", locale),
            message("profile.softskill.3", locale),
            message("profile.softskill.4", locale),
            message("profile.softskill.5", locale),
            message("profile.softskill.6", locale),
            message("profile.softskill.7", locale)
        )

    private fun message(key: String, locale: Locale): String =
        messageSource.getMessage(key, null, key, locale) ?: key

    private fun resolveLocale(locale: Locale): Locale {
        val language = locale.language.lowercase(Locale.ROOT)
        return if (language in supportedLocales) Locale.forLanguageTag(language) else Locale.ENGLISH
    }

    companion object {
        private val supportedLocales = setOf("en", "bg", "fr")
    }
}