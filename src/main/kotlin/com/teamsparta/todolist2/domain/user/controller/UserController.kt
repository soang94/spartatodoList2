package com.teamsparta.todolist2.domain.user.controller

import com.teamsparta.todolist2.domain.user.dto.SignUpRequest
import com.teamsparta.todolist2.domain.user.dto.UserResponse
import com.teamsparta.todolist2.domain.user.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping
@RestController
class UserController(
    private val userService: UserService
) {

    @Operation(summary = "회원 정보 단건 조회")
    @GetMapping("/users/{userId}")
    fun user(@PathVariable userId: Long): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.user(userId))
    }

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    fun createUser(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.signUp(signUpRequest))
    }
}