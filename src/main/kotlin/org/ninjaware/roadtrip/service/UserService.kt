package org.ninjaware.roadtrip.service

import org.ninjaware.roadtrip.domain.User
import org.ninjaware.roadtrip.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository) {

    fun createNewUser(name: String, email: String) : Unit{
        val user = User()
        user.name = name
        user.email = email
        userRepository.insert(user)
    }

}