package com.teamsparta.todolist2.domain.user.service

import com.teamsparta.todolist2.domain.user.dto.SignUpRequest
import com.teamsparta.todolist2.domain.user.dto.UserResponse
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {
    override fun user(userId: Long): UserResponse {
        TODO("Not yet implemented")
    }

    override fun createUser(request: SignUpRequest): UserResponse {
        TODO("Not yet implemented")
    }
}