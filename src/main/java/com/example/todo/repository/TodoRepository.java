package com.example.todo.repository;
import com.example.todo.model.Todo;

import java.util.ArrayList;

public interface TodoRepository {
    ArrayList<Todo>getTodos();

    Todo getTodoById(int TodoId);
    Todo addTodo(Todo todo);
    Todo updatedTodo(int TodoId,Todo todo);
    void deleteTodo(int TodoId);

}