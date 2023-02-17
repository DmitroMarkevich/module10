package org.example.FirstTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTask {
    public void validatePhoneNumbers() {

        Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s*\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})");
        String sourceFileAddress = "resources\\file.txt";

        try (FileInputStream fis = new FileInputStream(sourceFileAddress);
             Scanner scanner = new Scanner(fis)) {

            while (scanner.hasNext()) {
                String phoneNumber = scanner.nextLine();
                Matcher firstMatcher = pattern.matcher(phoneNumber);

                if (firstMatcher.matches()) System.out.println(phoneNumber);
            }

        } catch(IOException e) {
            System.err.println("Помилка читання файлу!");
            e.printStackTrace();
        }
    }
}