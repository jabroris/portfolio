package com.ivo.portfolio.controller

import com.ivo.portfolio.service.ExperienceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/experiences")
class ExperienceController(
    private val experienceService: ExperienceService
) {

    @GetMapping
    fun findAll() =
        experienceService.findAll()

    @GetMapping("/search")
    fun search(
        @RequestParam technology: String
    ) = experienceService.searchByTechnology(technology)
}