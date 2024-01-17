package com.teamsparta.todolist2.domain.todos.dto

import java.util.*

data class CreateTodoRequest(
    val title: String,
    val content: String,
    val createAt: Date,
    val name: String,
)
