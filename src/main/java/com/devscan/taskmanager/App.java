package com.devscan.taskmanager;

import com.devscan.taskmanager.model.Task;
import com.devscan.taskmanager.service.TaskService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Task Manager!");

        while (true) {
            System.out.println("\nCommands: list, add <desc>, remove <id>, exit");
            String input = scanner.nextLine();
            if (input.startsWith("add ")) {
                String desc = input.substring(4);
                Task task = taskService.addTask(desc);
                System.out.println("Added: " + task);
            } else if (input.equals("list")) {
                taskService.getAllTasks().forEach(System.out::println);
            } else if (input.startsWith("remove ")) {
                try {
                    int id = Integer.parseInt(input.substring(7));
                    taskService.removeTask(id);
                    System.out.println("Removed task " + id);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
        scanner.close();
    }
}