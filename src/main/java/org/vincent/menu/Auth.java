package org.vincent.menu;

import org.vincent.entity.User;
import org.vincent.exception.AuthException;

import java.util.HashMap;
import java.util.Scanner;

public class Auth {
    private final Scanner scanner = new Scanner(System.in);
    HashMap<String, User> usersList = new HashMap<>();

    public void newUserCheckPrompts() {
        System.out.println("Hello! Welcome to ToDo App");
        System.out.println("Do you have an account? (y/n)");
        String isNew = scanner.next();

        System.out.println("Username:");
        String userName = scanner.next();

        System.out.println("Password:");
        String password = scanner.next();

        if (isNew.equalsIgnoreCase("n")) {
            registerPrompts(userName, password);
        } else if (isNew.equalsIgnoreCase("y")) {
            loginPrompts(userName, password);
        }

    }

    public void loginPrompts(String userName, String password) {
        User user = usersList.get(userName);
        if(user != null){
            if (user.authLogin(userName, password)) {
                //run task management
            }
        }
        else {
            System.out.println("User not found");
        }
    }

    public void registerPrompts(String userName, String password) {
        if (usersList.get(userName) == null) {
            User newUser = new User(userName, password);
            usersList.put(userName, newUser);
            System.out.println("Register successful");
        } else {
            System.out.println("Username has already been taken! shit! try new one");
        }
    }
}
