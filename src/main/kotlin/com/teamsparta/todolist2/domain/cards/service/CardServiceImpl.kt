package com.teamsparta.todolist2.domain.cards.service

import com.teamsparta.todolist2.domain.cards.dto.CardResponse
import com.teamsparta.todolist2.domain.cards.dto.CreateCardRequest
import com.teamsparta.todolist2.domain.cards.dto.UpdateCardRequest
import com.teamsparta.todolist2.domain.cards.model.Card
import com.teamsparta.todolist2.domain.cards.model.toResponse
import com.teamsparta.todolist2.domain.cards.repository.CardRepository
import com.teamsparta.todolist2.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository
): CardService {
    override fun cards(): List<CardResponse> {
        return cardRepository.findAll().map { it.toResponse() }
    }

    override fun card(cardId: Long): CardResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)
        return card.toResponse()
    }

    @Transactional
    override fun createCard(request: CreateCardRequest): CardResponse {
        return cardRepository.save(
            Card(
                name = request.name,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)
        card.toUpdate(request)
        return card.toResponse()
    }

    @Transactional
    override fun deleteCard(cardId: Long) {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)
        cardRepository.delete(card)
    }
}