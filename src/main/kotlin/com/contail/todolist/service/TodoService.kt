package com.contail.todolist.service

import com.contail.todolist.repository.Todo
import com.contail.todolist.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {
    fun getTodos() = todoRepository.findAll()

    fun insertTodo(todoName: String) = todoRepository.save(Todo(todoName = todoName))

    fun updateTodo(todoId: Long): Todo {
        var todo = todoRepository.findByIdOrNull(todoId) ?: throw Exception("todo가 없습니다.")
        todo.completed = !todo.completed
        return todoRepository.save(todo)
    }

    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)
}