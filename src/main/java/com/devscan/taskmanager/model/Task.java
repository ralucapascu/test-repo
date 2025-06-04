package com.devscan.taskmanager.model;

public class Task {
    private static int idCounter = 1;
    private final int id;
    private String description;

    public Task(String description) {
        this.id = idCounter++;
        this.description = description;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Task{id=" + id + ", description='" + description + "'}";
    }
}
