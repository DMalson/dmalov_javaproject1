package Lesson_6;

public class Dog extends Animal {

    public Dog() {
        setLimits();
    }

    public Dog(String name) {
        super(name);
        setLimits();
    }

    public Dog(String name, int age, int weight, String gender, String color) {
        super(name, age, weight, gender, color);
        setLimits();

    }

    private void setLimits(){
        super.runLimit = getMaxRun();
        super.jumpLimit = getMaxJump();
        super.swimLimit = getMaxSwim();
        super.type = "Собака";
    }

    @Override
    public float getMaxRun() {
        return 500;
    }

    @Override
    public float getMaxSwim() {
        return 10;
    }

    @Override
    public float getMaxJump() {
        return 0.5F;
    }
}
