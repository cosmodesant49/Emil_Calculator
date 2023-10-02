package com.geeks.emil_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;


public class PriceCardActivity extends AppCompatActivity {
    private Button myButton;
    private boolean isButtonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_card);

        TextView textView = findViewById(R.id.text_view);
        RangeSlider slider = findViewById(R.id.slider);
        RangeSlider slider2 = findViewById(R.id.slider2);
        String text = getIntent().getStringExtra(MainActivity.KEY1);
        textView.setText(text);
        myButton = findViewById(R.id.myButton);
        slider.setValues(1.0f,5.0f);
        slider2.setValues(1.0f,5.0f);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButtonPressed = !isButtonPressed;
                if (isButtonPressed) {
                    myButton.setBackgroundResource(R.drawable.heart_style);
                } else {
                    myButton.setBackgroundResource(R.drawable.heart_white_style);
                }
            }
        });
    }

    public void onNextClick(View view) {
        if (view.getId() == R.id.next) {
            finishAffinity();
        }
    }
}