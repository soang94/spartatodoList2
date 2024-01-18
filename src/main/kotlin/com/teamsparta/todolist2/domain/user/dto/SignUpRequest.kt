package com.teamsparta.todolist2.domain.user.dto

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
)
