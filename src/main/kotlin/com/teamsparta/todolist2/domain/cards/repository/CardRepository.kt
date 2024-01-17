package com.teamsparta.todolist2.domain.cards.repository

import com.teamsparta.todolist2.domain.cards.model.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card, Long> {
}