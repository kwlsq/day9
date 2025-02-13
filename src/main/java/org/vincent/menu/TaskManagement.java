package org.vincent.menu;

import org.vincent.entity.Task;
import org.vincent.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class TaskManagement {
    private final Scanner scanner = new Scanner(System.in);
    public HashMap<UUID, Task> tasksList = new HashMap<>();
    private User currentUser;

    public void setUserSession(User user) {
        System.out.println("Welcome, " + user.getUsername());
        this.currentUser = user;
    }

    public void taskManagementPrompt() {
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task as done");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsDone();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void addTask(){
        System.out.print("Task name: ");
        String taskName = scanner.nextLine();

        Task newTask = new Task(taskName);
        tasksList.put(newTask.getTaskID(), newTask);

        System.out.println("Task added: " + newTask.getTaskName() + "\n");
        viewTasks();
    }

    public void markTaskAsDone(){

    }

    public void deleteTask(){

    }

    public void viewTasks(){
        System.out.println("\nCurrent Tasks:");
        if(!tasksList.isEmpty()) {
            for (Map.Entry<UUID, Task> entry : tasksList.entrySet()) {
                Task task = entry.getValue();
                System.out.println("- " + task.getTaskName() + " | Done: " + (task.getIsDone() ? "Yes" : "No"));
            }
            System.out.println("\n");
        } else {
            System.out.println("========= No tasks yet ==========\n");
        }
    }
}