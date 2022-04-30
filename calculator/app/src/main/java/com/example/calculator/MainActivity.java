package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText numOne;
    EditText numTwo;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numOne = findViewById(R.id.editTextNumberDecimal);
        numTwo = findViewById(R.id.editTextNumberDecimal2);
        result = findViewById(R.id.editTextNumberDecimal3);
    }
    
    //validar campos e ajustar layout

    protected float getNumFromEditText(int id){
        String aux;
        if(id == 1){
            aux = numOne.getText().toString();
        } else {
            aux = numTwo.getText().toString();
        }
        return Float.parseFloat(aux);
    }

    public void plusButtonOnClick(View view){
        float num1 = getNumFromEditText(1);
        float num2 = getNumFromEditText(2);

        float value = num1 + num2;

        result.setText(String.valueOf(value));
    }
}