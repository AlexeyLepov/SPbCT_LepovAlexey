package com.eseehcenotshcuot.controlworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_2_Math extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2__math);
    }


    public void onClickBtn1(View view) {
        TextView textView = findViewById(R.id.res);
        try {
            EditText X = findViewById(R.id.x);
            int x = Integer.parseInt(X.getText().toString());

            EditText A = findViewById(R.id.a);
            int a = Integer.parseInt(A.getText().toString());

            EditText Y = findViewById(R.id.y);
            int y = Integer.parseInt(Y.getText().toString());

            EditText K = findViewById(R.id.k);
            int k = Integer.parseInt(K.getText().toString());

            textView.setTextSize(20);
            textView.setText((x) + " кг конфет стоит: " + (a) + " руб.\n" +
                             (y) + " кг конфет будет стоить " +  (y*a/x) + " руб\nА на " +
                             (k) + " руб можно купить " + (k*x/a) +" кг конфет.");

        } catch (NumberFormatException e) {
            System.out.println("Неверные данные ввода!");
            textView.setText("Неверные данные ввода!");
        }
    }

    public void onClickBtn2(View view) {
        TextView textView = findViewById(R.id.res);
        try {
            EditText A = findViewById(R.id.NumA);
            int a = Integer.parseInt(A.getText().toString());

            EditText B = findViewById(R.id.NumB);
            int b = Integer.parseInt(B.getText().toString());

            textView.setTextSize(20);
            a=a+b-(b=a);
            textView.setText("Произведено действие: a=a+b-(b=a)\nРезультат: число А: " + a + " число В: " + b);

        } catch (NumberFormatException e) {
            System.out.println("Неверные данные ввода!");
            textView.setText("Неверные данные ввода!");
        }

    }
}