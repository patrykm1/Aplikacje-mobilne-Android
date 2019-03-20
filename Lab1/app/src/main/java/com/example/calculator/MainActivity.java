package com.example.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Spinner spinner1;
    Spinner spinner2;
    TextView textViewResult;
    double tempA;
    double tempB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.buttonPlus);
        button2 = findViewById(R.id.buttonMinus);
        button3 = findViewById(R.id.buttonMultiply);
        button4 = findViewById(R.id.buttonDivide);
        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        textViewResult = findViewById(R.id.result);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tempA = Integer.parseInt(spinner1.getSelectedItem().toString());
               tempB = Integer.parseInt(spinner2.getSelectedItem().toString());
                textViewResult.setText(String.valueOf(tempA+tempB));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempA = Integer.parseInt(spinner1.getSelectedItem().toString());
                tempB = Integer.parseInt(spinner2.getSelectedItem().toString());
                textViewResult.setText(String.valueOf(tempA-tempB));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempA = Integer.parseInt((spinner1.getSelectedItem().toString()));
                tempB = Integer.parseInt(spinner2.getSelectedItem().toString());
                textViewResult.setText(String.valueOf(tempA*tempB));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempA = Double.parseDouble((spinner1.getSelectedItem().toString()));
                tempB = Double.parseDouble(spinner2.getSelectedItem().toString());
                textViewResult.setText(String.valueOf(tempA/tempB));
            }
        });

    }

}
