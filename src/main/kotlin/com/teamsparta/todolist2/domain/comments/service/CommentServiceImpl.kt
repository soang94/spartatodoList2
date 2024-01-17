package com.teamsparta.todolist2.domain.comments.service

import com.teamsparta.todolist2.domain.comments.model.Comment
import com.teamsparta.todolist2.domain.comments.dto.CommentResponse
import com.teamsparta.todolist2.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todolist2.domain.comments.dto.UpdateCommentRequest
import com.teamsparta.todolist2.domain.comments.model.toResponse
import com.teamsparta.todolist2.domain.comments.repository.CommentRepository
import com.teamsparta.todolist2.domain.exception.ModelNotFoundException
import com.teamsparta.todolist2.domain.todos.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
): CommentService {
    override fun comments(todoId: Long): List<CommentResponse> {
        val comment = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)

        return comment.comments.map { it.toResponse() }
    }

    override fun comment(todoId: Long, commentId: Long): CommentResponse {
        val comment = commentRepository.findByTodoIdAndId(todoId, commentId) ?: throw ModelNotFoundException("comment", commentId)

        return comment.toResponse()
    }

    @Transactional
    override fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        val comment = Comment(
            content = request.content,
            createAt = request.createAt,
            name = request.name,
            todo = todo
        )
        todo.createComment(comment)
        todoRepository.save(todo)

        return comment.toResponse()
    }

    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val comment = commentRepository.findByTodoIdAndId(todoId, commentId) ?: throw ModelNotFoundException("comment", commentId)
        comment.toUpdate(request)

        return comment.toResponse()
    }

    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("comment", commentId)

        todo.removeComment(comment)
        todoRepository.save(todo)
    }

}