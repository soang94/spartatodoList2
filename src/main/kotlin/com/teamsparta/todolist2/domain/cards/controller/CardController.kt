package com.teamsparta.todolist2.domain.cards.controller

import com.teamsparta.todolist2.domain.cards.dto.CardResponse
import com.teamsparta.todolist2.domain.cards.dto.CreateCardRequest
import com.teamsparta.todolist2.domain.cards.dto.UpdateCardRequest
import com.teamsparta.todolist2.domain.cards.service.CardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class CardController(
    private val cardService: CardService
) {

    @GetMapping
    fun cards(): ResponseEntity<List<CardResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.cards())
    }

    @GetMapping("/{cardId}")
    fun card(@PathVariable cardId: Long): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.card(cardId))
    }

    @PostMapping
    fun createCard(
        @RequestBody createCardRequest: CreateCardRequest
    ): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(cardService.createCard(createCardRequest))
    }

    @PutMapping("/{cardId}")
    fun updateCard(
        @PathVariable cardId: Long,
        @RequestBody updateCardRequest: UpdateCardRequest
    ): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.updateCard(cardId, updateCardRequest))
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(
        @PathVariable cardId: Long
    ): ResponseEntity<Any>{
        cardService.deleteCard(cardId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("카드 삭제 완료했습니다.")
    }
}