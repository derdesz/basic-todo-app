package com.codecool.todoapp.services;

import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import com.codecool.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;


    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> findAllByStatus(Status status) {
        return todoRepository.findAllByStatus(status);
    }

    public void removeAllCompleted(){
        todoRepository.removeAllByStatusEquals(Status.COMPLETE);
    }

    public Todo findById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElse(null);
    }

}
