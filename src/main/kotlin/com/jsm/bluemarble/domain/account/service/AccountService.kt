package com.jsm.bluemarble.domain.account.service

import com.jsm.bluemarble.account.api.dto.request.CreateAccountRequest
import com.jsm.bluemarble.account.api.dto.response.JwtResponse
import com.jsm.bluemarble.account.domain.Account
import com.jsm.bluemarble.account.domain.repository.AccountRepository
import com.jsm.bluemarble.common.util.PasswordUtils
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {

    fun createAccount(request: CreateAccountRequest) {
        if (request.password != request.confirmPassword) {
            throw IllegalArgumentException("Passwords do not match")
        }

        val account = Account(
            id = null,
            username = request.username,
            password = PasswordUtils.encodePassword(request.password),
            nickname = request.nickname,
            profile = null,
        )

        accountRepository.save(account)
    }

    fun login(username: String, password: String): JwtResponse {
        val account = accountRepository.findByUsername(username) ?: throw IllegalArgumentException("login failed")
        if (!PasswordUtils.matchPassword(password, account.password)) {
            throw IllegalArgumentException("login failed")
        }


    }
}