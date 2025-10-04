package com.jsm.bluemarble.account.domain.repository

import com.jsm.bluemarble.account.domain.Account

interface AccountRepository {

    fun save(account: Account): Account
}