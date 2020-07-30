package com.example.conicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onBtnCalculateClick(View view) {
        EditText X1 = findViewById(R.id.X1);
        EditText X2 = findViewById(R.id.X2);
        EditText Y1 = findViewById(R.id.Y1);
        EditText Y2 = findViewById(R.id.Y2);
        TextView answer = findViewById(R.id.answerText);

        int num1 = Integer.parseInt(X1.getText().toString());
        int num2 = Integer.parseInt(Y1.getText().toString());
        int num3 = Integer.parseInt(X2.getText().toString());
        int num4 = Integer.parseInt(Y2.getText().toString());

        double squaringAndAdding = Math.pow(num3 - num1, 2) + Math.pow(num4 - num2, 2);
        double squareRoot = Math.sqrt(squaringAndAdding);
        if (squareRoot - Math.floor(squareRoot) == 0) {
            answer.setText(String.valueOf(squareRoot));
        }
        else {
            int squaredAnswer = (int)squaringAndAdding;
            int a = 0;
            int b = 0;
            int count = 0;

            for (int i = 1; i < squaredAnswer; i++) {
                if ((i * (squaredAnswer / i)) == squaredAnswer) {
                    a = i;
                    b = squaredAnswer / i;
                    if (Math.sqrt(a) % 1 == 0) {
                        if (a != 1) {
                            answer.setText(Math.sqrt(a) + "\u221A" + b);
                            count = 1;
                        }
                    }
                }
            }
        }
    }
}
