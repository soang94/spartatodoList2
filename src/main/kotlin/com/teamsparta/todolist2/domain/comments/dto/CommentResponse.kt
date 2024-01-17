package com.teamsparta.todolist2.domain.comments.dto

data class CommentResponse(
    val id: Long,
    val content: String,
    val name: String,
)
