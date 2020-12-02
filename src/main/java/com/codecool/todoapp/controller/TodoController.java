package com.codecool.todoapp.controller;


import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import com.codecool.todoapp.repositories.TodoRepository;
import com.codecool.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping({"", "/"})
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @RequestMapping("/addTodo/{title}")
    public List<Todo> addNewTodo(@PathVariable("title") String title) {
        Todo newTodo = new Todo();
        newTodo.setTitle(title);
        newTodo.setStatus(Status.ACTIVE);
        todoRepository.save(newTodo);
        return todoService.getAllTodos();
    }

    @RequestMapping("/list/{status}")
    public List<Todo> getTodosByStatus(@PathVariable("status") String status) {
        Status statusEnum = Status.valueOf(status.toUpperCase());
        return todoService.findAllByStatus(statusEnum);
    }


    @RequestMapping("/todos/{id}")
    public void removeById(@PathVariable("id") Long id) {
        todoService.deleteById(id);
    }


    @RequestMapping("/todos/completed")
    public void removeCompleted() {
        todoService.removeAllCompleted();
    }


    @RequestMapping("/todos/{id}/{title}")
    public void updateTodo(@PathVariable("id") Long id, @PathVariable("title") String title) {
        Todo todoToUpdate = todoService.findById(id);

        todoToUpdate.setTitle(title);
        todoRepository.save(todoToUpdate);

    }

    @RequestMapping("/todos/{id}/toggle-status")
    public void changeStatus(@PathVariable("id") Long id) {
        Todo todo = todoService.findById(id);
        if (todo.getStatus().equals(Status.ACTIVE)) {
            todo.setStatus(Status.COMPLETE);
        } else {
            todo.setStatus(Status.ACTIVE);
        }
        todoRepository.save(todo);
    }


    @RequestMapping("/todos/toggle-all")
    public void toggleAll(){
        List<Todo> allTodos = todoService.getAllTodos();
        if (allTodos.stream().anyMatch(todo -> todo.getStatus().equals(Status.ACTIVE))) {
            allTodos.forEach(todo -> {
                todo.setStatus(Status.COMPLETE);
                todoRepository.save(todo);
            });
        } else {
            allTodos.forEach(todo -> {
                todo.setStatus(Status.ACTIVE);
                todoRepository.save(todo);
            });
        }
    }
}
