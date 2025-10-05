package com.jsm.bluemarble.domain.account.infra.entity

import com.jsm.bluemarble.common.infra.entity.BaseEntity
import com.jsm.bluemarble.domain.account.domain.Account
import jakarta.persistence.*

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

    @Column(nullable = false)
    var role: Role = Role.USER,
) : BaseEntity() {
    fun toDomain(): Account = Account(
        id = this.id,
        username = this.username,
        password = this.password,
        nickname = this.nickname,
        profile = this.profile,
        role = this.role
    )

    companion object {
        fun from(account: Account): AccountEntity = AccountEntity(
            id = account.id,
            username = account.username,
            password = account.password,
            nickname = account.nickname,
            profile = account.profile,
            role = account.role,
        )
    }
}

enum class Role { USER, ADMIN }