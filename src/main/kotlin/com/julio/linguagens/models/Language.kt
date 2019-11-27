package com.julio.linguagens.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "language")
data class Language (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @Column
        var name: String,
        @Column
        var createdBy: String
)