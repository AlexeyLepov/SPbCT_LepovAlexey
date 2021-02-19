package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите число N: ");
        int n = in.nextInt();
        long sum = 0;
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" "+n1+" ");
        for(int i = 3; i <= n; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
            sum=n2;
        }
        System.out.println("\n\nНайдено N-ое число ряда Фибоначчи: " + sum);
    }
}
