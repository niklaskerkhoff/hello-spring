package de.nikstack.hello_spring.todo

import de.nikstack.hello_spring.todo_tag.TodoTagRepo
import de.nikstack.hello_spring.todo_type.TodoTypeRepo
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("todos")
class TodoController(
    private val todoRepo: TodoRepo,
    private val todoTypeRepo: TodoTypeRepo,
    private val todoTagRepo: TodoTagRepo
) {
    @PatchMapping("type/{todoId}")
    fun setType(@PathVariable todoId: UUID, @RequestBody typeId: String): Todo {
        val todo = todoRepo.findByIdOrNull(todoId) ?: throw NotFoundException()
        val type =
            todoTypeRepo.findByIdOrNull(UUID.fromString(typeId))
                ?: throw NotFoundException()

        todo.type = type
        return todoRepo.save(todo)
    }

    @PatchMapping("tags/{todoId}")
    fun setTags(
        @PathVariable todoId: UUID,
        @RequestBody tagIds: List<UUID>
    ): Todo {
        val todo = todoRepo.findByIdOrNull(todoId) ?: throw NotFoundException()
        val tags = todoTagRepo.findAllById(tagIds)

        todo.tags = tags
        return todoRepo.save(todo)
    }
}
