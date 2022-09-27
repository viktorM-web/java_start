package com.viktor.javalevel1.cycles.homework;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать
 * количество четных цифр (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        int number = 1030;
        System.out.println("The number " + number + " have " + getEvenNumbers(number) + " even and " +
                getOddNumbers(number) + " odd numbers");
    }

    public static int getEvenNumbers(int number) {
        int current = number;
        int counter = 0;
        while (current % 10 != 0 || current / 10 != 0) {
            if (current % 10 % 2 == 0) {
                counter++;
            }
            current /= 10;
        }
        return counter;
    }

    public static int getOddNumbers(int number) {
        int counter = 0;
        for (int i = number; i % 10 != 0 || i / 10 != 0; i /= 10) {
            if (i % 10 % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }
}
