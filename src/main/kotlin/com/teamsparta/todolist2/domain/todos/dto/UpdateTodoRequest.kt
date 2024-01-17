package com.teamsparta.todolist2.domain.todos.dto

import java.util.*

data class UpdateTodoRequest(
    val title: String,
    val content: String,
    val name: String,
)
