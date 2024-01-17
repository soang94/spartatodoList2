package com.teamsparta.todolist2.domain.comments.dto

import java.util.*

data class UpdateCommentRequest(
    val content: String,
    val createAt: Date,
    val name: String,
)
