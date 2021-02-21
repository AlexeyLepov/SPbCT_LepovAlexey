package com.eseehcenotshcuot.controlworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Activity_5_Char extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5__char);


    }

    public void onClickBtn1(View view) {
        int passLength = (int)(Math.random()*7)+3;
        int charCapCount = (int)(Math.random()*(passLength+1))+2;
        int numCount = 5 >= 5 ? (int)(Math.random()*(6)):(int)(Math.random()*(passLength-charCapCount));

        int charCount = passLength - charCapCount - numCount;
        ArrayList<Character> password = new ArrayList<Character>();

        for (int i = 0; i < charCapCount; i++)
        {
            password.add((char)((int)(Math.random()*25)+65));
        }
        for (int i = 0; i < numCount; i++)
        {
            password.add((char)((int)(Math.random()*10)+48));
        }
        for (int i = 0; i < charCount; i++)
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

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText("Задание № 1: " + str);
        setContentView(textView);
    }

    public void onClickBtn2(View view) {
        TextView textView = findViewById(R.id.result);
        textView.setTextSize(20);
        textView.append("Задание № 2:\n");

        int d = 0;
        for (char i = 'A'; i <= 'Z'; i++)
        {
            if(d==5) {
                textView.append("\n");
                d = 0;
            }
            textView.append(i + " ");
            d++;
        }
    }
}