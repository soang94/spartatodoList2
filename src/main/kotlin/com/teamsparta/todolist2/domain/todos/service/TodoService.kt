package com.teamsparta.todolist2.domain.todos.service

import com.teamsparta.todolist2.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest

interface TodoService {

    fun todos(cardId: Long): List<TodoResponse>

    fun todo(cardId: Long, todoId: Long): TodoResponse

    fun createTodo(cardId: Long, request: CreateTodoRequest): TodoResponse

    fun updateTodo(cardId: Long, todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun deleteTodo(cardId: Long, todoId: Long)

    fun completeTodo(cardId: Long, todoId: Long)
}