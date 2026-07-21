package com.ra.lesson3.repository;

import com.ra.lesson3.model.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public TaskRepository() {

        tasks.add(new Task(1,"Task 1","Description 1","HIGH",1));
        tasks.add(new Task(2,"Task 2","Description 2","LOW",2));
        tasks.add(new Task(3,"Task 3","Description 3","MEDIUM",1));
        tasks.add(new Task(4,"Task 4","Description 4","HIGH",3));
        tasks.add(new Task(5,"Task 5","Description 5","LOW",2));
        tasks.add(new Task(6,"Task 6","Description 6","MEDIUM",1));
        tasks.add(new Task(7,"Task 7","Description 7","HIGH",3));
        tasks.add(new Task(8,"Task 8","Description 8","LOW",2));
        tasks.add(new Task(9,"Task 9","Description 9","MEDIUM",1));
        tasks.add(new Task(10,"Task 10","Description 10","HIGH",3));
    }

    public List<Task> findAll() {
        return tasks;
    }
}
