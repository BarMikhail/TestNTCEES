package ru.ntc.ees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    // Чтение
    Thread readThread = new Thread(() -> {
        while (true) {
            readFromFile();
            try {
                Thread.sleep(100); // Задержка для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private static void readFromFile() {
        Constants.LOCK.lock();
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME))) {
            String line;
            String lastLine = "";
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            if (!lastLine.isEmpty()) {
                System.out.println("Последнее число в файле: " + lastLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Constants.LOCK.unlock();
        }
    }
}
