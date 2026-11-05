package com.ivo.portfolio.unit.service

import com.ivo.portfolio.domain.Skill
import com.ivo.portfolio.repository.SkillRepository
import com.ivo.portfolio.service.SkillService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
class SkillServiceTest {

    private val repository = mockk<SkillRepository>()

    private val service = SkillService(repository)

    @Test
    fun `should return all skills`() {

        val skills = listOf(
            Skill(
                id = 1,
                name = "Kotlin",
                level = 5
            )
        )

        every {
            repository.findAll()
        } returns skills

        val result = service.findAll()

        assertEquals(1, result.size)
        assertEquals("Kotlin", result[0].name)
    }
}