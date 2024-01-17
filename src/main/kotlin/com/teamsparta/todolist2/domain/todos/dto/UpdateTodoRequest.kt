package com.teamsparta.todolist2.domain.todos.dto

data class UpdateTodoRequest(
    val title: String,
    val content: String,
    val name: String,
)
