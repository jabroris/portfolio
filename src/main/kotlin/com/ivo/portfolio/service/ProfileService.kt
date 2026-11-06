package com.ivo.portfolio.service

import com.ivo.portfolio.dto.response.EducationDto
import com.ivo.portfolio.dto.response.LanguageDto
import org.springframework.stereotype.Service
import com.ivo.portfolio.dto.response.ProfileDto
import com.ivo.portfolio.repository.ProfileRepository

@Service
class ProfileService(
    private val profileRepository: ProfileRepository,
) {

    fun getProfile(): ProfileDto {
        val profile = profileRepository.findAll().firstOrNull() ?: return ProfileDto(
            name = "Ivaylo Blagoev",
            title = "Senior Software Engineer",
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
            education =
                EducationDto(
                    period = "2007 – 2011", // Hardcoded period for now
                    institution = "George Mason University, USA", // Hardcoded institution for now
                    degree = "BSc in Computer Science" // Hardcoded degree for now
                ),
            language = mutableListOf(
                LanguageDto(name = "English", level = "Fluent", percentage = 90),
                LanguageDto(name = "Bulgarian", level = "Native", percentage = 100),
                LanguageDto(name = "French", level = "Beginner", percentage = 20)
            ),
            softSkills = mutableListOf(
                "Clear communication",
                "Problem solving",
                "Teamwork",
                "Adaptability",
                "Autonomy",
                "Cultural & professional flexibility",
                "Knowledge sharing"
            )
        )
        return ProfileDto(
            name = profile.name,
            title = profile.title,
            email = profile.email,
            phone = profile.phone,
            summary = profile.summary,
            github = profile.github,
            education =
                EducationDto(
                    period = "2007 – 2011", // Hardcoded period for now
                    institution = "George Mason University, USA", // Hardcoded institution for now
                    degree = "BSc in Computer Science" // Hardcoded degree for now
                ),
            language = mutableListOf(
                LanguageDto(name = "English", level = "Fluent", percentage = 90),
                LanguageDto(name = "Bulgarian", level = "Native", percentage = 100),
                LanguageDto(name = "French", level = "Beginner", percentage = 20)
            ),
            softSkills = mutableListOf(
                "Clear communication",
                "Problem solving",
                "Teamwork",
                "Adaptability",
                "Autonomy",
                "Cultural & professional flexibility",
                "Knowledge sharing"
            )
        )
    }
}