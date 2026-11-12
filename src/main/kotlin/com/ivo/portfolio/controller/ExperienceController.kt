package com.ivo.portfolio.controller

import com.ivo.portfolio.service.ExperienceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@RestController
@RequestMapping("/api/experiences")
class ExperienceController(
    private val experienceService: ExperienceService
) {

    @GetMapping
    fun findAll(locale: Locale) =
        experienceService.findAll(locale)

    @GetMapping("/search")
    fun search(
        @RequestParam technology: String,
        locale: Locale
    ) = experienceService.searchByTechnology(technology, locale)
}