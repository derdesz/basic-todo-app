package com.codecool.todoapp.controller;


import com.codecool.todoapp.model.Todo;
import com.codecool.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}
