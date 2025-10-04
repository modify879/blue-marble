package com.jsm.bluemarble.domain.account.api.dto.request

data class CreateAccountRequest(
    val username: String,
    val password: String,
    val confirmPassword: String,
    val nickname: String,
)
