package org.ninjaware.roadtrip.api

import org.ninjaware.roadtrip.domain.User
import org.ninjaware.roadtrip.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @GetMapping("/ping")
    fun ping() = "pong"

    @PostMapping
    fun insert(@RequestBody user: User) : ResponseEntity<Any>{
        val result = userService.createUser(
                name = user.name,
                email = user.email,
                password = user.password,
                vehicles = user.vehicles)
        return when(result.succes) {
            true -> ResponseEntity.ok(result.value)
            false -> ResponseEntity.badRequest().body(result.message)
        }
    }
}

