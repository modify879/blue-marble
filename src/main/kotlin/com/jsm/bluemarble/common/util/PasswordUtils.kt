package com.jsm.bluemarble.common.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

object PasswordUtils {
    private val encoder: PasswordEncoder = BCryptPasswordEncoder()

    fun encodePassword(rawPassword: String): String = encoder.encode(rawPassword)

    fun matchPassword(rawPassword: String, encodedPassword: String): Boolean =
        encoder.matches(rawPassword, encodedPassword)
}