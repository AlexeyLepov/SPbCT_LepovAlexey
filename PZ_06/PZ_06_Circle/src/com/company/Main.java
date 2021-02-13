package com.company;
import java.lang.*;
import java.util.Scanner;

class Circle {
     private double x;
     private double y;
     private double r;
     private String color;

     public double getX() {
         return x;
     }
    public double getY() {
        return y;
    }
    public double getR() {
        return r;
    }
    public String getColor() {
        return color;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setR(double r) {
        this.r = r;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Circle(double x, double y, double r, String color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y = " + y +
                ", r = " + r +
                "< color='" + color + '\'' +
                '}';
    }
    public double getLength(){
         double c;
         c = 2 * Math.PI * r;
         return c;
    }
}

public class Main {

    public static void main(String[] args) {

        double r;
        Circle k1 = new Circle(3.1, 4.1, 5.1, "\u201c");
        System.out.println("\nДлина окружности равна: " + k1.getLength() + " см\n");

        Scanner source = new Scanner(System.in);
        System.out.print("Введите новый радиус окружности: ");
        r = source.nextDouble();
        k1.setR(r);

        System.out.println("Длина окружности равна: " + k1.getLength() + " см\n");
    }
}
