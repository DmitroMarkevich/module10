package org.example.ThirdTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThirdTask {
    public void countOfAllNames() {
        StringBuilder resultString = new StringBuilder();
        String sourceFileAddress = "resources\\words.txt";

        try (FileInputStream fis = new FileInputStream(sourceFileAddress);
             Scanner scanner = new Scanner(fis)) {
            while(scanner.hasNext()) resultString.append(scanner.nextLine()).append(" ");

            List<String> splitString = new ArrayList<>(Arrays.asList(resultString.toString().split(" ")));
            Map<String, Long> frequency = splitString.stream().collect(
                    Collectors.groupingBy(Function.identity(), Collectors.counting()));

            frequency.forEach((k, v) -> System.out.println(k + ": " + v));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}