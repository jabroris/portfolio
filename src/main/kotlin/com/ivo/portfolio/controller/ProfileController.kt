package com.ivo.portfolio.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.ivo.portfolio.service.ProfileService
import java.util.Locale

@RestController
@RequestMapping("/api/profile")
class ProfileController(
    private val profileService: ProfileService
) {

    @GetMapping
    fun getProfile(locale: Locale) =
        profileService.getProfile(locale)
}