package com.eseehcenotshcuot.controlworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_3_If extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3__if);
    }

    public void onClickBtn1(View view) {
        TextView textView = findViewById(R.id.res);
        try {
            EditText CX1 = findViewById(R.id.coordX1);
            int x1 = Integer.parseInt(CX1.getText().toString());

            EditText CY1 = findViewById(R.id.coordY1);
            int y1 = Integer.parseInt(CY1.getText().toString());

            EditText A1 = findViewById(R.id.a1);
            int a1 = Integer.parseInt(A1.getText().toString());

            EditText B1 = findViewById(R.id.b1);
            int b1 = Integer.parseInt(B1.getText().toString());

            EditText CX2 = findViewById(R.id.coordX2);
            int x2 = Integer.parseInt(CX2.getText().toString());

            EditText CY2 = findViewById(R.id.coordY2);
            int y2 = Integer.parseInt(CY2.getText().toString());

            EditText A2 = findViewById(R.id.a2);
            int a2 = Integer.parseInt(A2.getText().toString());

            EditText B2 = findViewById(R.id.b2);
            int b2 = Integer.parseInt(B2.getText().toString());

            int x, y, resx, resy;
            textView.setTextSize(20);

            if (b1*a1 > b2*a2){
                x = x1;
                y = y1;
                resx = a1 + x;
                resy = b1 + y;
                textView.setText("Координаты левого нижнего угла минимального прямоугольника: " + x + " , " +  y +
                        "\nКоординаты правого верхнего угла минимального прямоугольника: " + resx + " , " +  resy);
            }else if (b1*a1 < b2*a2){
                x = x2;
                y = y2;
                resx = a2 + x;
                resy = b2 + y;
                textView.setText("Координаты левого нижнего угла минимального прямоугольника: " + x + " , " +  y +
                        "\nКоординаты правого верхнего угла минимального прямоугольника: " + resx + " , " +  resy);
            } else{
                System.out.println("Неверные данные ввода!");
                textView.setText("Неверные данные ввода!");
            }


        } catch (NumberFormatException e) {
            System.out.println("Неверные данные ввода!");
            textView.setText("Неверные данные ввода!");
        }
    }

    public void onClickBtn2(View view) {
        TextView textView = findViewById(R.id.res);
        try {
            EditText Month = findViewById(R.id.month);
            int m = Integer.parseInt(Month.getText().toString());
            textView.setTextSize(20);

            if (0<m && m<4 || m==11 || m==12){
                textView.setText("Зима");
            } else if (4<+m && m<6){
                textView.setText("Весна");
            } else if (5<m && m<9){
                textView.setText("Лето");
            } else if (9<=m && m<11){
                textView.setText("Осень");
            } else {
                System.out.println("Неверные данные ввода!");
                textView.setText("Неверные данные ввода!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Неверные данные ввода!");
            textView.setText("Неверные данные ввода!");
        }
    }
}