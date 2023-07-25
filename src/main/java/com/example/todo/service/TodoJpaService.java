package com.example.todo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import com.example.todo.repository.TodoJpaRepository;
 import com.example.todo.model.Todo;
 import com.example.todo.repository.TodoRepository;
 import java.util.*;
 @Service
public class TodoJpaService implements TodoRepository{
    @Autowired
private TodoJpaRepository todoJpaRepository;
@Override
public ArrayList<Todo>getTodos(){
    List<Todo>todoList=todoJpaRepository.findAll();
ArrayList<Todo>todos=new ArrayList<>(todoList);
return todos;

}

@Override
public Todo getTodoById(int TodoId) {
    try{
Todo todo=todoJpaRepository.findById(TodoId).get();
return todo;
    }
    catch(Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

@Override
public Todo addTodo(Todo todo) {
    todoJpaRepository.save(todo);
    return todo;
}

@Override
public Todo updatedTodo(int TodoId, Todo todo) {
    try{
Todo newtodo=todoJpaRepository.findById(TodoId).get();
if(todo.getTodo()!=null){
    newtodo.setTodo(todo.getTodo());
}
if(todo.getStatus()!=null){
    newtodo.setStatus(todo.getStatus());
}
if(todo.getPriority()!=null){
    newtodo.setPriority(todo.getPriority());
}

todoJpaRepository.save(newtodo);
return newtodo;
    }catch(Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

@Override
public void deleteTodo(int TodoId) {
    try{
todoJpaRepository.deleteById(TodoId);
    }catch(Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    
}
}
