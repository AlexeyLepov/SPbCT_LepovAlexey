package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(1e-40f/1e10f);   // underflow для float
        System.out.println(-1e-300/1e100);  // underflow для double

        float f=1e-6f;
        System.out.println(f);

        f+=0.002f;
        System.out.println(f);

        f+=3;
        System.out.println(f);

        f+=4000;
        System.out.println(f);
    }
}
