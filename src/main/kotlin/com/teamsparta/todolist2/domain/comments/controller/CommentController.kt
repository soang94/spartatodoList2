package com.teamsparta.todolist2.domain.comments.controller

import com.teamsparta.todolist2.domain.comments.dto.CommentResponse
import com.teamsparta.todolist2.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todolist2.domain.comments.dto.UpdateCommentRequest
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards/{cardId}/todos/{todoId}/comments")
@RestController
class CommentController {

    @Operation(summary = "댓글 전체 조회")
    @GetMapping
    fun comments(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long
    ): ResponseEntity<List<CommentResponse>> {
        TODO()
    }

    @Operation(summary = "댓글 단건 조회")
    @GetMapping("/{commentId}")
    fun comment(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long,
        @PathVariable commentId: Long
    ): ResponseEntity<CommentResponse> {
        TODO()
    }

    @Operation(summary = "댓글 생성")
    @PostMapping
    fun createComment(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        TODO()
    }

    @Operation(summary = "댓글 수정")
    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        TODO()
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
    ): ResponseEntity<Any> {
        TODO()
    }
}