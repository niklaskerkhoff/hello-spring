package de.nikstack.hello_spring.todo

import de.nikstack.hello_spring.AppEntity
import de.nikstack.hello_spring.todo_tag.TodoTag
import de.nikstack.hello_spring.todo_type.TodoType
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne

@Entity
class Todo(
    var text: String,
    var done: Boolean,

    @ManyToMany
    var tags: List<TodoTag> = emptyList(),

    @ManyToOne
    var type: TodoType? = null

) : AppEntity()
