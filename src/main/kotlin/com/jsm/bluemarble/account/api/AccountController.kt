package com.jsm.bluemarble.account.api

import com.jsm.bluemarble.account.api.dto.request.CreateAccountRequest
import com.jsm.bluemarble.account.service.AccountService
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