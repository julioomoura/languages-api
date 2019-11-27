package com.julio.linguagens.services.impl

import com.julio.linguagens.models.User
import com.julio.linguagens.repositories.UserRepository
import com.julio.linguagens.services.UserService
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        val userRepository: UserRepository
) : UserService{
    override fun createUser(user: User) = userRepository.save(user)

    override fun deleteUserById(id: Long) = userRepository.deleteById(id)

    @Throws(NotFoundException::class)
    override fun findUserById(id: Long): User {
        val user = userRepository.findById(id)
        when (user.isPresent) {
            true -> return user.get()
            else -> throw (NotFoundException("Usuário não encontrado!"))
        }
    }

    override fun findUsers(): MutableIterable<User> = userRepository.findAll()

    override fun updateUser(id: Long, user: User): User {
        val userToUpdate = this.findUserById(id)
        return userRepository.save(userToUpdate.apply {
            this.languages = user.languages
            this.name = user.name
        })
    }

}