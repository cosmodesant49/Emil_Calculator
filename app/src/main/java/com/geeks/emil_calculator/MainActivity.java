package com.geeks.emil_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second;
    private String operator;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
            first = null;
            second = null;
            operator = null;
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
        if (view.getId() == R.id.btn_equal) {
            if (operator != null) {
                second = Integer.valueOf(textView.getText().toString());
                performOperation();
            }
        } else {
            if (first == null) {
                first = Integer.valueOf(textView.getText().toString());
            } else {
                second = Integer.valueOf(textView.getText().toString());
                performOperation();
            }
            operator = ((Button) view).getText().toString();
            isOperationClick = true;
        }
    }

    private void performOperation() {
        if (operator != null && second != null) {
            int result = 0;
            switch (operator) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    if (second != 0) {
                        result = first / second;
                    }
                    break;
            }
            textView.setText(String.valueOf(result));
            first = result;
            second = null;
        }
    }
}
