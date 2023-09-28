package com.geeks.emil_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    private void testText(String t){

    }

    public void onNumberClick(View view) {
        //проверка на показ числа с кнопки и склейка
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
            first = 0;
            second = 0;
        } else {
            String textButton = ((Button) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(textButton);
            } else {
                textView.append(textButton);
            }
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "-";
        } else if (view.getId() == R.id.btn_multiply) {
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "*";
        } else if (view.getId() == R.id.btn_divide) {
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            Integer result = 0;

            if (operation.equals("+")) {
                result = first + second;
            } else if (operation.equals("-")) {
                result = first - second;
            } else if (operation.equals("*")) {
                result = first * second;
            } else if (operation.equals("/")) {
                if (second != 0) {
                    result = first / second;
                } else {
                    Toast.makeText(this, "Ошибка: Деление на ноль", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            textView.setText(result.toString());
            isOperationClick = false;
        }
    }
}