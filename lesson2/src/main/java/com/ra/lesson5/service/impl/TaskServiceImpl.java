package com.ra.lesson5.service.impl;

import com.ra.lesson5.model.entity.Task;
import com.ra.lesson5.repository.TaskRepository;
import com.ra.lesson5.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
}