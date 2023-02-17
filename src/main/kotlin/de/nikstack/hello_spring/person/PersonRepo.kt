package de.nikstack.hello_spring.person

import de.nikstack.hello_spring.EntityRepo

interface PersonRepo : EntityRepo<Person> {
    fun findAllByAddressCity(city: String): List<Person>
}
