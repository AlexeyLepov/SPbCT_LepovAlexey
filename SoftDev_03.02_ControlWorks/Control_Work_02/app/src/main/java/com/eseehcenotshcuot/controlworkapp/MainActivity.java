package com.eseehcenotshcuot.controlworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickBtn1(View view) {
        Intent intent = new Intent(this, Activity_1_Screen.class);
        startActivity(intent);
    }

    public void onClickBtn2(View view) {
        Intent intent = new Intent(this, Activity_2_Math.class);
        startActivity(intent);
    }

    public void onClickBtn3(View view) {
        Intent intent = new Intent(this, Activity_3_If.class);
        startActivity(intent);
    }

    public void onClickBtn4(View view) {
        Intent intent = new Intent(this, Activity_4_For.class);
        startActivity(intent);
    }

    public void onClickBtn5(View view) {
        Intent intent = new Intent(this, Activity_5_Char.class);
        startActivity(intent);
    }

}