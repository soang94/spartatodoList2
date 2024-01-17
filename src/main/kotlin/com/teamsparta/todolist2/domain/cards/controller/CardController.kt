package com.teamsparta.todolist2.domain.cards.controller

import com.teamsparta.todolist2.domain.cards.dto.CardResponse
import com.teamsparta.todolist2.domain.cards.dto.CreateCardRequest
import com.teamsparta.todolist2.domain.cards.dto.UpdateCardRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp

@RequestMapping("/cards")
@RestController
class CardController {

    @GetMapping
    fun cards(): ResponseEntity<List<CardResponse>> {
        TODO()
    }

    @GetMapping("/{cardId}")
    fun card(@PathVariable cardId: Long): ResponseEntity<CardResponse> {
        TODO()
    }

    @PostMapping
    fun createCard(
        @RequestBody createCardRequest: CreateCardRequest
    ): ResponseEntity<CardResponse> {
        TODO()
    }

    @PutMapping("/{cardId}")
    fun updateCard(
        @PathVariable cardId: Long,
        @RequestBody updateCardRequest: UpdateCardRequest
    ): ResponseEntity<CardResponse> {
        TODO()
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(
        @PathVariable cardId: Long
    ): ResponseEntity<Any>{
        TODO()
    }
}