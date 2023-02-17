package de.nikstack.hello_spring.todo_type

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo-types")
class TodoTypeController(
    private val todoTypeRepo: TodoTypeRepo,
) {
    @PostMapping
    fun add(@RequestBody todoType: TodoType) = todoTypeRepo.save(todoType)
}
