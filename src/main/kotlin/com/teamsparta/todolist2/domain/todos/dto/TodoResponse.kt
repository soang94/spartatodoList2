package com.teamsparta.todolist2.domain.todos.dto

import java.util.*

data class TodoResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createAt: Date,
    val name: String,
    val complete: Boolean,
)
