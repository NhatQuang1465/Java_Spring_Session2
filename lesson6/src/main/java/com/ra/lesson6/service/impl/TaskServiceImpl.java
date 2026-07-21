package com.ra.lesson6.service.impl;

import com.ra.lesson6.model.entity.Task;
import com.ra.lesson6.model.entity.User;
import com.ra.lesson6.repository.TaskRepository;
import com.ra.lesson6.service.TaskService;
import com.ra.lesson6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    @Override
    public Task createTask(Task task) {

        User user = userService.findUserById(task.getId());

        if(user == null){
            return null;
        }
        taskRepository.save(task);
        return task;
    }
    @Override
    public Task updateTask(int id, Task task) {
        return taskRepository.save(id, task);
    }

    @Override
    public Task deleteTask(int id) {
        return taskRepository.deleteById(id);
    }
}