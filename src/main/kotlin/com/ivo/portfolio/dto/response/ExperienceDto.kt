package com.ivo.portfolio.dto.response

data class ExperienceDto(
    val id: Long?,
    val company: String,
    val title: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val description: String,
    val technologies: List<String>
)
