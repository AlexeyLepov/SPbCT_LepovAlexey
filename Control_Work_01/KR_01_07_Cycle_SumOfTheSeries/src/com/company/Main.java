package com.company;

public class Main {
    public static void main(String[] args) {
        int n = 1;
        long sum = 0;
        for(int i = 0; 3*i <= 112; i++)
        {
            sum+=n+3*i;
            //System.out.println("Сумма ряда равна: " + sum);
        }
        System.out.println("Сумма ряда равна: " + sum);
    }
}
