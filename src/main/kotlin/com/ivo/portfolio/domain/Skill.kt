package com.ivo.portfolio.domain

import jakarta.persistence.*

@Entity
@Table(name = "skills")
class Skill(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var level: Int = 0,

    @Column(nullable = true)
    var category: String = ""
)