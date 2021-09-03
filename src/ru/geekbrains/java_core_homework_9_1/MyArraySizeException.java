package ru.geekbrains.java_core_homework_9_1;

public class MyArraySizeException extends Exception { // Создание обработки исключения размера массива

    public MyArraySizeException(String message) { // Конструктор класса обработки
        super(message); // Передача сообщения
    }
}
