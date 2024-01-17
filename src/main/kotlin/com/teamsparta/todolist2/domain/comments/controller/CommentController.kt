package com.teamsparta.todolist2.domain.comments.controller

import com.teamsparta.todolist2.domain.comments.dto.CommentResponse
import com.teamsparta.todolist2.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todolist2.domain.comments.dto.UpdateCommentRequest
import com.teamsparta.todolist2.domain.comments.service.CommentService
import com.teamsparta.todolist2.domain.todos.service.TodoService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todos/{todoId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService
) {

    @Operation(summary = "댓글 전체 조회")
    @GetMapping
    fun comments(
        @PathVariable todoId: Long
    ): ResponseEntity<List<CommentResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.comments(todoId))
    }

    @Operation(summary = "댓글 단건 조회")
    @GetMapping("/{commentId}")
    fun comment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.comment(todoId, commentId))
    }

    @Operation(summary = "댓글 생성")
    @PostMapping
    fun createComment(
        @PathVariable todoId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(todoId, createCommentRequest))
    }

    @Operation(summary = "댓글 수정")
    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(todoId, commentId, updateCommentRequest))
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
    ): ResponseEntity<Any> {
        commentService.deleteComment(todoId, commentId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("댓글이 삭제 되었습니다.")
    }
}