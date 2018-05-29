package com.example.ahmadaidin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String operator;
    Float operand1;
    Float operand2;
    boolean forClear;

    Button[] numButtons;
    Button plus, minus, multiply, divide, comma, equal;
    TextView screen;

    boolean isUseComma = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numButtons = new Button[10];
        numButtons[0] = findViewById(R.id.zero);
        numButtons[1] = findViewById(R.id.one);
        numButtons[2] = findViewById(R.id.two);
        numButtons[3] = findViewById(R.id.three);
        numButtons[4] = findViewById(R.id.four);
        numButtons[5] = findViewById(R.id.five);
        numButtons[6] = findViewById(R.id.six);
        numButtons[7] = findViewById(R.id.seven);
        numButtons[8] = findViewById(R.id.eight);
        numButtons[9] = findViewById(R.id.nine);
        comma = findViewById(R.id.comma);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        screen = findViewById(R.id.screen);
        equal = findViewById(R.id.equal);
        forClear = false;
        operand1 = new Float(0);
        operand2 = new Float(0);

        for(int i =0; i<numButtons.length; i++){
            final int idx = i;
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!forClear) {
                        screen.append(""+idx);
                    } else {
                        screen.setText(""+idx);
                        forClear = false;
                    }
                }
            });
        }

        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isUseComma && !screen.getText().toString().isEmpty()){
                    screen.append(".");
                    isUseComma = true;
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operandStr = screen.getText().toString();
                if(!operandStr.isEmpty()) {
                    operand1 = Float.parseFloat(operandStr);
                    operator = "+";
                    isUseComma = false;
                    screen.setText("");
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operandStr = screen.getText().toString();
                if(operandStr.isEmpty()){
                    screen.append("-");
                    forClear = false;
                } else {
                    operand1 = Float.parseFloat(operandStr);
                    operator = "-";
                    isUseComma = false;
                    screen.setText("");
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operandStr = screen.getText().toString();
                if(!operandStr.isEmpty()) {
                    operand1 = Float.parseFloat(operandStr);
                    operator = ":";
                    isUseComma = false;
                    screen.setText("");
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operandStr = screen.getText().toString();
                if(!operandStr.isEmpty()) {
                    operand1 = Float.parseFloat(operandStr);
                    operator = "x";
                    isUseComma = false;
                    screen.setText("");
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operandStr = screen.getText().toString();
                float result=0;
                if(!operandStr.isEmpty()){
                    operand2 = Float.parseFloat(operandStr);
                    result=operand2;
                }
                if(operator!=null) {
                    switch (operator) {
                        case "+": {
                            result = operand1 + operand2;
                            break;
                        }
                        case "-": {
                            result = operand1 - operand2;
                            break;
                        }
                        case "x": {
                            result = operand1 * operand2;
                            break;
                        }
                        case ":": {
                            result = operand1 / operand2;
                            break;
                        }
                    }
                    Log.d("hasil",result+"");
                    screen.setText(result+"");
                    operator="";
                }
                operand1 = new Float(0);
                forClear = true;
            }
        });
    }


}
