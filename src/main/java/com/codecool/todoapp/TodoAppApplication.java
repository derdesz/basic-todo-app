package com.codecool.todoapp;

import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import com.codecool.todoapp.repositories.TodoRepository;
import com.codecool.todoapp.services.TodoService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppApplication {

    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Todo todo1 = Todo.builder()
                    .id((long) 1)
                    .title("Todo1")
                    .status(Status.ACTIVE)
                    .build();

            Todo todo2 = Todo.builder()
                    .id((long) 2)
                    .title("Todo2")
                    .status(Status.ACTIVE)
                    .build();

            Todo todo3 = Todo.builder()
                    .id((long) 3)
                    .title("Todo3")
                    .status(Status.ACTIVE)
                    .build();

            todoRepository.save(todo1);
            todoRepository.save(todo2);
            todoRepository.save(todo3);

           todoService.getAllTodos();
        };
    }
}
