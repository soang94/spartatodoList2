package com.teamsparta.todolist2.domain.comments.service

import com.teamsparta.todolist2.domain.comments.dto.CommentResponse
import com.teamsparta.todolist2.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todolist2.domain.comments.dto.UpdateCommentRequest

interface CommentService {
    fun comments(todoId: Long): List<CommentResponse>

    fun comment(todoId: Long, commentId: Long): CommentResponse

    fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse

    fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(todoId: Long, commentId: Long)
}