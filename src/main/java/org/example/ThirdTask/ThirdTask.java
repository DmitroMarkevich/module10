package org.example.ThirdTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThirdTask {
    public void countOfAllNames() {
        StringBuilder resultString = new StringBuilder();
        String sourceFileAddress = "resources/words.txt";

        try (FileInputStream fis = new FileInputStream(sourceFileAddress);
             Scanner scanner = new Scanner(fis)) {
            while(scanner.hasNext()) resultString.append(scanner.nextLine()).append(" ");

            Map<String, Long> frequency = Arrays.stream(
                    resultString.toString()
                            .split(" "))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            frequency.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}