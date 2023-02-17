package org.example;

import org.example.FirstTask.FirstTask;
import org.example.SecondTask.SecondTask;
import org.example.ThirdTask.ThirdTask;

public class Test {
    public static void main(String[] args) {
        new SecondTask().saveUsersToJsonFile();

        System.out.println("First Task");
        new FirstTask().validatePhoneNumbers();

        System.out.println("\nThird Task");
        new ThirdTask().countOfAllNames();
    }
}