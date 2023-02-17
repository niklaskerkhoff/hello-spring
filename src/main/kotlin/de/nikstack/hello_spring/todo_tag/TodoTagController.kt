package de.nikstack.hello_spring.todo_tag

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo-tags")
class TodoTagController(
    private val todoTagRepo: TodoTagRepo
) {
    @PostMapping
    fun add(@RequestBody todoTag: TodoTag) = todoTagRepo.save(todoTag)
}
