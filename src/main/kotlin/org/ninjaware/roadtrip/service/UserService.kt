package org.ninjaware.roadtrip.service

import org.ninjaware.roadtrip.domain.UUIDGenerator
import org.ninjaware.roadtrip.domain.User
import org.ninjaware.roadtrip.domain.Vehicle
import org.ninjaware.roadtrip.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository) {

    fun findById(id: String) : User? = userRepository.findById(id)?.get()

    fun findByEmail(email: String) : User? = userRepository.findByEmail(email)


    fun createUser(name: String, email: String, password: String, vehicles: List<Vehicle> = emptyList()): Result<User> {
        //  Validate if email adres is unique
        val existingUser = findByEmail(email)
        existingUser?.let {
            return Result("Email address is already in use")
        }

        val user = User(id = UUIDGenerator.next(), name = name, email = email, password = password)
        user.vehicles.addAll(vehicles)
        val createdUser = userRepository.save(user)
        return when (createdUser) {
            null -> Result(succes = false)
            else -> Result(succes = true, value = createdUser)
        }
    }


    fun updateUser(id: String, updated: User): Result<User> {
        val current = userRepository.findById(id)
        return when (current.isPresent) {
            false -> Result(succes = false)
            true -> {
                val user = current.get()
                user.name = updated.name
                user.email = updated.email
                val updatedUser = userRepository.save(user)
                Result(succes = true, value = updatedUser)
            }
        }
    }


    private fun setActive(id: String, active: Boolean): Result<User> {
        val current = userRepository.findById(id)
        return when (current.isPresent) {
            false -> Result(succes = false)
            true -> {
                val user = current.get()
                user.active = active
                val updatedUser = userRepository.save(user)
                Result(succes = true, value = updatedUser)
            }
        }
    }


    fun setActive(id: String) = setActive(id = id, active = true)

    fun setInactive(id: String) = setActive(id = id, active = false)

    fun setPassword(id: String, old: String, new: String): Boolean {
        val current = userRepository.findById(id)
        return when (current.isPresent) {
            false -> false
            true -> {
                val user = current.get()
                user.password = new
                userRepository.save(user)
                true
            }
        }
    }


    fun isPasswordValid(id: String, password: String) : Boolean {
        val current = userRepository.findById(id)
        return when (current.isPresent) {
            false -> false
            true -> {
                current.get().password == password
            }
        }
    }

}