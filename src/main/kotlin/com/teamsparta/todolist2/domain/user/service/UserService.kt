package com.teamsparta.todolist2.domain.user.service

import com.teamsparta.todolist2.domain.user.dto.LoginRequest
import com.teamsparta.todolist2.domain.user.dto.LoginResponse
import com.teamsparta.todolist2.domain.user.dto.SignUpRequest
import com.teamsparta.todolist2.domain.user.dto.UserResponse

interface UserService {
    fun user(userId: Long): UserResponse

    fun signUp(request: SignUpRequest): UserResponse

    fun login(request: LoginRequest): LoginResponse
}