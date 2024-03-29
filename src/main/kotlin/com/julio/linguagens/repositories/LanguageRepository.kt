package com.julio.linguagens.repositories

import com.julio.linguagens.models.Language
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageRepository : CrudRepository <Language, Long>{
    fun findByName(name: String): Optional<Language>
}