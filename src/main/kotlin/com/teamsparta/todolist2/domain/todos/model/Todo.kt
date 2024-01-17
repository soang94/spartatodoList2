package com.teamsparta.todolist2.domain.todos.model

import com.teamsparta.todolist2.domain.cards.model.Card
import com.teamsparta.todolist2.domain.comments.model.Comment
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "todo")
class Todo(
    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "create_at")
    var createAt: Date,

    @Column(name = "name")
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    var card: Card,

    @OneToMany(mappedBy = "todo", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toUpdate(request: UpdateTodoRequest) {
        title = request.title
        content = request.content
        name = request.name
    }

    @Column(name = "complete")
    private var _complete: Boolean = false

    val complete: Boolean
        get() = _complete

    fun complete() {
        _complete = true
    }

    fun createComment(comment: Comment) {
        comments.add(comment)
    }

    fun removeComment(comment: Comment) {
        comments.remove(comment)
    }
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        content = content,
        createAt = createAt,
        name = name,
        complete = complete,
    )
}