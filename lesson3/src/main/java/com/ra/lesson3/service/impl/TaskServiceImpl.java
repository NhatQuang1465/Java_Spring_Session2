package com.ra.lesson3.service.impl;

import com.ra.lesson3.model.entity.Task;
import com.ra.lesson3.repository.TaskRepository;
import com.ra.lesson3.service.TaskService;
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