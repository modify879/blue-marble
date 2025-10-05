package com.jsm.bluemarble.domain.account.service

import com.jsm.bluemarble.common.util.PasswordUtils
import com.jsm.bluemarble.domain.account.api.dto.request.CreateAccountRequest
import com.jsm.bluemarble.domain.account.domain.Account
import com.jsm.bluemarble.domain.account.domain.repository.AccountRepository
import com.jsm.bluemarble.domain.account.infra.entity.Role
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
            role = Role.USER,
        )

        accountRepository.save(account)
    }
}