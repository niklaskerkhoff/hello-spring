package de.nikstack.hello_spring.person

import de.nikstack.hello_spring.todo.Todo
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
class Person(
    var forename: String,
    var surname: String,

    @Embedded
    var address: Address,

    @ElementCollection
    var moreAddresses: List<Address>,

    @OneToMany
    var todos: List<Todo> = emptyList()

) : AppEntity()
