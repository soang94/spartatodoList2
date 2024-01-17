package com.teamsparta.todolist2.domain.todos.model

import com.teamsparta.todolist2.domain.cards.model.Card
import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
import com.teamsparta.todolist2.domain.todos.dto.UpdateTodoRequest
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "todos")
class Todo(
    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "createAt")
    var createAt: Date,

    @Column(name = "name")
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cards_id")
    var card: Card,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toUpdate(request: UpdateTodoRequest) {
        title = request.title
        content = request.content
        name = request.name
    }
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        content = content,
        createAt = createAt,
        name = name,
    )
}