package org.vincent.menu;

import org.vincent.entity.Task;
import org.vincent.entity.User;

import java.util.*;

public class TaskManagement {
    private final Scanner scanner = new Scanner(System.in);
    public HashMap<UUID, Task> tasksList = new HashMap<>();

    public void setUserSession(User user) {
        System.out.println("Welcome, " + user.getUsername());
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

    private void addTask() {
        System.out.print("Task name: ");
        String taskName = scanner.nextLine();

        UUID taskId = UUID.randomUUID();
        Task newTask = new Task(taskName, taskId);
        tasksList.put(taskId, newTask);

        System.out.println("Task added: " + newTask.getTaskName() + "\n");
        viewTasks();
    }

    private UUID getTaskIdByIndex(String action) {
        viewTasks();
        if (tasksList.isEmpty()) {
            return null;
        }

        System.out.print("Select Task to " + action + " (number): ");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine();

        List<UUID> taskKeys = new ArrayList<>(tasksList.keySet());

        if (selectedIndex > 0 && selectedIndex <= taskKeys.size()) {
            return taskKeys.get(selectedIndex - 1);
        } else {
            System.out.println("Invalid task number. Try again.");
            return null;
        }
    }

    public void deleteTask() {
        UUID taskId = getTaskIdByIndex("delete");

        if (taskId != null) {
            tasksList.remove(taskId);
            System.out.println("Task deleted successfully.");
        }
    }

    public void markTaskAsDone() {
        UUID taskId = getTaskIdByIndex("mark as done");

        if (taskId != null) {
            if(!tasksList.get(taskId).getIsDone()){
                tasksList.get(taskId).setIsDone();
            } else {
                System.out.println("Task you've selected is already done");
            }
        }
    }

    public void viewTasks() {
        System.out.println("\nCurrent Tasks:");
        if (!tasksList.isEmpty()) {
            int index = 1;
            for (Task task : tasksList.values()) {
                System.out.println(index + ". " + task.getTaskName() + " | Done: " + (task.getIsDone() ? "Yes" : "No"));
                index++;
            }
            System.out.println("\n");
        } else {
            System.out.println("========= No tasks yet ==========\n");
        }
    }
}