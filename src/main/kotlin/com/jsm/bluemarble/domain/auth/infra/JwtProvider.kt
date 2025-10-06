package com.jsm.bluemarble.domain.auth.infra

import com.jsm.bluemarble.config.properties.JwtProperties
import com.jsm.bluemarble.domain.account.domain.Account
import com.jsm.bluemarble.domain.account.infra.entity.Role
import com.jsm.bluemarble.domain.auth.domain.AuthTokenGenerator
import com.jsm.bluemarble.domain.auth.domain.AuthTokenValidator
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider(
    private val props: JwtProperties,
) : AuthTokenGenerator, AuthTokenValidator {

    private val key = Keys.hmacShaKeyFor(props.accessToken.secretKey.toByteArray())

    override fun generateAccessToken(account: Account): String =
        Jwts.builder()
            .signWith(key, Jwts.SIG.HS256)
            .claim("id", account.id)
            .claim("role", account.role)
            .expiration(Date(Date().time + props.accessToken.expirationInSec * 1000))
            .compact()

    override fun generateRefreshToken(): String = UUID.randomUUID().toString().replace("-", "")

    override fun validate(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
            true
        } catch (_: Exception) {
            false
        }
    }

    override fun getAccountId(token: String): Long? {
        return try {
            val claims = getClaims(token)
            claims["id"].toString().toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun getRole(token: String): Role? {
        return try {
            val claims = getClaims(token)
            claims["role"].toString().let { Role.valueOf(it) }
        } catch (_: Exception) {
            null
        }
    }

    private fun getClaims(token: String): Claims = Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .payload
}