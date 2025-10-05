package com.jsm.bluemarble.domain.account.domain

import com.jsm.bluemarble.common.util.PasswordUtils
import com.jsm.bluemarble.domain.account.infra.entity.Role

data class Account(
    val id: Long?,
    val username: String,
    val password: String,
    val nickname: String,
    val profile: String?,
    val role: Role
) {

    fun matchPassword(password: String): Boolean = PasswordUtils.matchPassword(password, this.password)
}