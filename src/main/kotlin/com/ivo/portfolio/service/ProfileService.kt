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

        return profileRepository.findById(1L).map { profile ->
            ProfileDto(
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
        }.orElseThrow { RuntimeException("Profile not found") }
    }
}