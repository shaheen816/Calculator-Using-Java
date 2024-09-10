package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
        Button btnAc; Button btnDel;Button btnDevision;Button btnMul;
        Button btnPlus; Button btnEquel; Button btnMinus;Button btn7;
        Button btn8;Button btn9; Button btn4; Button btn5;
        Button btn6; Button btn1;Button btn2; Button btn3; Button btn0;
        Button btnDot;
        TextView textViewResult;
        TextView textViewHistory;
        String number=null;
        double firstNumber=0;
        double lastNumber=0;
        String status=null;
        boolean operator=false;
        DecimalFormat myFormatter=new DecimalFormat("######.#######");
        String history,currentResult;
        boolean dot=true;
        boolean btnAcControll=true;
        boolean btnEquelControll=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViewResult=findViewById(R.id.textViewResult);
        textViewHistory=findViewById(R.id.textViewHistory);
        btnAc=findViewById(R.id.btnAc);
        btnEquel=findViewById(R.id.btnEquel);
        btnDel=findViewById(R.id.btnDel);
        btnDevision=findViewById(R.id.btnDevision);
        btnMul=findViewById(R.id.btnMul);
        btnPlus=findViewById(R.id.btnPlus);
        btnMinus=findViewById(R.id.btnMinus);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn3=findViewById(R.id.btn3);
        btn2=findViewById(R.id.btn2);
        btn1=findViewById(R.id.btn1);
        btn0=findViewById(R.id.btn0);
        btnDot=findViewById(R.id.btnDot);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=null;
                status=null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber=0;
                lastNumber=0;
                dot=true;
                btnAcControll=true;
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAcControll){
                    textViewResult.setText("0");
                }else {
                    number=number.substring(0,number.length()-1);
                    if (number.length()==0){
                        btnDel.setClickable(false);
                    } else if (number.contains(".")) {
                        dot=false;
                    }else {
                        dot=true;
                    }
                    textViewResult.setText(number);
                }

            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dot){
                    if (number==null){
                        number="0.";
                    }else {
                        number=number+".";
                    }
                }

                textViewResult.setText(number);
                dot=false;

            }
        });
        btnEquel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator){
                    if (status=="sum"){
                        plus();
                    } else if (status=="subtraction") {
                        minus();
                    } else if (status=="multiplaction") {
                        multiply();
                    }else if (status=="division"){
                        divide();
                    }else {
                        firstNumber=Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator=false;
                btnEquelControll=true;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");
            if (operator){
                if (status=="multiplacition"){
                    multiply();
                } else if (status=="division") {
                    divide();
                } else if (status=="subtraction") {
                    minus();
                    
                }else {
                    plus();
                }

            }
            status="sum";
            operator=false;
            number=null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");
                if (operator){
                    if (status=="multiplacition"){
                        multiply();
                    } else if (status=="division") {
                        divide();
                    } else if (status == "sum") {
                        plus();
                    }else {
                        minus();
                    }
                }
                status="subtraction";
                operator=false;
                number=null;
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");
            if (operator){
                if (status=="sum"){
                    plus();
                } else if (status == "division") {
                    divide();
                } else if (status == "subtraction") {
                    minus();
                }else {
                    multiply();
                }
            }
            status="multiplacition";
            operator=false;
            number=null;
            }
        });
        btnDevision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");
                if (operator){
                    if (status=="multiplacition"){
                        multiply();
                    }else if (status=="sum"){
                        plus();
                    } else if (status=="subtraction") {
                        minus();
                    }else {
                        divide();
                    }
                }
                status="division";
                operator=false;
                number=null;
            }
        });

    }
    public void numberClick(String view){

        if (number==null){
            number=view;
        } else if (btnEquelControll) {
            firstNumber=0;
            lastNumber=0;
            number=view;

        } else {
            number=number+view;
        }
        textViewResult.setText(number);
        operator=true;
        btnAcControll=false;
        btnDel.setClickable(true);
        btnEquelControll=false;
    }
    public void plus(){
        lastNumber=Double.parseDouble(textViewResult.getText().toString());
        firstNumber=firstNumber+lastNumber;

        textViewResult.setText(myFormatter.format(firstNumber));
        dot=true;
    }
    public void minus(){
        if (firstNumber==0){
            firstNumber=Double.parseDouble(textViewResult.getText().toString());
        }else {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber-lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
        dot=true;
    }
    public  void multiply(){
        if (firstNumber==0){
            firstNumber=1;
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber*lastNumber;
        }else {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber*lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
        dot=true;
    }
    public void divide(){
        if (firstNumber==0){
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=lastNumber/1;
        }
        else {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber/lastNumber;

        }
        textViewResult.setText(myFormatter.format(firstNumber));
        dot=true;
    }
}