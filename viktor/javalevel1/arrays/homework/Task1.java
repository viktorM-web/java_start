package com.viktor.javalevel1.arrays.homework;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] array = {3, 5, -6, 3, 2, -9, 0, -123};
        int[] result = createArray(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] createArray(int[] array) {
        int newLength = 0;
        int count = 0;
        for (int numb : array) {
            if (numb >= 0) {
                newLength++;
            }
        }
        int[] resultArray = new int[newLength];
        for (int numb : array) {
            if (numb >= 0) {
                resultArray[count++] = numb * newLength;
            }
        }
        return resultArray;
    }
}
