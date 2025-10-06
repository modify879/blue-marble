package com.jsm.bluemarble.domain.auth.domain

import com.jsm.bluemarble.domain.account.domain.Account

interface AuthTokenGenerator {

    fun generateAccessToken(account: Account): String

    fun generateRefreshToken(): String
}