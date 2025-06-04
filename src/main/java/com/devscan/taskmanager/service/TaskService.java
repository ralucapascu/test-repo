package com.devscan.taskmanager.service;

import com.devscan.taskmanager.model.Task;
import com.devscan.taskmanager.repository.TaskRepository;
import com.devscan.taskmanager.exception.TaskNotFoundException;

import java.util.List;

public class TaskService {
    private final TaskRepository repository = new TaskRepository();

    public Task addTask(String description) {
        Task task = new Task(description);
        repository.save(task);
        return task;
    }

    public void removeTask(int id) {
        if (!repository.delete(id)) {
            throw new TaskNotFoundException("Task not found: " + id);
        }
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
}
