package com.ra.lesson4.service;

import com.ra.lesson4.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    Task createTask(Task task);
}