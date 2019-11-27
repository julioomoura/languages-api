package com.julio.linguagens.controllers

import com.julio.linguagens.models.Language
import com.julio.linguagens.services.LanguageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/languages")
class LanguageController (val languageService: LanguageService){

    @PostMapping
    fun createLanguage(@RequestBody language: Language): ResponseEntity<Language> {
        val createdLanguage = languageService.createLanguage(language)
        return ResponseEntity(language, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteLanguage(@PathVariable id: Long): ResponseEntity<Void> {
        languageService.deleteLanguage(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getLanguage(@PathVariable id: Long): ResponseEntity<Language> {
        val language = languageService.getLanguage(id)
        return ResponseEntity(language, HttpStatus.OK)
    }

    @GetMapping
    fun getLanguages(): ResponseEntity<MutableIterable<Language>> {
        val languages = languageService.getLanguages()
        return ResponseEntity(languages, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateLanguage(
        @RequestBody language: Language,
        @PathVariable id: Long
    ): ResponseEntity<Language> {
        val language = languageService.updateLanguage(id, language)
        return ResponseEntity(language, HttpStatus.OK)
    }
}