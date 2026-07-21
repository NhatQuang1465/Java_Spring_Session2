package com.ra.lesson5.service;

import com.ra.lesson5.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
}