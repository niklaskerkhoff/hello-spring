package de.nikstack.hello_spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloSpringApplication

fun main(args: Array<String>) {
    runApplication<HelloSpringApplication>(*args)
}
