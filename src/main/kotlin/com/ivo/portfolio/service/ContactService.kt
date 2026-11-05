package com.ivo.portfolio.service

import com.ivo.portfolio.repository.ContactMessageRepository
import com.ivo.portfolio.domain.ContactMessage
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val repository: ContactMessageRepository
) {

    fun findAll(): List<ContactMessage> =
        repository.findAll()

    fun save(contactMessage: ContactMessage) =
        repository.save(contactMessage)
}