package com.teamsparta.todolist2.domain.todos.service

import com.teamsparta.todolist2.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest

class TodoServiceImpl: TodoService {
    override fun todos(cardId: Long): List<TodoResponse> {
        TODO("Not yet implemented")
    }

    override fun todo(cardId: Long, todoId: Long): TodoResponse {
        TODO("Not yet implemented")
    }

    override fun createTodo(cardId: Long, request: CreateTodoRequest): TodoResponse {
        TODO("Not yet implemented")
    }

    override fun updateTodo(cardId: Long, todoId: Long, request: UpdateTodoRequest): TodoResponse {
        TODO("Not yet implemented")
    }

    override fun deleteTodo(cardId: Long, todoId: Long) {
        TODO("Not yet implemented")
    }
}