package de.nikstack.hello_spring.person

import de.nikstack.hello_spring.todo.TodoRepo
import jakarta.transaction.Transactional
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@Transactional
@RequestMapping("persons")
class PersonController(
    private val personRepo: PersonRepo,
    private val todoRepo: TodoRepo
) {
    @PostMapping
    fun add(@RequestBody person: Person): Person {
        person.todos.forEach(todoRepo::save)
        return personRepo.save(person)
    }

    @GetMapping
    fun getAll(): List<Person> = personRepo.findAll()

    @GetMapping("greet")
    fun greet(principal: Principal) = "Hello ${principal.name}"

    @GetMapping("test-mutation")
    fun testMutation(): List<Person> {
        val todo = todoRepo.findFirstBy() ?: throw NotFoundException()
        todo.text = "Mutiert"
        return personRepo.findAll()
    }
}
