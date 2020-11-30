package com.codecool.todoapp.repositories;

import com.codecool.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    // TODO find all Todos -> return list of all Todos

    // TODO add new new Todo item to database

    // TODO find Todo by ID -> return Todo item

    // TODO update Todo item -> void

    // TODO find list of Todos by status -> return list of Todos

    // TODO remove Todo by id -> void

    // TODO remove completed Todo -> void

    // TODO remove toggleStatus -> void

    //TODO remove all toggled -> void


}
