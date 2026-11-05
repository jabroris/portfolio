package com.ivo.portfolio.dto.response

import org.hibernate.annotations.LazyGroup

data class ProfileDto(
    val name: String,
    val title: String?,
    val email: String,
    val phone: String?,
    val summary: String?,
    val github: String?,
    val education: EducationDto?,
    val language: MutableList<LanguageDto>?,
    val softSkills: MutableList<String>?
)