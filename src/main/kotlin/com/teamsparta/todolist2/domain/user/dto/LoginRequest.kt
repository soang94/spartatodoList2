package com.teamsparta.todolist2.domain.user.dto

data class LoginRequest(
    val email: String,
    val password: String,
)