package com.julio.linguagens.services

import com.julio.linguagens.models.Language
import javassist.NotFoundException

import org.springframework.stereotype.Service
import java.util.*

@Service
interface LanguageService {

    fun createLanguage(language: Language): Language
    fun deleteLanguage(id: Long)
    fun getLanguages(): MutableIterable<Language>
    fun getLanguageByName()

    @Throws(NotFoundException::class)
    fun getLanguage(id: Long): Language
    fun updateLanguage(id: Long, language: Language): Language
}