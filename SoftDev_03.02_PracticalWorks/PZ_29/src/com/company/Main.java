package com.company;

import java.io.*;

public class Main {

    static long ShiftRegister = (long) (Math.random() * (511 - 256)) +256;
    static String opent = "";
    public static void main(String[] args ) throws IOException {
        //читаем из файла сообщение, которое нужно зашифровать
        FileReader reader = new FileReader("resources\\opent.txt");
        // читаем посимвольно
        int c;
        while((c=reader.read())!=-1)
            opent +=(char)c;

        //записываем в файл начальное значение скремблера
        FileWriter writer = new FileWriter("resources\\key.txt", false);
        writer.write(Long.toString(ShiftRegister));
        writer.flush();


        System.out.println("\n================================");
        System.out.println("            ШИФРАЦИЯ");
        System.out.println("================================\n");
        System.out.printf("Начальное значение скрамблера: %d (%s)\n",ShiftRegister,Long.toBinaryString(ShiftRegister));
        System.out.println("Исходное шифруемое сообщение: "+opent);
        char[] arr = opent.toCharArray(); //разбиваем строку на массив символов
        int n = arr.length * 8; //вычисляем длину ключа
        //генерируем ключ (гамму)
        String keyBin =Long.toString(ShiftRegister & 0x01);
        for(int i = 0; i <n-1; i++) {
            keyBin+=LFSR();
        }

        //переводим исходный текст в hex и bin системы
        String openHex = "", openBin ="";
        System.out.println("Ключ (Гамма): "+keyBin);
        for (int i = 0; i<arr.length; i++)
        {
            int b = (int)arr[i];
            openHex += String.format("%x ", b);
            if((Integer.toBinaryString(b).length() == 7))
                openBin += "0";
            else if ((Integer.toBinaryString(b).length() == 6))
                openBin += "00";
            openBin += Integer.toBinaryString(b);
        }
        System.out.println("Исходное сообщение в 16-ричном формате: "+openHex);
        System.out.println("Исходное сообщение в двоичном формате : "+openBin);

        System.out.println(" ");
        //выполняем операцию xor между гаммой и исходным текстом
        String closeBin = "", closeHex = "";
        for (int i = 0, j = 0; i < keyBin.length(); i++, j++)
            closeBin += (int)keyBin.charAt(i)^(int) openBin.charAt(i);
        System.out.println("Зашифрованое сообщение в двоичном формате : "+closeBin);

        //переводим зашифрованный текст в hex и bin системы
        String[] A = closeBin.split("(?<=\\G.{8})");
        String closet = "";
        for (int i =0 ; i<A.length;i++ )
        {
            closeHex+=String.format("%x ",Integer.parseInt(A[i],2));
            closet += (char)Integer.parseInt(A[i],2);
        }

        System.out.println("Зашифрованое сообщение в 16-ричном формате: "+closeHex);
        System.out.println("Зашифрованное сообщение: "+ closet);

        //записываем зашифрованный текст в файл
        writer = new FileWriter("resources\\closet.txt", false);
        writer.write(closet);
        writer.flush();

        System.out.println("\n================================");
        System.out.println("           ДЕШИФРАЦИЯ");
        System.out.println("================================\n");

        String openDBin = "";
        //выполняем операцию xor между ключом и зашифрованным текстом
        for (int i = 0, j = 0; i < keyBin.length(); i++, j++)
            openDBin += (int)keyBin.charAt(i)^(int) closeBin.charAt(i);
        System.out.println("Открытие зашифрованного сообщения в двоичном формате :"+openDBin);

        //переводим расшифрованный текст в hex и bin системы
        String[] B = openDBin.split("(?<=\\G.{8})");
        String openDt = "", openDHex = "";
        for (int i =0 ; i<B.length;i++ )
        {
            openDHex+=String.format("%x ",Integer.parseInt(B[i],2));
            openDt += (char)Integer.parseInt(B[i],2);
        }
        System.out.println("Открытие зашифрованного сообщения в 16-ричном формате: "+openDHex);
        System.out.println("Дешифрование зашифрованного текста: "+ openDt);

    }

    public static long LFSR ()
    {
        ShiftRegister =
                ((((ShiftRegister >> 6) ^ (ShiftRegister >> 3)) & 0x01) << 6) | (ShiftRegister >> 1);
        return (ShiftRegister & 0x01);
    }

}
