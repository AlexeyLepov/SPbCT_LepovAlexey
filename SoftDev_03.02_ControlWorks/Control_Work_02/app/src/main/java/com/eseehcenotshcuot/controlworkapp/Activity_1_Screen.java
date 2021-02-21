package com.eseehcenotshcuot.controlworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.util.Date;

public class Activity_1_Screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int sum = 1+2-4;
        TextView textView1 = new TextView(this);

        textView1.setTextSize(20);
        textView1.setText("\n Задание № 1: \n" + "\n 0 " + "\n 0 0 "  + "\n 0 0 0 " + "\n 0 0 0 0 " + "\n 0 0 0 0 0 " + "\n\n Задание № 2:\n\n" + "1 + 2 - 4 = " + sum);
        setContentView(textView1);

    }

}