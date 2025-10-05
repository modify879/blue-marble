package com.jsm.bluemarble.domain.auth.api

import com.jsm.bluemarble.domain.auth.domain.AuthToken
import com.jsm.bluemarble.domain.auth.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth/v1")
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/login")
    fun login(
        @RequestParam username: String,
        @RequestParam password: String
    ): AuthToken = authService.login(username, password)
}