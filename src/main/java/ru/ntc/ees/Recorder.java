package ru.ntc.ees;

import java.io.FileWriter;
import java.io.IOException;

public class Recorder {

    // Записи четных чисел
    Thread writingEvenNumber = new Thread(() -> {
        while (true) {
            int number = Constants.RANDOM.nextInt(100) * 2;
            writeToFile(number);
            try {
                Thread.sleep(500); // Задержка для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    // Записи нечетных чисел
    Thread writingOddNumber = new Thread(() -> {
        while (true) {
            int number = Constants.RANDOM.nextInt(100) * 2 + 1;
            writeToFile(number);
            try {
                Thread.sleep(600); // Задержка для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private static void writeToFile(int number) {
        Constants.LOCK.lock();
        try (FileWriter writer = new FileWriter(Constants.FILE_NAME, true)) {
            writer.write(number + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Constants.LOCK.unlock();
        }
    }
}
