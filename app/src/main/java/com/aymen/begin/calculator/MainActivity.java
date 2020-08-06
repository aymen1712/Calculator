package com.aymen.begin.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMult;
    private Button btnDiv;
    private Button btnResult;
    private Button btnDot;
    private Button btnPower;
    private Button btnInverse;
    private Button btnChangeSign;
    private Button btnClear;
    private Button btnCosinus;
    private Button btnSinus;
    private Button btnTangente;
    private Button btnCotangente;
    private TextView txtCalc, txtCalc1;

    private double num1;
    private double num2;
    private double result;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextCalc("9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtCalc.getText().toString().contains(".")){
                    setTextCalc(".");
                }
                else {
                    setTextCalc("");
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCalc.setText("");
            }
        });
        btnChangeSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = Double.parseDouble(txtCalc.getText().toString());
                num = num * (-1);
                txtCalc.setText(String.valueOf(num));
            }
        });
        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = Double.parseDouble(txtCalc.getText().toString());
                double numPow = Math.pow(num, 2);
                txtCalc.setText(String.valueOf(numPow));

            }
        });
        btnInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = Double.parseDouble(txtCalc.getText().toString());
                double numInv = Math.pow(num, -1);
                txtCalc.setText(String.valueOf(numInv));
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperand('+');
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperand('-');
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperand('*');
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperand('/');
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = Double.parseDouble(txtCalc.getText().toString());
                calculate();
                txtCalc1.setText(String.valueOf(num1) + " " + operator + " " + String.valueOf(num2) + " = " );
                String str = String.valueOf(result);
                txtCalc.setText(str);
            }
        });
        btnCosinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCalc.getText().toString().equals("")){
                    txtCalc.setText("");
                }
                else {
                    double num = Double.parseDouble(txtCalc.getText().toString());
                    double numRadian = Math.toRadians(num);
                    double numCos = Math.cos(numRadian);
                    txtCalc.setText(String.valueOf(numCos));
                }
            }
        });
        btnSinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCalc.getText().toString().equals("")){
                    txtCalc.setText("");
                }
                else {
                    double num = Double.parseDouble(txtCalc.getText().toString());
                    double numRadian = Math.toRadians(num);
                    double numSin = Math.sin(numRadian);
                    txtCalc.setText(String.valueOf(numSin));
                }
            }
        });
        btnTangente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCalc.getText().toString().equals("")){
                    txtCalc.setText("");
                }
                else {
                    double num = Double.parseDouble(txtCalc.getText().toString());
                    double numRadian = Math.toRadians(num);
                    double numTg = Math.tan(numRadian);
                    txtCalc.setText(String.valueOf(numTg));
                }
            }
        });
        btnCotangente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCalc.getText().toString().equals("")){
                    txtCalc.setText("");
                }
                else {
                    double num = Double.parseDouble(txtCalc.getText().toString());
                    double numRadian = Math.toRadians(num);
                    double numCotg = Math.pow(Math.tan(numRadian), -1);
                    txtCalc.setText(String.valueOf(numCotg));
                }
            }
        });

    }

    private void calculate() {
        switch (operator){
            case ('+'): {
                result = num1 + num2;
                break;
            }
            case ('-'): {
                result = num1 - num2;
                break;
            }
            case ('*'): {
                result = num1 * num2;
                break;
            }
            case ('/'): {
                result = num1 * Math.pow(num2, -1);
                break;
            }
        }
    }

    private void setTextCalc(String s){
        String strCalc = txtCalc.getText() + s;
        txtCalc.setText(strCalc);
    }

    private void setOperand(char op){
        num1 = Double.parseDouble(txtCalc.getText().toString());
        txtCalc.setText("");
        operator = op;
    }

    private void setUI() {
        btnZero = findViewById(R.id.btn0);
        btnOne = findViewById(R.id.btn1);
        btnTwo = findViewById(R.id.btn2);
        btnThree = findViewById(R.id.btn3);
        btnFour = findViewById(R.id.btn4);
        btnFive = findViewById(R.id.btn5);
        btnSix = findViewById(R.id.btn6);
        btnSeven = findViewById(R.id.btn7);
        btnEight = findViewById(R.id.btn8);
        btnNine = findViewById(R.id.btn9);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnResult = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);
        btnPower = findViewById(R.id.btnPow);
        btnInverse = findViewById(R.id.btnInv);
        btnChangeSign = findViewById(R.id.btnPN);
        btnClear = findViewById(R.id.btnClear);
        btnCosinus = findViewById(R.id.btnCos);
        btnSinus = findViewById(R.id.btnSin);
        btnTangente = findViewById(R.id.btnTg);
        btnCotangente = findViewById(R.id.btnCotg);
        txtCalc = findViewById(R.id.txtCalc);
        txtCalc1 = findViewById(R.id.txtCalc1);
    }
}
