package com.ivo.portfolio.service

import com.ivo.portfolio.repository.SkillRepository
import com.ivo.portfolio.domain.Skill
import org.springframework.stereotype.Service

@Service
class SkillService(
    private val repository: SkillRepository
) {

    fun findAll(): List<Skill> =
        repository.findAll()

    fun skillsGroupedByCategory(): Map<String, List<Skill>> =
        repository.findAll()
            .groupBy { it.category }
}