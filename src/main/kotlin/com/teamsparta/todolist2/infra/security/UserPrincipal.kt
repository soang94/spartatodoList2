package com.teamsparta.todolist2.infra.security

import org.springframework.security.core.GrantedAuthority

data class UserPrincipal(
    val id: Long,
    val email: String,
    val authorities: Collection<GrantedAuthority>
) {
//    constructor(id: Long, email: String): this(
//        id,
//        email,
//    )
}
