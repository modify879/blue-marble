package com.jsm.bluemarble.domain.account.infra.repository

import com.jsm.bluemarble.domain.account.domain.Account
import com.jsm.bluemarble.domain.account.domain.repository.AccountRepository
import com.jsm.bluemarble.domain.account.infra.entity.AccountEntity
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImpl(
    private val jpaRepository: AccountJpaRepository
) : AccountRepository {

    override fun save(account: Account): Account = jpaRepository.save(AccountEntity.from(account)).toDomain()

    override fun findByUsername(username: String): Account? = jpaRepository.findByUsername(username)?.toDomain()
}