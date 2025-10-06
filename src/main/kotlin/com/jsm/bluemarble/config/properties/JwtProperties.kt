package com.jsm.bluemarble.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "auth.token")
data class JwtProperties(
    val accessToken: AccessToken,
    val refreshToken: RefreshToken
) {
    data class AccessToken(
        val secretKey: String,
        val expirationInSec: Int,
    )

    data class RefreshToken(
        val expirationInSec: Int,
    )
}