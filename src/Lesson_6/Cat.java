package Lesson_6;

public class Cat extends Animal {

    public Cat() {
        setLimits();
    }

    public Cat(String name) {
        super(name);
        setLimits();
    }

    public Cat(String name, int age, int weight, String gender, String color) {
        super(name, age, weight, gender, color);
        setLimits();

    }

    private void setLimits(){
        super.runLimit = getMaxRun();
        super.jumpLimit = getMaxJump();
        super.swimLimit = getMaxSwim();
        super.type = "Кошка";
    }

    @Override
    public float getMaxRun() {
        return 200;
    }

    @Override
    public float getMaxSwim() {
        return 0;
    }

    @Override
    public float getMaxJump() {
        return 2;
    }
}
