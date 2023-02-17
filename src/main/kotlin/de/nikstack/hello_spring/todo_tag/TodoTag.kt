package de.nikstack.hello_spring.todo_tag

import de.nikstack.hello_spring.person.AppEntity
import jakarta.persistence.Entity

@Entity
class TodoTag(
    var text: String
) : AppEntity()
