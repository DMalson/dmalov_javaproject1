package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Class_04 {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        // Проверка горизонталей
        char[] arrChar = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arrChar[j] = map[i][j];
            }
            if (findLength(arrChar, symb) >= DOTS_TO_WIN) return true;
        }
        // Проверка вертикалей
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                arrChar[i] = map[i][j];
            }
            if (findLength(arrChar, symb) >= DOTS_TO_WIN) return true;
        }
        // Проверка левых диагоналей
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; ((j <= SIZE - DOTS_TO_WIN) && (i == 0)) || j == 0; j++) {
                clearArray(arrChar);
                for (int k = 0; (i + k < SIZE) && (j + k < SIZE); k++) {
                    arrChar[k] = map[i + k][j + k];
                }
                if (findLength(arrChar, symb) >= DOTS_TO_WIN) return true;
            }
        }
        // Проверка правых диагоналей
        for (int i = SIZE - DOTS_TO_WIN; i < SIZE; i++) {
            for (int j = 0; ((j <= SIZE - DOTS_TO_WIN) && (i == SIZE - 1)) || j == 0; j++) {
                clearArray(arrChar);
                for (int k = 0; (i - k >= 0) && (j + k < SIZE); k++) {
                    arrChar[k] = map[i - k][j + k];
                }
                if (findLength(arrChar, symb) >= DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    private static void clearArray(char[] arrChar) {
        for (int i = 0; i < arrChar.length; i++) {
            arrChar[i] = ' ';
        }
    }

    private static int findLength(char[] arrChar, char symb) {
        int chainLength = 0;
        int maxLength = 0;
        for (char i : arrChar) {
            if (i == symb) {
                chainLength++;
                maxLength = (chainLength > maxLength) ? chainLength : maxLength;
            } else {
                chainLength = 0;
            }
        }
        return maxLength;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
