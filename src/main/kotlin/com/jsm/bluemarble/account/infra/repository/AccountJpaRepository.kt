package com.jsm.bluemarble.account.infra.repository

import com.jsm.bluemarble.account.infra.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository : JpaRepository<AccountEntity, Long> {
}