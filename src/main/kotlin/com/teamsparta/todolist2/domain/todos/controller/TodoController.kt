package com.teamsparta.todolist2.domain.todos.controller

import com.teamsparta.todolist2.domain.cards.dto.CreateCardRequest
import com.teamsparta.todolist2.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist2.domain.todos.service.TodoService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
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
class TodoController(
    private val todoService: TodoService
) {

    @Operation(summary = "todo 전체 조회")
    @GetMapping
    fun todos(@PathVariable cardId: Long): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.todos(cardId))
    }

    @Operation(summary = "todo 단건 조회")
    @GetMapping("/{todoId}")
    fun todo(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.todo(cardId, todoId))
    }

    @Operation(summary = "todo 생성")
    @PostMapping
    fun createTodo(
        @PathVariable cardId: Long,
        @RequestBody createTodoRequest: CreateTodoRequest
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(cardId, createTodoRequest))
    }

    @Operation(summary = "todo 수정")
    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(cardId, todoId, updateTodoRequest))
    }

    @Operation(summary = "todo 삭제")
    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable cardId: Long,
        @PathVariable todoId: Long
    ): ResponseEntity<Any> {
        todoService.deleteTodo(cardId, todoId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("할 일 삭제 완료했습니다.")
    }
}