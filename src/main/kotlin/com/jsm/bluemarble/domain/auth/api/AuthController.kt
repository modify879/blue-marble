package com.jsm.bluemarble.domain.auth.api

import com.jsm.bluemarble.domain.auth.api.dto.request.LoginRequest
import com.jsm.bluemarble.domain.auth.api.dto.response.AuthTokenResponse
import com.jsm.bluemarble.domain.auth.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth/v1")
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): AuthTokenResponse {
        val authToken = authService.login(loginRequest.username, loginRequest.password)
        return AuthTokenResponse.from(authToken)
    }
}