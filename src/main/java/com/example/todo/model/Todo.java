package com.example.todo.model;
import javax.persistence.*;
@Entity
  @Table(name="todolist")
public class Todo {
    @Id
    @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    @Column(name="todo")
    private String todo;
    @Column(name="status")
    private String status;
    @Column(name="priority")
    private String priority;
public Todo(){}
    public Todo(int todoId, String todo, String status,String priority) {
        this.todoId = todoId;
        this.todo = todo;
        this.status=status;
        this.priority= priority;
        }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status= status;
    }
     public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
