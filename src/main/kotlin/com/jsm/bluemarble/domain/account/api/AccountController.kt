package com.jsm.bluemarble.domain.account.api

import com.jsm.bluemarble.domain.account.api.dto.request.CreateAccountRequest
import com.jsm.bluemarble.domain.account.service.AccountService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/account/v1")
class AccountController(
    private val accountService: AccountService,
) {

    @PostMapping
    fun createAccount(@RequestBody request: CreateAccountRequest) {
        accountService.createAccount(request)
    }
}