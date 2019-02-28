package Lesson_7;

import java.util.Random;

public class Class_07 {


    public static void main(String[] args) {
        // Создание массивов котов и тарелок
        Cat[] catArray = new Cat[5];
        Plate[] plateArray = new Plate[3];
        boolean[] eatingCats = new boolean[5]; //Вспомогательный массив для отслеживания котов, которые едят сейчас

        // Инициализация массивов
        plateArray[0] = new Plate(10);
        plateArray[1] = new Plate(10);
        plateArray[2] = new Plate(30);
        catArray[0] = new Cat("Барсик", 1, 5);
        catArray[1] = new Cat("Мурзик", 3, 5);
        catArray[2] = new Cat("Пират", 3, 8);
        catArray[3] = new Cat("Бандит", 5, 6);
        catArray[4] = new Cat("Прожора", 5, 101);

        for (int i = 0; i < eatingCats.length; i++) eatingCats[i] = false; //Все коты приготовились к еде

        while ((isAnyFood(plateArray) > 0) && isAnyHungryCat(catArray)) { //Пока есть голодные коты и еда в тарелках
            printInfo(plateArray, catArray);
            for (int i = 0; i < 3; i++) {
                if (plateArray[i].getFood() > 0) feedTheCat(catArray[findBest(catArray, eatingCats)], plateArray[i]);
            }
            for (int i = 0; i < eatingCats.length; i++) eatingCats[i] = false; //Коты снова готовы к еде
        }
        printInfo(plateArray, catArray);
    }

    // Поиск кота с наивысшим приоритетом голод и сила
    public static int findBest(Cat[] catArray, boolean[] eatingCats) {
        int[] grade = new int[catArray.length]; //массив приоритетов
        int maxi = 0;
        Random random = new Random();

        for (int i = 0; i < grade.length; i++) {
            if (catArray[i].isHungry() == false || eatingCats[i]) continue;
            grade[i] = catArray[i].getShortage() + catArray[i].getStrength(); //Вычисление приоритета
            if (grade[i] < grade[maxi]) continue;
            if (grade[i] > grade[maxi]) {
                maxi = i;
                continue;
            }
            if (catArray[i].getStrength() == catArray[maxi].getStrength()) {
                maxi = random.nextInt(2) < 1 ? i : maxi;
            } else {
                maxi = catArray[i].getStrength() > catArray[maxi].getStrength() ? i : maxi;
            }
        }
        eatingCats[maxi] = true;
        return maxi;
    }

    // Кормление кота
    public static void feedTheCat(Cat cat, Plate plate) {
        cat.Feed(plate.TakeFood(cat.getShortage())); // Берём из тарелки не больше, чем кот готов сейчас съесть
    }

    // Проверка наличия еды в массиве тарелок
    public static int isAnyFood(Plate[] plateArray) {
        int food = 0;
        for (Plate plate : plateArray) food += plate.getFood();
        return food;
    }

    // Проверка наличия голодных котов
    public static boolean isAnyHungryCat(Cat[] catArray) {
        for (Cat cat : catArray) {
            if (cat.isHungry()) return true;
        }
        return false;
    }

    //
    public static void printInfo(Plate[] plateArray, Cat[] catArray) {
        System.out.println();
        for (Plate plate : plateArray) plate.printInfo();
        for (Cat cat : catArray) cat.printInfo();
        System.out.println();
    }
}
