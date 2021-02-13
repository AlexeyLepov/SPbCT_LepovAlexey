package com.company;

public class Main {

    public static void main(String[] args) {

                Person tom = new Person(); // создание объекта
                tom.displayInfo();

                // изменяем имя и возраст
                tom.name = "Tom";
                tom.age = 34;
                tom.displayInfo();
    }
}

class Person{
    String name;    // имя
    int age;        // возраст

    void displayInfo(){
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
}
