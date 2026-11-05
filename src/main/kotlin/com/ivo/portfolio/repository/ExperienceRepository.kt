package com.ivo.portfolio.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.ivo.portfolio.domain.Experience
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

@Repository
interface ExperienceRepository : JpaRepository<Experience, Long> {
    @Query("""
        select distinct e
        from Experience e
        join e.technologies t
        where lower(t) like lower(concat('%', :technology, '%'))
    """)
    fun findByTechnology(
        @Param("technology") technology: String
    ): List<Experience>
}