package org.ninjaware.roadtrip.api

import org.ninjaware.roadtrip.domain.User
import org.ninjaware.roadtrip.service.Result
import org.ninjaware.roadtrip.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping("/ping")
    fun ping() = "pong"


    @GetMapping("{id}")
    fun get(@PathVariable("id") id: String): ResponseEntity<Any> {
        val result: Result<Any> = userService.findById(id)
        return when(result.succes) {
            true -> ResponseEntity.ok(result.value)
            false -> ResponseEntity.badRequest().body(result.message)
        }
    }


    @GetMapping
    fun getByEmail(@RequestParam("email") email: String): ResponseEntity<Any> {
        val result: Result<Any> = userService.findByEmail(email)
        return when(result.succes) {
            true -> ResponseEntity.ok(result.value)
            false -> ResponseEntity.badRequest().body(result.message)
        }
    }



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

    @DeleteMapping("{email:.+}")
    fun delete(@PathVariable("email") email: String) : ResponseEntity<Any> {
        val result: Result<String> = userService.removeByEmail(email)
        return when(result.succes) {
            true -> ResponseEntity.ok("")
            false -> ResponseEntity.badRequest().body(result.message)
        }
    }



}

