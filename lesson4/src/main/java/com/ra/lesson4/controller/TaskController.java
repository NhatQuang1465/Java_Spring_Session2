package com.ra.lesson4.controller;

import com.ra.lesson4.model.entity.Task;
import com.ra.lesson4.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String search) {
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
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task newTask){
        Task task = taskService.createTask(newTask);
        if(task == null){
            return ResponseEntity.badRequest().body("Assigned user does not exist.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}