package com.julio.linguagens.models

import javax.persistence.*
import kotlin.random.Random

@Entity(name = "user")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @Column
        var name: String,
        @OneToMany
        var languages: MutableList<Language> = mutableListOf()
)