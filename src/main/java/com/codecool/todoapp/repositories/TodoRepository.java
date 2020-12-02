package com.codecool.todoapp.repositories;

import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByStatus(Status status);

    void deleteById(Long id);

    @Transactional
    void removeAllByStatusEquals(Status status);

   Optional<Todo> findById(Long id);


}
