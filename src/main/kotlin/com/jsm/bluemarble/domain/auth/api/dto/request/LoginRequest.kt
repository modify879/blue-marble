package com.jsm.bluemarble.domain.auth.api.dto.request

data class LoginRequest(
    val username: String,
    val password: String,
)
