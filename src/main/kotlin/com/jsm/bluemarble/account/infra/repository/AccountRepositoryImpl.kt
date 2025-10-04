package com.jsm.bluemarble.account.infra.repository

import com.jsm.bluemarble.account.domain.Account
import com.jsm.bluemarble.account.domain.repository.AccountRepository
import com.jsm.bluemarble.account.infra.entity.AccountEntity
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImpl(
    private val jpaRepository: AccountJpaRepository
) : AccountRepository {

    override fun save(account: Account): Account = jpaRepository.save(AccountEntity.from(account)).toDomain()
}