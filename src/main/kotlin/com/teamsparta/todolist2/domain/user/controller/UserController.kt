package com.teamsparta.todolist2.domain.user.controller

import com.teamsparta.todolist2.domain.user.dto.SignUpRequest
import com.teamsparta.todolist2.domain.user.dto.UserResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController {

    @Operation(summary = "회원 정보 단건 조회")
    @GetMapping("/{userId}")
    fun user(@PathVariable userId: Long): ResponseEntity<UserResponse> {
        TODO()
    }

    @Operation(summary = "회원가입")
    @PostMapping
    fun createUser(@RequestBody signUpRequest: SignUpRequest): RequestEntity<UserResponse> {
        TODO()
    }
}