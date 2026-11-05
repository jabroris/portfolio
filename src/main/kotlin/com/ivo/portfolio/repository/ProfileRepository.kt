package com.ivo.portfolio.repository

import com.ivo.portfolio.domain.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, Long>