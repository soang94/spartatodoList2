package com.teamsparta.todolist2.domain.cards.service

import com.teamsparta.todolist2.domain.cards.dto.CardResponse
import com.teamsparta.todolist2.domain.cards.dto.CreateCardRequest
import com.teamsparta.todolist2.domain.cards.dto.UpdateCardRequest
import org.springframework.stereotype.Service

@Service
class CardServiceImpl: CardService {
    override fun cards(): List<CardResponse> {
        TODO("Not yet implemented")
    }

    override fun card(cardId: Long): CardResponse {
        TODO("Not yet implemented")
    }

    override fun createCard(request: CreateCardRequest): CardResponse {
        TODO("Not yet implemented")
    }

    override fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse {
        TODO("Not yet implemented")
    }

    override fun deleteCard(cardId: Long) {
        TODO("Not yet implemented")
    }
}