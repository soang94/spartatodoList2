package com.teamsparta.todolist2.domain.user.service

import com.teamsparta.todolist2.domain.exception.InvalidCredentialException
import com.teamsparta.todolist2.domain.exception.ModelNotFoundException
import com.teamsparta.todolist2.domain.user.dto.LoginRequest
import com.teamsparta.todolist2.domain.user.dto.LoginResponse
import com.teamsparta.todolist2.domain.user.dto.SignUpRequest
import com.teamsparta.todolist2.domain.user.dto.UserResponse
import com.teamsparta.todolist2.domain.user.model.User
import com.teamsparta.todolist2.domain.user.model.toResponse
import com.teamsparta.todolist2.domain.user.repository.UserRepository
import com.teamsparta.todolist2.domain.user.repository.UserRole
import com.teamsparta.todolist2.infra.security.jwt.JwtPlugin
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
): UserService {
    override fun user(userId: Long): UserResponse {
        val user= userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("user", userId)

        return user.toResponse()
    }

    override fun signUp(request: SignUpRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalStateException("Email is already in use")
        }
        return userRepository.save(
            User (
                email = request.email,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                role = when (request.role) {
                    "ADMIN" -> UserRole.ADMIN
                    "MEMBER" -> UserRole.MEMBER
                    else -> throw IllegalArgumentException("Invalid role")
                }
            )
        ).toResponse()
    }

    override fun login(request: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(request.email) ?: throw  ModelNotFoundException("User", null)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw InvalidCredentialException()
        }

        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = user.email,
            )
        )
    }
}