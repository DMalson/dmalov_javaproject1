package Lesson_2;

import java.util.Arrays;
import java.util.Scanner;

public class Class_02 {

    public static void main(String[] args) {

        // Тест задания 1
        System.out.println("Задание 1");
        doTask1();
        System.out.println();
        // Тест задания 1
        System.out.println("Задание 2");
        doTask2();
        System.out.println();
        // Тест задания 3
        System.out.println("Задание 3");
        doTask3();
        System.out.println();
        // Тест задания 4
        System.out.println("Задание 4");
        doTask4();
        System.out.println();
        // Тест задания 5
        System.out.println("Задание 5");
        doTask5();
        System.out.println();
        // Тест задания 6
        System.out.println("Задание 6");
        int[] arr1 = {1, 5, 3, 6, 3, 2, 10};
        System.out.println(Arrays.toString(arr1));
        System.out.println("" + checkBalance(arr1));
        int[] arr2 = {1, 5, 3, 6, 3, 2, 11};
        System.out.println(Arrays.toString(arr2));
        System.out.println("" + checkBalance(arr2));
        System.out.println();
        // Тест задания 6
        System.out.println("Задание 7");
        int[] arr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Задан массив");
        System.out.println(Arrays.toString(arr3));
        Scanner in = new Scanner(System.in);
        int answer = 1;
        int shiftVal;
        do {
            System.out.print("Введите сдвиг: ");
            shiftVal = in.nextInt();
            shiftArray(arr3, shiftVal);
            System.out.println(Arrays.toString(arr3));
            System.out.print("Сдвигаем ещё раз? 1 - Да, другое число - нет : ");
            answer = in.nextInt();
        } while (answer == 1);
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("" + arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static double randomAB(int a, int b) {
        if (a > b) return (Math.random() * (a - b) + b);
        return (Math.random() * (b - a) + a);
    }

    // Задание 1
    public static void doTask1() {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = -1 * arr1[i] + 1;
        }
        System.out.println(Arrays.toString(arr1));
    }
    // Конец задания 1

    // Задание 2
    public static void doTask2() {
        int[] arr1 = new int[8];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr1));

    }
    // Конец задания 2

    //Задание 3
    public static void doTask3() {
        int[] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < 6) arr1[i] = arr1[i] * 2;
        }
        System.out.println(Arrays.toString(arr1));
    }

    //Конец задания 3

    //Задание 4
    public static void doTask4() {
        int[][] arr1 = new int[12][12];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (i == j) {
                    arr1[i][j] = 1;
                } else {
                    arr1[i][j] = 0;
                }
            }
        }
        printArr(arr1);
    }
    //Конец задания 4

    //Задание 5
    public static void doTask5() {
        int[] arr1 = new int[20];
        for (int i = 0; i < arr1.length; i++) { //Заполнение массива
            arr1[i] = (int) randomAB(0, 100);
        }
        System.out.println(Arrays.toString(arr1));
        findMinMax(arr1);

    }

    public static void findMinMax(int[] arr) {
        int nMin = arr[0];
        int nMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < nMin) {
                nMin = arr[i];
            } else if (arr[i] > nMax) {
                nMax = arr[i];
            }
        }
        System.out.println("Мин = " + nMin);
        System.out.println("Макс = " + nMax);
    }
    //Конец задания 5

    //Задание 6
    public static boolean checkBalance(int[] arr) {
        int aNum1 = findArrSum(arr);
        int aNum2 = 0;
        int i = 0;
        do {
            aNum1 = aNum1 - arr[i];
            aNum2 = aNum2 + arr[i];
            i++;
        } while (aNum1 > aNum2);
        // System.out.println(aNum1 = aNum2 ? "True" : "False");
        return (aNum1 == aNum2 ? true : false);
    }

    public static int findArrSum(int[] arr) {
        int aSum = 0;
        for (int i = 0; i < arr.length; i++) aSum = aSum + arr[i];
        return aSum;
    }
    //Конец задания 6

    //Задание 7

    public static void shiftArray(int[] arr, int a) {
        // приводим сдвиг к нормальному значению, положительному и меньшему размерности массива.
        // это размер второго блока
        if (a < 0) a = arr.length + a % arr.length;
        int sizeBlockB = a % arr.length;

        // если сдвиг равен нулю или кратен размеру массива - не делаем ничего
        if (sizeBlockB == 0) return;
        int sizeArray = arr.length;
        //Вычисляем размер первого блока
        int sizeBlockA = sizeArray - sizeBlockB;

        //Разворачиваем первый блок массива
        reversePartOfArray(arr, 0, sizeBlockA - 1);
        //Разворачиваем второй блок массива
        reversePartOfArray(arr, sizeBlockA, arr.length - 1);
        //Разворачиваем весь массив
        reversePartOfArray(arr, 0, arr.length - 1);
    }

    public static void reversePartOfArray(int[] arr, int i, int j) {
        int bufVal;
        do {
            bufVal = arr[i];
            arr[i] = arr[j];
            arr[j] = bufVal;
            i++;
            j--;
        } while (i < j);


        //Конец задания 7
    }
}