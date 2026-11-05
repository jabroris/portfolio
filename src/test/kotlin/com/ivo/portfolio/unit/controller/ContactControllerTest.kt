package com.ivo.portfolio.unit.controller

import com.ivo.portfolio.controller.ContactController
import com.ivo.portfolio.service.ContactService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf

@WebMvcTest(ContactController::class)
class ContactControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var contactService: ContactService

    @Test
    fun shouldAcceptContactMessage() {
//
//        val request = """
//            {
//                "name":"John",
//                "email":"john@test.com",
//                "message":"Hello"
//            }
//        """.trimIndent()
//
//        mockMvc.perform(
//            post("/api/contacts")
//                .with(csrf())
//                .contentType("application/json")
//                .content(request)
//        )
//            .andExpect(status().isCreated)
    }
}