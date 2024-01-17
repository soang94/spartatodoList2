package com.teamsparta.todolist2.domain.todos.service

import com.teamsparta.todolist2.domain.todos.model.Todo
import com.teamsparta.todolist2.domain.cards.repository.CardRepository
import com.teamsparta.todolist2.domain.exception.ModelNotFoundException
import com.teamsparta.todolist2.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist2.domain.todos.model.toResponse
import com.teamsparta.todolist2.domain.todos.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    private val cardRepository: CardRepository,
    private val todoRepository: TodoRepository
): TodoService {
    override fun todos(cardId: Long): List<TodoResponse> {
        val todos = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)

        return todos.todo.map { it.toResponse() }
    }

    override fun todo(cardId: Long, todoId: Long): TodoResponse {
        val todo = todoRepository.findCardIdAndTodoId(cardId, todoId) ?: throw ModelNotFoundException("todo", todoId)

        return todo.toResponse()
    }

    override fun createTodo(cardId: Long, request: CreateTodoRequest): TodoResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)
        val todo = Todo(
            title = request.title,
            content = request.content,
            createAt = request.createAt,
            name = request.name,
            card = card
        )
        return todo.toResponse()
    }

    override fun updateTodo(cardId: Long, todoId: Long, request: UpdateTodoRequest): TodoResponse {
        val todo = todoRepository.findCardIdAndTodoId(cardId, todoId) ?: throw ModelNotFoundException("todo", todoId)
        todo.toUpdate(request)

        return todo.toResponse()
    }

    override fun deleteTodo(cardId: Long, todoId: Long) {
        val todo = todoRepository.findCardIdAndTodoId(cardId, todoId) ?: throw ModelNotFoundException("todo", todoId)
        todoRepository.delete(todo)
    }
}