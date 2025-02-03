package ru.ntc.ees;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Constants {
    public static final String FILE_NAME = "numbers.txt";
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static final Random RANDOM = new Random();
}
