package com.teamsparta.todolist2.domain.todos.repository

import com.teamsparta.todolist2.domain.todos.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
    fun findByCardIdAndId(cardId: Long, todoId: Long): Todo?
}