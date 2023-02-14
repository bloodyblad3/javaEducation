package seminar2;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class homework {
    public static void main(String[] args) {
        System.out.println(isPolyndrom("шалаш")); // True

        CreateAndWriteFile();
    }

    public static boolean isPolyndrom(String text) {
        // 1. Создать метод, который проверяет, является ли строка палиндромом.
        // Палиндром - шалаш
        return text.equalsIgnoreCase(new StringBuilder(text).reverse().toString());
    }

    public static void CreateAndWriteFile() {
        // 2. С помощью Java создать файл file.txt, и записать в него слово TEST 100
        // раз.
        // Если уже файл создан, то перезаписываем его.
        try {
            Path file = Path.of("file.txt");
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            FileWriter fw = new FileWriter("file.txt");
            for (int i = 0; i != 100; i++) {
                fw.write("TEST\n");
            }
            fw.close();
            System.out.println("Файл был создан и значения были записаны");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}