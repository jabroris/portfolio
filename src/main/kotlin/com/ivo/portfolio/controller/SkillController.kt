package com.ivo.portfolio.controller

import com.ivo.portfolio.service.SkillService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/skills")
class SkillController(
    private val skillService: SkillService
) {

    @GetMapping
    fun findAll() =
        skillService.findAll()
}