package com.ivo.portfolio.controller

import com.ivo.portfolio.service.ContactService
import com.ivo.portfolio.domain.ContactMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@RestController
@RequestMapping("/api/contacts")
class ContactController(
    private val contactService: ContactService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(
        @RequestBody contactMessage: ContactMessage
    ) {
        contactService.save(contactMessage)
    }
}