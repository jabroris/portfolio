package com.ivo.portfolio.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.ivo.portfolio.domain.Project

@Repository
interface ProjectRepository : JpaRepository<Project, Long>