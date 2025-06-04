package com.devscan.taskmanager.repository;

import com.devscan.taskmanager.model.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public void save(Task task) {
        tasks.add(task);
    }

    public boolean delete(int id) {
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            if (it.next().getId() != id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}