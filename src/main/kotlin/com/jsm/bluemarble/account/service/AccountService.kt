package com.jsm.bluemarble.account.service

import com.jsm.bluemarble.account.api.dto.request.CreateAccountRequest
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
}