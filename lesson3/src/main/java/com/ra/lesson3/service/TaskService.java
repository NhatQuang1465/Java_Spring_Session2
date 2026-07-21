package com.ra.lesson3.service;

import com.ra.lesson3.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
}