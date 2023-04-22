package com.org.chad.resource

import com.org.chad.model.Pilgrim
import com.org.chad.repo.PilgrimRepository
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chad") // bc why not
class PilgrimResource (
    private val pilgrimRepository: PilgrimRepository
) {
    private val LOG = KotlinLogging.logger {  }

    @PutMapping("/register/")
    fun register(@RequestBody user: Pilgrim): ResponseEntity<Pilgrim> {
        LOG.info("PUT /chad/register/ ${user.name}")
        val pg = pilgrimRepository.register(user.name, user.username, user.password)
            ?: return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        return ResponseEntity(pg, HttpStatus.CREATED)
    }

    @GetMapping("/login/")
    fun login(@RequestParam username: String, @RequestParam password: String): ResponseEntity<Pilgrim> {
        LOG.info("GET /chad/login/ $username")
        val pg = pilgrimRepository.login(username, password) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(pg, HttpStatus.FOUND)
    }

}