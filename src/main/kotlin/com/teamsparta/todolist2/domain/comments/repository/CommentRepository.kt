package com.teamsparta.todolist2.domain.comments.repository

import com.teamsparta.todolist2.domain.comments.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
    fun findByTodoIdAndId(todoId: Long, commentId: Long): Comment?
}