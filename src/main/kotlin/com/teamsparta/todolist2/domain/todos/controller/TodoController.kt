package com.teamsparta.todolist2.domain.todos.controller

import com.teamsparta.todolist2.domain.cards.dto.CreateCardRequest
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards/{cardId}/todos")
@RestController
class TodoController {

    @GetMapping
    fun todos(@PathVariable cardId: Long): ResponseEntity<List<TodoResponse>> {
        TODO()
    }

    @GetMapping("/{todoId}")
    fun todo(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long
    ): ResponseEntity<TodoResponse> {
        TODO()
    }

    @PostMapping
    fun createTodo(
        @PathVariable cardId: Long,
        @RequestBody createCardRequest: CreateCardRequest
    ): ResponseEntity<TodoResponse> {
        TODO()
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        TODO()
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long
    ): ResponseEntity<Any> {
        TODO()
    }
}