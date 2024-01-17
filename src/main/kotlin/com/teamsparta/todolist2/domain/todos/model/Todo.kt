package com.teamsparta.todolist2.domain.todos.model

import com.teamsparta.todolist2.domain.todos.dto.TodoResponse
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
    var date: Date,

    @Column(name = "name")
    var name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        content = content,
        createAt = date,
        name = name,
    )
}