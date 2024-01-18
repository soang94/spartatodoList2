package com.teamsparta.todolist2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class Todolist2Application

fun main(args: Array<String>) {
    runApplication<Todolist2Application>(*args)
}
