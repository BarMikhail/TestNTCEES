package ru.ntc.ees;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();
        Recorder recorder = new Recorder();

        // Запуск в файл
        recorder.writingEvenNumber.start();
        recorder.writingOddNumber.start();

        // Чтение с файла
        reader.readThread.start();
    }
}