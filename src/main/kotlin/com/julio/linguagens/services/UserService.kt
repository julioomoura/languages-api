package com.julio.linguagens.services

import com.julio.linguagens.models.Language
import com.julio.linguagens.models.User
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
interface UserService {

    fun createUser(user: User): User
    fun createUserLanguages(id: Long, languages: List<Language>): User
    @Throws(NotFoundException::class)
    fun findUserById(id: Long): User
    fun findUsers(): MutableIterable<User>
    fun deleteUserById(id: Long)
    fun updateUser(id:Long, user: User): User
}