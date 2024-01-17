package com.example.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        EditText num1 = findViewById(R.id.input1);
        EditText num2 = findViewById(R.id.input2);
        TextView result2 = findViewById(R.id.result2);
        RadioGroup operations = findViewById(R.id.operations);
        RadioButton operation = findViewById(operations.getCheckedRadioButtonId());

        Double numDouble1 = 0.0;
        Double numDouble2 = 0.0;
        Double numDoubleResult = 0.0;
        String choice = null;
        boolean determine = false;
        try{
            numDouble1 = Double.parseDouble(num1.getText().toString());
            numDouble2 = Double.parseDouble(num2.getText().toString());
            choice = operation.getText().toString();
            determine = true;
        }catch(NullPointerException e) {
            result2.setText("請選擇運算元");
        }catch(NumberFormatException e){
            result2.setText("請輸入正確數字");
        }
        if(determine){
            switch(choice){
                case "+":
                    numDoubleResult = numDouble1 + numDouble2;
                    break;
                case "-":
                    numDoubleResult = numDouble1 - numDouble2;
                    break;
                case "×":
                    numDoubleResult = numDouble1 * numDouble2;
                    break;
                case "÷":
                    if(numDouble2 != 0)
                        numDoubleResult = numDouble1 / numDouble2;
                    else
                        result2.setText("不能除以0啊");
                    break;
            }
            if(!Double.isNaN(numDoubleResult) && !(choice.equals("÷") && numDouble2 == 0.0)){
                if(numDoubleResult % 1 == 0){
                    int numResult = (int)Math.round(numDoubleResult);
                    result2.setText(String.valueOf(numResult));
                }
                else
                    result2.setText(String.valueOf(numDoubleResult));
            }
        }
    }
}