package Lesson_7;

public class Plate {
    private int food;
    private static int idCounter;
    private int plateID;
    private int capacity=10; //ёмкость тарелки

    public Plate(int food) {
        this.food = food;
        plateID=idCounter++;
    }

    public int getplateID(){
        return plateID;
    }

    public int getFood() {
        return food;
    }

    public int TakeFood(int food){
        if (food<=this.food){
            this.food-=food;
            System.out.println("Из тарелки " + this.plateID + " съели " + food);
            return food;
        }
        food=this.food;
        System.out.println("Из тарелки " + this.plateID + " съели " + food);
        this.food=0;
        return food;
    }

    public void AddFood (int food){
        this.food+=food;
        if (this.food>this.capacity) this.food=this.capacity; //Если добавили еды больше чем нужно, то она просыпалась
    }

    public void printInfo(){
        System.out.println("Тарелка " + this.plateID + " " + this.food + " еды.");
    }

}
