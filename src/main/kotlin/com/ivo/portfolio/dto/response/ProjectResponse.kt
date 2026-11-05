package com.ivo.portfolio.dto.response

data class ProjectResponse(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val projectUrl: String
)