package com.studentsphere.controller;

import com.studentsphere.entity.Task;
import com.studentsphere.repository.TaskRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(
            TaskRepository taskRepository
    ) {
        this.taskRepository =
                taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(
            @PathVariable Long id
    ) {

        return taskRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Task not found."
                        )
                );
    }
}