package org.vincent;

import org.vincent.menu.Auth;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Auth auth = new Auth();

        auth.newUserCheckPrompts();


    }
}