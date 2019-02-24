package Lesson_6;

import java.util.Random;

public class Class_06 {


    public static void main(String[] args) {

        Animal[] animals = new Animal[10]; //Создание массива животных
        Random random = new Random();
        // Заполнение массива животных экземплярами
        for (Animal animal : animals) {
            if (random.nextInt(2) < 1) {
                animal = new Cat();
                createNewAnimal(animal);
                animal.printInfo();
            } else {
                animal = new Dog();
                createNewAnimal(animal);
                animal.printInfo();
            }
            // Проверка 70% способностей конкретного экземпляра животного
            animal.run((int) Math.round(animal.getMaxRun() * 0.7));
            animal.jump((float) Math.round(animal.getMaxJump() * 70) / 100);
            animal.swim((int) Math.round(animal.getMaxSwim() * 0.7));
            System.out.println();
        }

    }

    public static void createNewAnimal(Animal animal) {
        // Массивы исходных данных для случайной генерации животного
        String[] nameList = {"Мурзик", "Барсик", "Тоша", "Тиша", "Белка", "Стрелка", "Маркиз", "Барон", "Муся", "Мася",
                "Кеся", "Маня", "Филя"};
        String[] colorList = {"Белый", "Серый", "Черный", "Рыжий", "Разноцветный"};
        String[] genderList = {"Самец", "Самка"};

        Random random = new Random();
        // Установка универсальных параметров объектов
        animal.setName(nameList[random.nextInt(nameList.length)]);
        animal.setAge(random.nextInt(16));
        animal.setGender(genderList[random.nextInt(genderList.length)]);
        animal.setColor(colorList[random.nextInt(colorList.length)]);

        // Установка параметров, зависящих от типа
        switch (animal.getType()) {
            case "Кошка":
                animal.setWeight(random.nextInt(10) + 1);
                // break;
            case "Собака":
                animal.setWeight(random.nextInt(15) + 1);
                // break;
            default:
                animal.setJumpLimit(random.nextFloat() * animal.getMaxJump() * 1.2F);
                animal.setRunLimit(random.nextFloat() * animal.getMaxRun() * 1.2F);
                animal.setSwimLimit(random.nextFloat() * animal.getMaxSwim() * 1.2F);
        }
    }
}
