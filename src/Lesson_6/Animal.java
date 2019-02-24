package Lesson_6;

public abstract class Animal {
    protected String name;
    protected int age;
    protected int weight;
    protected String gender;
    protected String color;
    protected float runLimit;
    protected float jumpLimit;
    protected float swimLimit;
    protected String type;


    public Animal() {
    }

    public Animal(String name, int age, int weight, String gender, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Animal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(float runLimit) {
        this.runLimit = runLimit > this.runLimit ? this.runLimit : runLimit;
        this.runLimit = (float) ((int) this.runLimit*100)/100;
    }

    public float getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(float jumpLimit) {
        this.jumpLimit = jumpLimit > this.jumpLimit ? this.jumpLimit : jumpLimit;
    }

    public float getSwimLimit() {
        return swimLimit;
    }

    public void setSwimLimit(float swimLimit) {
        this.swimLimit = swimLimit > this.swimLimit ? this.swimLimit : swimLimit;
    }

    public void printInfo() {
        System.out.println("Животное" + "\n" +
                "Кличка: " + name + "\n" +
                "Тип: " + this.type + "\n" +
                "Возраст: " + age + "\n" +
                "Вес: " + weight + "\n" +
                "Пол: " + gender + "\n" +
                "Цвет: " + color + "\n" +
                "Бег: " + runLimit + "\n" +
                "Прыжок: " + jumpLimit + "\n" +
                "Плавание: " + swimLimit
        );
    }

    public void run(int distance) {
        System.out.print(name + " ");
        System.out.println(distance <= runLimit ? "run: True" : "run: False");
    }

    public void jump(float height) {
        System.out.print(name + " ");
        System.out.println(height <= jumpLimit ? "jump: True" : "jump: False");
    }

    public void swim(int length) {
        System.out.print(name + " ");
        System.out.println(length <= swimLimit ? "swim: True" : "swim: False");
    }

    public abstract float getMaxRun();
    public abstract float getMaxSwim();
    public abstract float getMaxJump();

}
