package com.jsm.bluemarble.domain.auth.domain

data class AuthToken(
    val accessToken: String,
    val refreshToken: String,
)
