package com.viktor.javalevel1.arrays.homework;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы,
 * которые больше этого среднего арифметического.
 */
public class Task2 {
    public static void main(String[] args) {
        char[] symbols = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] numbers = changeType(symbols);
        System.out.println(Arrays.toString(symbols));
        System.out.println(Arrays.toString(numbers));
        printElementsBiggerAverage(numbers);
    }

    private static void printElementsBiggerAverage(int[] numbers) {
        double average = getArithmeticalMean(numbers);
        for (int numb : numbers) {
            if (numb > average) {
                System.out.print(numb + " ");
            }
        }
        System.out.print(" are bigger then Arithmetical mean which equals " + average);
    }

    private static double getArithmeticalMean(int[] numbers) {
        int sum = 0;
        for (int numb : numbers) {
            sum += numb;
        }
        return (double) sum / numbers.length;
    }

    public static int[] changeType(char[] symbols) {
        int[] result = new int[symbols.length];
        for (int i = 0; i < symbols.length; i++) {
            result[i] = symbols[i];
        }
        return result;
    }
}
