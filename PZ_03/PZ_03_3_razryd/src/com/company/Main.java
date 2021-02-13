package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите любое число: ");
        int bal = in.nextInt();

        if (bal<=100 && bal>=91){
            System.out.println( "Ваш разряд: А" );
        }
        else if (bal<=90 && bal>=81){
            System.out.println( "Ваш разряд: B" );
        }
        else if (bal<=80 && bal>=71){
            System.out.println( "Ваш разряд: C" );
        }
        else if (bal<=70 && bal>=61){
            System.out.println( "Ваш разряд: D" );
        }
        else if (bal<=60 && bal>=51){
            System.out.println( "Ваш разряд: E" );
        }
        else if (bal<=50){
            System.out.println( "Ваш разряд: F" );
        }
        else {
            System.out.println( "Такого количества баллов не существует" );
        }
        in.close();
    }
}
