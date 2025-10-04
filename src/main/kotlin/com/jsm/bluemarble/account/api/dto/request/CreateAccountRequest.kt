package com.jsm.bluemarble.account.api.dto.request

import com.jsm.bluemarble.account.domain.Account

data class CreateAccountRequest(
    val username: String,
    val password: String,
    val confirmPassword: String,
    val nickname: String,
)
