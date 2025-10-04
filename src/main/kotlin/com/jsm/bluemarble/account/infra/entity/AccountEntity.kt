package com.jsm.bluemarble.account.infra.entity

import com.jsm.bluemarble.account.domain.Account
import com.jsm.bluemarble.common.infra.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "account")
class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var username: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false)
    var nickname: String,

    @Column(nullable = true)
    var profile: String? = null,
) : BaseEntity() {
    fun toDomain(): Account = Account(
        id = this.id,
        username = this.username,
        password = this.password,
        nickname = this.nickname,
        profile = this.profile,
    )

    companion object {
        fun from(account: Account): AccountEntity = AccountEntity(
            id = account.id,
            username = account.username,
            password = account.password,
            nickname = account.nickname,
            profile = account.profile,
        )
    }
}