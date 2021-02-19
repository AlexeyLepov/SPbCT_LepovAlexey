package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество недель: ");
        int weeks = in.nextInt();
        System.out.print("Введите количество месяцев: ");
        int month = in.nextInt();
        System.out.print("Введите количество лет: ");
        int years = in.nextInt();

        int numb = weeks*7 + month*30 + years*12*30;
        System.out.println("Количество дней за это время: " + numb);
    }
}
