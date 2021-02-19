package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {
    final Random random = new Random();

    public static int[] put (int[] m, int n){
        Random random = new Random();
        int[] M = new int[m.length];;
        if (m.length == n)
            M = new int[m.length*2];
        for (int i = 0; i < n; i++) {
            M[i] = m[i];
        }
        M[n] = random.nextInt(30 + 1);
        System.out.println("\nМассив с добавлением нового элемента:");
        for(int i = 0; i < M.length; i++){
            System.out.print(M[i] + " ");
        }
        return M;
    }

    public static void get (int[] m, int n){
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите номер индекса элемента для его получения: ");
        int l = in.nextInt();
        if (l<0 || l>=n)
            System.out.print("Элемента c таким индексом не существует");
        else
            System.out.print(m[l] + " ");
    }

    public static void getall (int[] m, int n){
        System.out.println("\n\nИсходный массив:");
        for(int i = 0; i < n; i++){
            System.out.print(m[i] + " ");
        }
    }

    public static void sort (int[] m, int n) {

        for (int i = m.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (m[j] > m[j + 1]) {
                    int tmp = m[j];
                    m[j] = m[j + 1];
                    m[j + 1] = tmp;
                }
            }
        }
        System.out.println("\nУпорядоченный по возрастанию массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(m[i] + " ");
        }
    }

    public static void sort_Odd_even (int[] m, int n) {

        int sorted = 0;
        while(sorted == 0) {
            sorted = 1;
            for(int i = 1; i < n - 2; i += 2) {
                if(m[i] > m[i + 1]) {
                    int tmp = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = tmp;
                    sorted = 0;
                }
            }
            for(int i = 0; i < n - 1; i += 2) {
                if(m[i] > m[i + 1]) {
                    int tmp = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = tmp;
                    sorted = 0;
                }
            }
        }
        System.out.println("\nЧётно-нечётная сортировка массива: ");
        for (int i = 0; i < n; i++) {
            System.out.print(m[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.print("Введите любое число: ");
        //int n = in.nextInt();

        Random random = new Random();
        int N = 20;
        int[] B = new int[N];

        for(int i = 0; i < N; i++){
            B[i] = random.nextInt(30 + 1);
        }
            getall(B,N);
            sort_Odd_even(B,N);
            sort(B,N);
            get(B,N);
            put(B,N);
    }
}
