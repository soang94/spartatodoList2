package com.teamsparta.todolist2.domain.user.model

import com.teamsparta.todolist2.domain.user.dto.UserResponse
import com.teamsparta.todolist2.domain.user.repository.UserRole
import jakarta.persistence.*

@Entity
@Table(name = "app_user")
class User(
    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "name")
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    val role: UserRole,

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        email =email,
        name = name,
        role = role.name
    )
}