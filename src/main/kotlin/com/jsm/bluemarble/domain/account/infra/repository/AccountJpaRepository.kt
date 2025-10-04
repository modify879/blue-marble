package com.jsm.bluemarble.domain.account.infra.repository

import com.jsm.bluemarble.domain.account.infra.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository : JpaRepository<AccountEntity, Long> {

    fun findByUsername(username: String): AccountEntity?
}