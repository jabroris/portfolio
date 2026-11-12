package com.ivo.portfolio.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(
    name = "experience_translations",
    uniqueConstraints = [UniqueConstraint(columnNames = ["experience_id", "locale"])]
)
class ExperienceTranslation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "experience_id", nullable = false)
    var experience: Experience? = null,

    @Column(nullable = false, length = 10)
    var locale: String = "",

    @Column(nullable = true)
    var title: String? = null,

    @Column(nullable = true)
    var location: String? = null,

    @Column(nullable = true, columnDefinition = "TEXT")
    var description: String? = null,
)
