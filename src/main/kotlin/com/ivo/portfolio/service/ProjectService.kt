package com.ivo.portfolio.service

import com.ivo.portfolio.repository.ProjectRepository
import com.ivo.portfolio.domain.Project
import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val repository: ProjectRepository
) {

    fun findAll(): List<Project> =
        repository.findAll()

}