package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.setProperty("console.encoding","Cp866");
        char[] arr = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'э', 'ю', 'я',
                'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
                'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я'};

        char[][] chr = new char[7][7];
        Random generator = new Random();
        int randomIndex;

        System.out.println("\nКвадрат 7x7 из случайных букв:");
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                randomIndex = generator.nextInt(arr.length);
                chr[i][j] = (char) arr[randomIndex];
                System.out.print(" "+chr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
