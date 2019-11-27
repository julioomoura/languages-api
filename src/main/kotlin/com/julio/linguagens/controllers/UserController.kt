package com.julio.linguagens.controllers

import com.julio.linguagens.models.Language
import com.julio.linguagens.models.User
import com.julio.linguagens.services.LanguageService
import com.julio.linguagens.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController (
        val userService: UserService,
        val languageService: LanguageService
) {

    @GetMapping
    fun getUsers(): ResponseEntity<MutableIterable<User>> {
        val users = userService.findUsers()
        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.findUserById(id)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.createUser(user)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUserById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    fun updateUser(
            @PathVariable
            id: Long,
            @RequestBody
            user: User
    ): ResponseEntity<User> {
        val updatedUser = userService.updateUser(id, user)
        return ResponseEntity(updatedUser, HttpStatus.OK)
    }

    @PostMapping("/{id}/languages")
    fun createUserLanguages(
        @PathVariable
        id: Long,
        @RequestBody
        languages: List<Language>
    ): ResponseEntity<User> {
        val user = userService.findUserById(id)
        val languagesFromDB = languages.map{
            languageService.getLanguageByName(it.name!!, it.createdBy!!)
        }
        val createdLanguages = userService.createUserLanguages(id, languagesFromDB)
        return ResponseEntity(createdLanguages, HttpStatus.OK)


    }
}