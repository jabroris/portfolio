package com.ivo.portfolio.domain

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "experience")
class Experience(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var company: String = "",

    var title: String = "",

    var location: String = "",

    var startDate: String = "",

    var endDate: String = "",

    @Column(length = 5000)
    var description: String = "",

    @ElementCollection
    var technologies: MutableList<String> = mutableListOf()
)