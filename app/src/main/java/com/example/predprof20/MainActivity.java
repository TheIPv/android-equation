package com.example.predprof20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.stream.IntStream;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText coeffA = (EditText)findViewById(R.id.coeffA);
        final EditText coeffB = (EditText)findViewById(R.id.coeffB);
        final EditText coeffC = (EditText)findViewById(R.id.coeffC);

        final TextView solution = (TextView)findViewById(R.id.solution);
            View sol = findViewById(R.id.getSolution);
        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coeffa = coeffA.getText().toString();
                String coeffb = coeffB.getText().toString();
                String coeffc = coeffC.getText().toString();
                if ((!coeffa.equals("") && !coeffb.equals("") && !coeffc.equals(""))) {
                    double s1 = parseDouble(coeffa);
                    double s2 = parseDouble(coeffb);
                    double s3 = parseDouble(coeffc);
                    if((s3-s2) >= 0) {
                        if((s3-s2) == 0) solution.setText("x - любое число");
                        else {
                            if (s1 == (float) ((int) s1) || s2 == (float) ((int) s2) || s3 == (float) ((int) s3)) {
                                double x1 = (s3 - s2) / s1;
                                double x2 = (-s3 + s2) / s1;
                                if (x1 == x2) solution.setText((int) x1);
                                if (x1 % 1 == 0) {
                                    if (x2 % 1 == 0) solution.setText((int) x1 + " " + (int) x2);
                                    else solution.setText((int) x1);
                                } else {
                                    if (x2 % 1 == 0) solution.setText((int) x2);
                                    else solution.setText("Нет решений");
                                }
                            } else solution.setText("Ошибка ввода");
                        }
                    }
                    else solution.setText("Нет решений");
                }
                else solution.setText("Ошибка ввода");
            }
        });
    }

}
