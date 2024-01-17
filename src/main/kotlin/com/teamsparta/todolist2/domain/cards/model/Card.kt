package com.teamsparta.todolist2.domain.cards.model

import com.teamsparta.todolist2.domain.cards.dto.CardResponse
import jakarta.persistence.*

@Entity
@Table(name = "cards")
class Card(
    @Column(name = "name")
    var name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Card.toResponse(): CardResponse {
    return CardResponse(
        id = id!!,
        name = name,
    )
}