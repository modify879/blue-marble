package com.jsm.bluemarble.domain.auth.api.dto.response

import com.jsm.bluemarble.domain.auth.domain.AuthToken

data class AuthTokenResponse(
    val accessToken: String,
    val refreshToken: String,
) {

    companion object {
        fun from(authToken: AuthToken) = AuthTokenResponse(
            accessToken = authToken.accessToken,
            refreshToken = authToken.refreshToken,
        )
    }
}
