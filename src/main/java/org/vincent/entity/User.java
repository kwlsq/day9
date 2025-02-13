package org.vincent.entity;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean authLogin(String userName, String password){
        if(userName.isEmpty() || password.isEmpty()){
            System.out.println("Username or Password can't be empty");
        }
        if(!this.userName.equalsIgnoreCase(userName)){
            System.out.println("Wrong username!");
        }
        if(!this.password.equalsIgnoreCase(password)){
            System.out.println("Wrong password!");
        }
        System.out.println("Login successful");
        return true;
    }
}


