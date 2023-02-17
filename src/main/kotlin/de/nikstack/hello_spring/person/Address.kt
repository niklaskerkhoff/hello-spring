package de.nikstack.hello_spring.person

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    val country: String,
    val postalCode: String,
    val city: String,
    val street: String
)
