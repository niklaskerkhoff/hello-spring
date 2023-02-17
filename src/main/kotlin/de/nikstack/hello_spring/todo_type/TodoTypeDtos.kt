package de.nikstack.hello_spring.todo_type

import java.util.UUID

data class CreateTodoType(
    val text: String,
    val todoId: UUID,
)
