package com.codecool.todoapp;

import com.codecool.todoapp.repositories.TodoRepository;
import com.codecool.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppApplication {

    @Autowired
    TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
           todoService.getAllTodos();
        };
    }
}
