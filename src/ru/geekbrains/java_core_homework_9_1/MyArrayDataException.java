package ru.geekbrains.java_core_homework_9_1;

public class MyArrayDataException extends Exception { // Создание обработки исключения ввода данных в массив
    public MyArrayDataException(String message) { // Конструктор класса обработки
        super(message); // Передача сообщения с данными из NumberFormatException
    }
}
