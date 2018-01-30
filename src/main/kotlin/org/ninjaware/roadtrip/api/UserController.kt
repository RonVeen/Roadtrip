package org.ninjaware.roadtrip.api

import org.ninjaware.roadtrip.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @GetMapping("/ping")
    fun ping() = "pong"

    @PostMapping
    fun insert() : ResponseEntity<Any>{
        val name = LocalDateTime.now().toString()
        userService.createNewUser(name = name, email = name + "@gmail.com")
        return ResponseEntity.ok().build()
    }

}

