package com.ra.lesson5.service;

import com.ra.lesson5.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    Task createTask(Task task);
    Task updateTask(int id, Task task);
    Task deleteTask(int id);
}