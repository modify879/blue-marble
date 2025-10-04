package com.jsm.bluemarble.domain.account.domain

data class Account(
    val id: Long?,
    val username: String,
    val password: String,
    val nickname: String,
    val profile: String?,
)