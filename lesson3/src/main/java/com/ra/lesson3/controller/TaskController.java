package com.ra.lesson3.controller;

import com.ra.lesson3.model.entity.Task;
import com.ra.lesson3.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String search) {

        List<Task> tasks = taskService.findAllTasks();

        if (search != null && !search.trim().isEmpty()) {
            tasks = tasks.stream()
                    .filter(task -> task.getTitle()
                            .toLowerCase()
                            .contains(search.toLowerCase().trim()))
                    .toList();
        }

        return ResponseEntity.ok(tasks);
    }

}