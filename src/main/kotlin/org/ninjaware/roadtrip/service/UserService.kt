package org.ninjaware.roadtrip.service

import org.ninjaware.roadtrip.domain.User
import org.ninjaware.roadtrip.domain.Vehicle
import org.ninjaware.roadtrip.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository) {

    fun createNewUser(name: String, email: String) : Unit{

        val vehicle1 = Vehicle(license = "7-ZPN-00", description = "Mazda 3")
        val vehicle2 = Vehicle(license = "06-LJD-9", description = "Seat Ibiza")
        val vehicles =  listOf(vehicle1, vehicle2)

        val user = User()
        user.name = name
        user.email = email
        user.password = "secret"
        user.vehicles.addAll(vehicles)

        userRepository.insert(user)
    }

}