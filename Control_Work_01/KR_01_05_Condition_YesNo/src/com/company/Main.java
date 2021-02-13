package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int n1 = in.nextInt();
        System.out.print("Введите второк число: ");
        int n2 = in.nextInt();
        System.out.print("Введите третье число: ");
        int n3 = in.nextInt();

        if(n1>10 && n2>10 && n3>10 && n1%3==0 && n2%3==0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
