package com.company;

public class Main {

    public static void main(String[] args) {
        int i=300000;
        System.out.println(i*i);   // умножение с точностью 32 бита

        long m=i;
        System.out.println(m*m);   // умножение с точностью 64 бита
        System.out.println(1/(m-i));
    }
}
