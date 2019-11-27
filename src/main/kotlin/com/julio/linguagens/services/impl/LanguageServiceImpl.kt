package com.julio.linguagens.services.impl

import com.julio.linguagens.models.Language
import com.julio.linguagens.repositories.LanguageRepository
import com.julio.linguagens.services.LanguageService
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
class LanguageServiceImpl (val languageRepository: LanguageRepository) : LanguageService {

    override fun createLanguage(language: Language) = languageRepository.save(language)

    override fun deleteLanguage(id: Long) = languageRepository.deleteById(id)

    @Throws(NotFoundException::class)
    override fun getLanguage(id: Long): Language {
        val language = languageRepository.findById(id)
        when (language.isPresent) {
            true -> return language.get()
            else -> throw NotFoundException("Linguagem não encontrada")
        }
    }

    override fun getLanguages(): MutableIterable<Language> = languageRepository.findAll()

    override fun updateLanguage(id: Long, language: Language): Language {
        val languageFromDB = this.getLanguage(id)
        languageFromDB.apply {
            this.name = language.name
            this.createdBy = language.createdBy
        }
        return languageRepository.save(languageFromDB)
    }

}