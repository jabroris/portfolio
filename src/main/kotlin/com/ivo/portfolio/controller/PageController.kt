package com.ivo.portfolio.controller

import com.ivo.portfolio.service.ExperienceService
import com.ivo.portfolio.service.ProfileService
import com.ivo.portfolio.service.SkillService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PageController(
    private val profileService: ProfileService,
    private val experienceService: ExperienceService,
    private val skillService: SkillService
) {

    @GetMapping("/")
    fun home(model: Model): String {

        model.addAttribute(
            "profile",
            profileService.getProfile()
        )

        model.addAttribute(
            "experiences",
            experienceService.findAll()
        )

        model.addAttribute(
            "skillsByCategory",
            skillService.skillsGroupedByCategory()
        )

        return "home"
    }
}