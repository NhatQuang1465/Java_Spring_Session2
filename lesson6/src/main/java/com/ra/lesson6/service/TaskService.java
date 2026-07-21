package com.ra.lesson6.service;

import com.ra.lesson6.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    Task createTask(Task task);
    Task updateTask(int id, Task task);
    Task deleteTask(int id);
}