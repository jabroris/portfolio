package com.ivo.portfolio.controller

import com.ivo.portfolio.service.ExperienceService
import com.ivo.portfolio.service.ProfileService
import com.ivo.portfolio.service.SkillService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.util.Locale


@Controller
class PageController(
    private val profileService: ProfileService,
    private val experienceService: ExperienceService,
    private val skillService: SkillService
) {

    @GetMapping("/")
    fun home(
        model: Model,
        locale: Locale
    ): String {

        model.addAttribute(
            "profile",
            profileService.getProfile(locale)
        )

        model.addAttribute(
            "experiences",
            experienceService.findAll(locale)
        )

        model.addAttribute(
            "skillsByCategory",
            skillService.skillsGroupedByCategory()
        )

        return "home"
    }
}