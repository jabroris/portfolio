package com.ivo.portfolio.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "profiles")
class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var email: String = "",

    @Column(nullable = true)
    var phone: String? = null,

    @Column(nullable = true, columnDefinition = "TEXT")
    var summary: String? = null,

    @Column(nullable = true)
    var title: String? = null,

    @Column(nullable = true)
    var github: String? = null,
)