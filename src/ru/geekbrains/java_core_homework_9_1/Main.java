package ru.geekbrains.java_core_homework_9_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try { // Вызов проверки исключения с передачей введённого пользователем массива методу arrCheck
            System.out.println("Sum of array's elements: " + arrCheck(arrEntry()));
        } catch (MyArraySizeException e) { // Перехват исключения размера массива
            System.out.println("MyArraySizeException error:");
            e.printStackTrace(); // Вывод информации об исключении

        } catch (MyArrayDataException e) { // Перехват исключения корректности ввода элементов массива
            System.out.println("MyArrayDataException error:");
            e.printStackTrace(); // Вывод информации об исключении
        }

    }

    public static int arrCheck(String[][] myArray) throws MyArraySizeException, MyArrayDataException { // Метод проверки массива и суммирования его элементов
        int sum = 0;
        if (myArray.length == 4 && myArray[0].length == 4) { // Проверка корректности размера массива
            for (int i = 0; i < myArray[0].length; i++) {
                for (int j = 0; j < myArray.length; j++) {
                    if ((myArray[i][j]).matches("[-+]?\\d+")) { // Условные выражения для проверки корректности ввода
                        sum += Integer.parseInt(myArray[i][j]); // Суммирование элементов массива
                    } else throw new MyArrayDataException("Cant convert symbol to int. Error in cell [" + i + ":" + j + "]"); // Передача исключения с сообщением и координатами ячейки
                }
            }
        } else throw new MyArraySizeException("Array size must be 4x4!"); // Передача исключения с сообщением о требуемом размере массива
        return sum; // Возврат посчитанной суммы
    }

    public static String[][] arrEntry() { // Метод создания массива пользователем
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;
        boolean exit = false;
        do { // Проверка на корректность ввода размера массива
            System.out.println("Enter number of lines (must be 4)");
            String input = sc.nextLine().trim();
            Scanner check = new Scanner(input);
            if (check.hasNextInt()) {
                x = check.nextInt();
                exit = true;
            }
        } while (!exit);
        exit = false;
        do {
            System.out.println("Enter number of columns (must be 4)");
            String input = sc.nextLine().trim();
            Scanner check = new Scanner(input);
            if (check.hasNextInt()) {
                y = check.nextInt();
                exit = true;
            }
        } while (!exit);

        String[][] myArray = new String[x][y]; // Создание массива
        System.out.print("Fill the array:");
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                System.out.printf("%nEnter %s %s element: ", i, j); // Заполнение массива
                myArray[i][j] = sc.next();
            }
        }
        return myArray;
        // return new String[][] {{"1", "3", "2", "5"}, {"6", "4", "7", "1"}, {"3", "7", "6", "2"}, {"9", "3", "4", "8"}};
    }
}