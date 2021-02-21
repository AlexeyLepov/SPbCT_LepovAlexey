package com.eseehcenotshcuot.controlworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_4_For extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4__for);

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 10; i<89; i++){
            sum1 += i;
        }

        for (int i = 23; i<911; i=i+11){
            sum2 += i;
        }

        TextView textView1 = new TextView(this);
        textView1.setTextSize(20);
        textView1.setText("\nЗадание № 1: \nСумма ряда 10+11+12+13+...+88 равна: \n\n" + sum1 +
                        "\n\nЗадание № 2: \nСумма ряда 23+34+45+...+910 равна: \n\n" + sum2);
        setContentView(textView1);
    }
}