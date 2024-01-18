package com.teamsparta.todolist2.domain.user.service

import com.teamsparta.todolist2.domain.exception.ModelNotFoundException
import com.teamsparta.todolist2.domain.user.dto.SignUpRequest
import com.teamsparta.todolist2.domain.user.dto.UserResponse
import com.teamsparta.todolist2.domain.user.model.User
import com.teamsparta.todolist2.domain.user.model.toResponse
import com.teamsparta.todolist2.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    override fun user(userId: Long): UserResponse {
        val user= userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("user", userId)

        return user.toResponse()
    }

    override fun createUser(request: SignUpRequest): UserResponse {
        return userRepository.save(
            User (
                email = request.email,
                password = request.password,
                name = request.name
            )
        ).toResponse()
    }
}