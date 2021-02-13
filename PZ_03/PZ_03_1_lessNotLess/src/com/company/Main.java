package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите любое число: ");
        int num = in.nextInt();

        if (num>100){
            System.out.println( "not less" );
        }
        else {
            System.out.println( "less" );
        }

        System.out.printf("Ваше число: %d \n", num);
        in.close();
    }
}
