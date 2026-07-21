package com.ra.lesson6.controller;

import com.ra.lesson6.model.entity.Task;
import com.ra.lesson6.service.TaskService;
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
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(
            @PathVariable int id,
            @RequestBody Task task) {

        Task updatedTask = taskService.updateTask(id, task);

        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {

        Task deletedTask = taskService.deleteTask(id);

        if (deletedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}