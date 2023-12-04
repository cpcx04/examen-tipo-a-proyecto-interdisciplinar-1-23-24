package com.salesianostriana.dam.rest.task.controller;

import com.salesianostriana.dam.rest.error.exception.NoTasksException;
import com.salesianostriana.dam.rest.task.GetTaskDto;
import com.salesianostriana.dam.rest.task.model.Task;
import com.salesianostriana.dam.rest.task.repo.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAll() {
        List<Task> result = taskRepository.findAll();
        if (result.isEmpty()) {
            throw new NoTasksException("No Task avaiables");
        }
        return ResponseEntity.ok(result);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        Optional<Task> result = taskRepository.findById(id);
        if (result.isEmpty()) {
            // Terminar si da tiempo
        }
        return ResponseEntity.ok(result.get());

    }

    @GetMapping("/dto")
    public ResponseEntity<List<GetTaskDto>> getAllDto() {
        return null; // Modificar
    }


}
