package com.example.todo.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class TodoController {
    @Autowired
    public TodoJpaService todoService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodoById(@PathVariable("todoId") int todoId) {
        return todoService.getTodoById(todoId);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);

    }
    
    @PutMapping("/todos/{todoId}")
    public Todo updatedTodo(@PathVariable("todoId") int todoId, @RequestBody Todo todo) {
        return todoService.updatedTodo(todoId, todo);
    }
    
    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int todoId) {
        todoService.deleteTodo(todoId);
    }
}
