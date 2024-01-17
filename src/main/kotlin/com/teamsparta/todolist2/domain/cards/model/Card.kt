package com.teamsparta.todolist2.domain.cards.model

import com.teamsparta.todolist2.domain.cards.dto.CardResponse
import com.teamsparta.todolist2.domain.cards.dto.UpdateCardRequest
import com.teamsparta.todolist2.domain.todos.model.Todo
import jakarta.persistence.*

@Entity
@Table(name = "cards")
class Card(
    @Column(name = "name")
    var name: String,

    @OneToMany(mappedBy = "cards", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var todo: MutableList<Todo> = mutableListOf(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toUpdate(request: UpdateCardRequest) {
        name = request.name
    }
}

fun Card.toResponse(): CardResponse {
    return CardResponse(
        id = id!!,
        name = name,
    )
}