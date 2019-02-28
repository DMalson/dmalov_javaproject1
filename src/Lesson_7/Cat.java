package Lesson_7;

public class Cat {
    private static int idCounter;
    private int catID;
    private String name; //Кличка
    private int strength; //Сила - от 1 до 5
    private int catVoracity; //Прожорливость (ёмкость желудка) - от 1 до 10
    private int shortage; //Текущая нехватка до насыщения
    private boolean hungry; //Признак голода

    // Проверки параметров пока нет

    public Cat() {
        catID = idCounter++;
        strength = 1;
        catVoracity = 1;
        becameHungry();
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat(String name, int strength, int catVoracity) {
        this();
        this.name = name;
        this.strength = strength;
        this.catVoracity = catVoracity;
        becameHungry();
    }

    public int getCatID() {
        return catID;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getCatVoracity() {
        return catVoracity;
    }

    public int getShortage() {
        return shortage;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void becameHungry() {
        this.hungry = true;
        this.shortage = this.catVoracity;
    }

    // Если пищи больше, чем нужно, то кот съедает то, что может
    public void Feed(int food) {
        if (food < this.shortage) {
            this.shortage -= food;
            System.out.println(this.name + " съел " + food);
        } else {
            System.out.println(this.name + " съел " + this.shortage);
            this.shortage = 0;
            this.hungry = false;
        }
    }

    public void printInfo() {
        System.out.println(this.name + ((this.hungry) ? " голоден, хочет съесть " + this.shortage : " сыт."));
    }
}
