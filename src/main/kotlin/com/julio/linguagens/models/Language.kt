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
        var id: Long? = null
) {
    @Column(unique = true)
    var name: String? = null
    @Column
    var createdBy: String? = null
}