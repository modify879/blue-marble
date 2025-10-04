package com.jsm.bluemarble.account.domain

data class Account(
    val id: Long?,
    val username: String,
    val password: String,
    val nickname: String,
    val profile: String?,
)