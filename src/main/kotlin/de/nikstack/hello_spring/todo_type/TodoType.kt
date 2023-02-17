package de.nikstack.hello_spring.todo_type

import de.nikstack.hello_spring.person.AppEntity
import jakarta.persistence.Entity

@Entity
class TodoType(
    val text: String,
) : AppEntity()
