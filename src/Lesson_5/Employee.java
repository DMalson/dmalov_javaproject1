package Lesson_5;

import java.text.MessageFormat;

class Employee {
    private long id;
    private static long idCounter;
    private String firstName;
    private String secondName;
    private String surName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee() {
        idCounter++;
        id = idCounter;
        firstName = "n/a";
        secondName = "n/a";
        surName = "n/a";
        position = "n/a";
        email = "n/a";
        phone = "n/a";
    }

    public Employee(String fullname, String position, String email, String phone, int salary, int age) {
        this();
        this.surName = fullname.substring(0, fullname.indexOf(" "));
        this.secondName = fullname.substring(fullname.lastIndexOf(" ") + 1);
        this.firstName = fullname.substring(fullname.indexOf(" ") + 1, fullname.lastIndexOf(" "));
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public void printInfo() {
        System.out.println(MessageFormat.format(
                "ID = {0}, Name = {1}, Pos = {2}\n" +
                        "Email = {3}, Phone = {4}\n" +
                        "Salary = {5}, Age = {6} \n",
                this.id, getFullName(), this.position, this.email, this.phone,
                this.salary, this.age));
    }

    public String getFullName() {
        return this.surName + " " + this.firstName + " " + this.secondName;
    }

    public int getAge() {
        return this.age;
    }
}
