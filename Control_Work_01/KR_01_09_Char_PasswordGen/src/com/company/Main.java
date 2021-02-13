package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int PasswordLength = (int)(Math.random()*15)+5;
        int CharacterCapCount = (int)(Math.random()*(PasswordLength+1))+2;
        int NumberCount = 5 >= 5 ? (int)(Math.random()*(6)):(int)(Math.random()*(PasswordLength-CharacterCapCount));

        int CharacterCount = PasswordLength - CharacterCapCount - NumberCount;
        ArrayList<Character> password = new ArrayList<Character>();
        Random r = new Random();
        password.add('_');
        for (int i = 0; i < CharacterCapCount; i++)
        {
            password.add((char)((int)(Math.random()*25)+65));
        }
        for (int i = 0; i < NumberCount; i++)
        {
            password.add((char)((int)(Math.random()*10)+48));
        }
        for (int i = 0; i < CharacterCount; i++)
        {
            password.add((char)((int)(Math.random()*26)+97));
        }
        Collections.shuffle(password);
        String str = password.toString().replaceAll(", |\\[|\\]", "");
        while (str.matches("(.*)\\d{2}(.*)"))
        {
            Collections.shuffle(password);
            str = password.toString().replaceAll(", |\\[|\\]", "");
        }
        System.out.println("Пароль сгенерирован:");
        System.out.println(str);
    }
}
