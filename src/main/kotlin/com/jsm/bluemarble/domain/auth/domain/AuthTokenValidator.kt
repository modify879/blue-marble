package com.jsm.bluemarble.domain.auth.domain

import com.jsm.bluemarble.domain.account.infra.entity.Role

interface AuthTokenValidator {

    fun validate(token: String): Boolean

    fun getAccountId(token: String): Long?

    fun getRole(token: String): Role?
}