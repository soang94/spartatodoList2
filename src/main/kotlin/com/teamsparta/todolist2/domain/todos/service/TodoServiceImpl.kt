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
import org.springframework.transaction.annotation.Transactional

@Service
class TodoServiceImpl(
    private val cardRepository: CardRepository,
    private val todoRepository: TodoRepository
): TodoService {
    override fun todos(cardId: Long): List<TodoResponse> {
        val todo = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)

        return todo.todos.map { it.toResponse() }
    }

    override fun todo(cardId: Long, todoId: Long): TodoResponse {
        val todo = todoRepository.findByCardIdAndId(cardId, todoId) ?: throw ModelNotFoundException("todo", todoId)

        return todo.toResponse()
    }

    @Transactional
    override fun createTodo(cardId: Long, request: CreateTodoRequest): TodoResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)
        val todo = Todo(
            title = request.title,
            content = request.content,
            createAt = request.createAt,
            name = request.name,
            card = card
        )
        card.createTodo(todo)
        cardRepository.save(card)

        return todo.toResponse()
    }

    @Transactional
    override fun updateTodo(cardId: Long, todoId: Long, request: UpdateTodoRequest): TodoResponse {
        val todo = todoRepository.findByCardIdAndId(cardId, todoId) ?: throw ModelNotFoundException("todo", todoId)
        todo.toUpdate(request)

        return todo.toResponse()
    }

    @Transactional
    override fun deleteTodo(cardId: Long, todoId: Long) {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw  ModelNotFoundException("todo", todoId)

        card.removeTodo(todo)
        cardRepository.save(card)
    }

    @Transactional
    override fun completeTodo(cardId: Long, todoId: Long) {
        val todo = todoRepository.findByCardIdAndId(cardId, todoId)

        todo?.let {
            it.complete()
            todoRepository.save(it)
        }
    }
}