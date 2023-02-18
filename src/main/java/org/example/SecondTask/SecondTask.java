package org.example.SecondTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondTask {
    public void saveUsersToJsonFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonFileAddress = "resources/users.json"; // адрес JSON файлу, куди буде записано список User
        String sourceFileAddress = "resources/users.txt"; // файл звідки беремо дані
        List<User> users = new ArrayList<>(); // список об'єктів типу User

        try(FileInputStream fis = new FileInputStream(sourceFileAddress);
            Scanner scanner = new Scanner(fis)) {
            scanner.nextLine(); // пропускаємо перший рядок
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                User user = parseUser(line);
                users.add(user); // додаємо user в список
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String json = gson.toJson(users); // перетворюємо список в JSON-формат

        try(FileOutputStream fos = new FileOutputStream(jsonFileAddress)) {
            fos.write(json.getBytes()); // записуємо у json файл
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для розбору рядка з даними про користувача та створення об'єкта User.
    private User parseUser(String line) {
        String[] splitLine = line.split(" ");
        return new User(splitLine[0], Integer.parseInt(splitLine[1]));
    }
}