package org.vincent.menu;

import org.vincent.entity.User;

import java.util.HashMap;
import java.util.Scanner;

public class Auth {
    private final Scanner scanner = new Scanner(System.in);
    private final HashMap<String, User> usersList = new HashMap<>();
    private String currentUser;
    private final TaskManagement taskManagement = new TaskManagement();

    public void newUserCheckPrompts() {
        System.out.println("Hello! Welcome to ToDo App");

        String isNew;
        while (true) {
            System.out.println("Do you have an account? (y/n)");
            isNew = scanner.next().trim().toLowerCase();
            if (isNew.equals("y") || isNew.equals("n")) break;
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }

        System.out.print("Username: ");
        String userName = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        if (isNew.equals("n")) {
            registerUser(userName, password);
        } else {
            loginUser(userName, password);
        }
    }

    private void loginUser(String userName, String password) {
        User user = usersList.get(userName);
        if (user != null && user.authLogin(userName, password)) {
            startUserSession(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void registerUser(String userName, String password) {
        if (usersList.containsKey(userName)) {
            System.out.println("Username already taken! Try a different one.");
            return;
        }
        User newUser = new User(userName, password);
        usersList.put(userName, newUser);
        System.out.println("Registration successful!");
        startUserSession(newUser);
    }

    private void startUserSession(User user) {
        currentUser = user.getUsername();
        taskManagement.setUserSession(user);
        taskManagement.taskManagementPrompt();
    }
}
