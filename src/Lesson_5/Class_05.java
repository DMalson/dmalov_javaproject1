package Lesson_5;

public class Class_05 {


    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0]=new Employee("Иванов Алексей Николаевич","Директор","ipi@company.ru",
                "+7(901)1111111",120000,35);
        persArray[1]=new Employee("Ан Ким Инович","Программист","aki@company.ru",
                "+7(901)2222222",70000,25);
        persArray[2]=new Employee("Тургенев Иван Сергеевич","Писатель","tis@company.ru",
                "+7(901)3333333",80000,52);
        persArray[3]=new Employee("Чичиков Петр Иванович","Коммивояжер","cpi@company.ru",
                "+7(901)4444444",110000,38);
        persArray[4]=new Employee("Садыков Равиль Ахметович","Завхоз","ras@company.ru",
                "+7(901)5555555",120000,56);

        for (Employee person:persArray
             ) {
            if (person.getAge()>40) person.printInfo();
        }
    }
}
