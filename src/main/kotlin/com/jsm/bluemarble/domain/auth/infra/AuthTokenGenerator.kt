package com.jsm.bluemarble.domain.auth.infra

import com.jsm.bluemarble.config.properties.JwtProperties
import com.jsm.bluemarble.domain.account.infra.entity.Role
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthTokenGenerator(
    private val props: JwtProperties,
) {
    private val key = Keys.hmacShaKeyFor(props.accessToken.secretKey.toByteArray())

    fun generateAccessToken(id: Long, role: Role): String =
        Jwts.builder()
            .signWith(key, Jwts.SIG.HS256)
            .claim("id", id)
            .claim("role", role)
            .expiration(Date(Date().time + props.accessToken.expirationInSec * 1000))
            .compact()

    fun generateRefreshToken(): String = RandomStringUtils.secure().nextAlphanumeric(props.refreshToken.length)
}