package Lesson_1;

import static java.lang.Math.*;

public class Class_01 {

    // Задание 2

    static byte aByte = 12;
    static short aShort = 220;
    static int aInt = 25400;
    static long lLong = 625272976;

    static float aFloat = 543.354F;
    static double aDouble = 22267.87793;

    static boolean aBoolean = true;

    static char aChar = 'D';

    String aString = "Simple string";

    // Конец задания 2

    public static void main(String[] args) {
        //тест задания 3
        System.out.println("5*(3+(6/3))=" + arythMix(5, 3, 6, 3));
        //тест задания 4
        System.out.println("15+3 попадает в диапазон от 10 до 20? " + fromTenToTwenty(15, 3));
        System.out.println("15+7 попадает в диапазон от 10 до 20? " + fromTenToTwenty(15, 7));
        //тест задания 5
        whatNumber(7);
        whatNumber(-6);
        //тест задания 6
        System.out.println("5 - отрицательное? - " + ifNegative(5));
        System.out.println("-2 - отрицательное? - " + ifNegative(-2));
        //тест задания 7
        privetName("Дмитрий");
        //тест задания 8
        System.out.println("True True " + proveTrue(true, true));
        System.out.println("True False " + proveTrue(true, false));
        System.out.println("False True " + proveTrue(false, true));
        System.out.println("False False " + proveTrue(false, false));
        //тест задания 10
        System.out.println("3 и 5 - кратные? " + aliquotNumbers(3, 5));
        System.out.println("3 и 6 - кратные? " + aliquotNumbers(3, 6));
        System.out.println("6 и 2 - кратные? " + aliquotNumbers(6, 2));
        //тест задания 11
        System.out.println("3, 5, 7 могут быть сторонами треугольника? " + canBeTriangle(3, 5, 7));
        System.out.println("3, 5, 9 могут быть сторонами треугольника? " + canBeTriangle(3, 5, 9));
        //Тест задания 12
        System.out.println("1923 " + isLeapYear(1923));
        System.out.println("1900 " + isLeapYear(1900));
        System.out.println("2000 " + isLeapYear(2000));
        System.out.println("1972 " + isLeapYear(1972));
        //Тест задания 13
        System.out.println("Случайное число от 5 до 12 - " + randomAB(5, 12));
        //Тест задания 14
        System.out.println("Кубик дважды - " + diceTwice());
        System.out.println("Кубик дважды - " + diceNTimes(2));
        //Тест задания 15
        sumOfSin(PI / 6);
        //Тест задания 16
        System.out.println("12.01 - " + checkDates_20_03_20_06(1, 12));
        System.out.println("22.04 - " + checkDates_20_03_20_06(4, 22));
        System.out.println("32.05 - " + checkDates_20_03_20_06(5, 32));
        //Тест задания 17
        convertRGBToCMYK(205,218,66);
        convertRGBToCMYK(260,200,100);
        //Тест задания 18
        allThreeEqual(2,5,5);
        allThreeEqual(58,58,58);
        //Тест задания 19
        checkXY_01(0.1891892,0.98);
        checkXY_01(1,0.58);

    }

    //Задание 3. Без обработки ошибки деления на ноль
    public static float arythMix(int a, int b, int c, int d) {
        return a * (b + c / d);
    }
    //Конец задания 3

    //Задание 4
    public static boolean fromTenToTwenty(int a, int b) {
        if ((a + b) < 10) return false;
        if ((a + b) > 20) return false;
        return true;
    }
    //Конец задания 4

    //Задание 5
    public static void whatNumber(int number) {
        if (number < 0) {
            System.out.println("" + number + " - отрицательное число");
        } else {
            System.out.println("" + number + " - положительное число");
        }
    }
    //Конец задания 5

    //Задание 6
    public static boolean ifNegative(int a) {
        return a < 0;
    }
    //Конец задания 6

    //Задание 7
    public static void privetName(String name) {
        System.out.println("Привет, " + name);
    }
    //Конец задания 7

    //Задание 8
    public static boolean proveTrue(boolean a, boolean b) {
        return ((!(a && b) && (a || b)) || ((a && b) || !(a || b)));
    }
    //Конец задания 8

    // Задание 9
    // Выражение (!(a < b) && !(a > b)) эквивалентно (a == b)
    // Конец задания 9

    //Задание 10
    public static boolean aliquotNumbers(int a, int b) {
        return (((a % b) == 0) || ((b % a) == 0));
    }
    //Конец задания 10

    //Задание 11. Возвращает true если ни одно из трёх чисел не больше суммы двух других
    public static boolean canBeTriangle(int a, int b, int c) {
        if (a > b + c) return false;
        if (b > a + c) return false;
        if (c > a + b) return false;
        return true;
    }
    //Конец задания 11

    //Задание 12
    public static boolean isLeapYear(int a) {
        if ((a % 4) != 0) return false;
        if ((a % 400) == 0) return true;
        if ((a % 100) == 0) return false;
        return true;
    }
    //Конец задания 12

    //Задание 13
    public static double randomAB(int a, int b) {
        if (a > b) return (Math.random() * (a - b) + b);
        return (Math.random() * (b - a) + a);
    }
    //Конец задания 13

    //Задание 14
    public static int diceOnce() {    // Имитация одиночного броска кубика
        return (int) Math.round(randomAB(0, 6) + 0.5);
    }

    public static int diceTwice() {   //Имитация броска кубика два раза (двух кубиков)
        return (diceOnce() + diceOnce());
    }

    public static int diceNTimes(int n) {   //Имитация броска кубика n раз (n кубиков)
        int result = 0;
        do {
            result = result + diceOnce();
            //       System.out.println(result);
        } while (--n > 0);
        return result;
    }
    //Конец задания 14

    //Задание 15
    public static void sumOfSin(double t) {
        System.out.println((sin(2 * t) + sin(3 * t)));
    }
    //Конец задания 15

    //Задание 16
    public static boolean checkDates_20_03_20_06(int m, int d) {
        //Проверяем дату на попадание в диапазон от 20 марта до 20 июня
        switch (m) {
            case 3:
                return between(d, 20, 31);
            case 4:
                return between(d, 1, 30);
            case 5:
                return between(d, 1, 31);
            case 6:
                return between(d, 1, 20);
            default:
                return false;
        }
    }

    public static boolean between(int x, int a, int b) { //Проверяем попадание х в интервал от а до в
        if ((x >= a) && (x <= b)) return true;
        return false;
    }
    //Конец задания 16

    //Задание 17. RGB to CMYK конвертер
    // R,G,B - от 0 до 255, используем целые значения , примерно 17 млн цветов
    // C,M,Y,K - от 0 до 1
    // Источник формулы https://www.rapidtables.com/convert/color/rgb-to-cmyk.html

    public static void convertRGBToCMYK(int r, int g, int b) {
        float c, m, y, k;
        if (between(r, 0, 255) && between(g, 0, 255) && between(b, 0, 255)) {
            float r1 = (float) r / 255;
            float g1 = (float) g / 255;
            float b1 = (float) b / 255;
            float maxVal= Math.max(r, Math.max(g,b));
            k = 1 - (maxVal/ 255);
            c = (1 - r1 - k) / (1 - k);
            m = (1 - g1 - k) / (1 - k);
            y = (1 - b1 - k) / (1 - k);
            System.out.println("R=" + r + "; G=" + g + ";B=" + b);
            System.out.println("C=" + c + "; M=" + m + ";Y=" + y + ";K=" + k);
        } else {
            System.out.println("Ошибочные данные");
            System.out.println("R=" + r + "; G=" + g + ";B=" + b);
        }
    }
    // Конец задания 17

    //Задание 18
    public static void allThreeEqual (int a, int b, int c){
        System.out.println(((a==b) && (b==c)) ? "Все три числа равны":"не равны");
    }
    //Конец задания 18

    //Задание 19
    public static void checkXY_01 (double x, double y){
        System.out.println(((betweenD(x,0.0,1.0) && betweenD(y,0.0,1.0)) ? "Условие выполнено":"Условие не выполнено"));
    }

    public static boolean betweenD(double x, double a, double b) { //Проверяем попадание х в интервал от а до в
        if ((x > a) && (x < b)) return true;
        return false;
    }
    //Конец задания 19

}

