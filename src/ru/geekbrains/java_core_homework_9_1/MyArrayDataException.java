package ru.geekbrains.java_core_homework_9_1;

public class MyArrayDataException {
    public MyArrayDataException(int x, int y) {
        System.out.printf("Cant convert symbol to int. Error in cell: %s : %s%n", x, y);
    }
}
