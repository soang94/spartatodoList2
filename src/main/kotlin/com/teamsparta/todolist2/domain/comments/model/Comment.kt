package com.teamsparta.todolist2.domain.comments.model

import com.teamsparta.todolist2.domain.comments.dto.CommentResponse
import com.teamsparta.todolist2.domain.comments.dto.UpdateCommentRequest
import com.teamsparta.todolist2.domain.todos.model.Todo
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "comment")
class Comment(
    @Column(name = "content")
    var content: String,

    @Column(name = "create_at")
    var createAt: Date,

    @Column(name = "name")
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    var todo: Todo,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toUpdate(request: UpdateCommentRequest) {
        content = request.content
        createAt = request.createAt
        name = request.name
    }
}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse (
        id = id!!,
        content = content,
        createAt = createAt,
        name = name
    )
}