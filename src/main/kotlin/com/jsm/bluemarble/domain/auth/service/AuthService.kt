package com.jsm.bluemarble.domain.auth.service

import com.jsm.bluemarble.domain.account.domain.repository.AccountRepository
import com.jsm.bluemarble.domain.auth.domain.AuthToken
import com.jsm.bluemarble.domain.auth.infra.AuthTokenGenerator
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val accountRepository: AccountRepository,
    private val authTokenGenerator: AuthTokenGenerator,
) {

    fun login(username: String, password: String): AuthToken {
        val account = accountRepository.findByUsername(username) ?: throw IllegalArgumentException("login failed")

        if (!account.matchPassword(password)) {
            throw IllegalArgumentException("login failed")
        }

        val accessToken = authTokenGenerator.generateAccessToken(account.id!!, account.role)
        val refreshToken = authTokenGenerator.generateRefreshToken()

        return AuthToken(accessToken, refreshToken)
    }
}