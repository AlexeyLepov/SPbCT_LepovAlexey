package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите любое число: ");
        double x = in.nextDouble();
        double y;
        double a = 1.9;
        double b = 3.4;

        if (x >= 5.){
            y = Math.log1p(Math.sqrt(Math.abs(b-x)));
            System.out.println( "y = " + y);
        }
        else {
            y = Math.pow(Math.sin(a+x),3);
            System.out.println( "y = " + y);
        }

        in.close();
    }
}
