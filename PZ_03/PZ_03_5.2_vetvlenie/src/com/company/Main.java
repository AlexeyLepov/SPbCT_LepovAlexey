package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите любое число: ");
        double x = in.nextDouble();
        double y;
        double a = 2.7;
        double b = -3.59;

        if (x > 2.){
            y = Math.pow((Math.cos(Math.pow((a*x),2))),3);
            System.out.println( "y = " + y);
        }
        else if (x>-1. && x<= 2.){
            y = Math.pow((2-x*x),3);
            System.out.println( "y = " + y);
        }
        else {
            y = Math.pow(Math.sin(x+b/x),2);
            System.out.println( "y = " + y);
        }

        in.close();
    }
}
