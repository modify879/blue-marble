package com.jsm.bluemarble.domain.account.domain.repository

import com.jsm.bluemarble.domain.account.domain.Account

interface AccountRepository {

    fun save(account: Account): Account

    fun findByUsername(username: String): Account?
}