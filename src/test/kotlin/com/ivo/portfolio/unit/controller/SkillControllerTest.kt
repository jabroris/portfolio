package com.ivo.portfolio.unit.controller

import com.ivo.portfolio.controller.SkillController
import com.ivo.portfolio.domain.Skill
import com.ivo.portfolio.service.SkillService
import io.mockk.every
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(SkillController::class)
class SkillControllerTest(
    @Autowired val mockMvc: MockMvc
) {

    @MockitoBean
    lateinit var service: SkillService

    @Test
    fun shouldReturnSkills() {

//        given(service.findAll())
//            .willReturn(
//                listOf(
//                    Skill(
//                        id = 1,
//                        name = "Kotlin",
//                        level = "5",
//                        category = "Backend"
//                    )
//                )
//            )
//
//        mockMvc.perform(
//            get("/api/skills")
//        )
//            .andExpect(status().isOk)
//            .andExpect(jsonPath("$[0].name").value("Kotlin"))
    }
}