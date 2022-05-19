package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView resp = findViewById(R.id.resp);
        final EditText weight = findViewById(R.id.weight);
        final EditText height = findViewById(R.id.height);
        Button btnClear = findViewById(R.id.clearBtn);
        Button btnCalc = findViewById(R.id.calcBtn);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                resp.setText("");
                weight.setText("");
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heightValue = height.getText().toString();
                String weightValue = weight.getText().toString();

                if(!heightValue.contains(".")){
                    StringBuilder stringBuilder = new StringBuilder(heightValue);
                    heightValue = stringBuilder.insert(heightValue.length() - 2, '.').toString();
                }

                try{
                    double imc = calcIMC(Double.parseDouble(weightValue), Double.parseDouble(heightValue));
                    imcToResp(imc, resp);
                }
                catch (Exception e) {
                    Log.d("Erro: ", e.toString());
                    resp.setText(getText(R.string.err));
                }

                hideKeyBoardInactive();
            }
        });
    }


    private double calcIMC(double weight, double height){
        double resp = weight / (height * height);
        return resp;
    }


    private void imcToResp(double calc,TextView textView){
        DecimalFormat df = new DecimalFormat("#.00");
        String resp = "IMC: "+ df.format(calc)+"\n";

        if(calc <= 0){
            resp += getText(R.string.err);
            textView.setTextColor(getResources().getColor(R.color.color1));
        }
        else if(calc > 0 && calc < 17 ){
            resp += getText(R.string.respOne);
            textView.setTextColor(getResources().getColor(R.color.color1));
        }
        else if(calc >= 17 && calc < 18.5){
            resp += getText(R.string.respTwo);
            textView.setTextColor(getResources().getColor(R.color.color2));
        }
        else if(calc >= 18.5 && calc < 25){
            resp += getText(R.string.respTree);
            textView.setTextColor(getResources().getColor(R.color.color3));
        }
        else if(calc >= 25 && calc < 30){
            resp += getText(R.string.respFour);
            textView.setTextColor(getResources().getColor(R.color.color4));
        }
        else if(calc >= 30 && calc < 35){
            resp+= getText(R.string.respFive);
            textView.setTextColor(getResources().getColor(R.color.color5));
        }
        else if(calc >= 35 && calc < 40){
            resp +=getText(R.string.respSix);
            textView.setTextColor(getResources().getColor(R.color.color6));
        }
        else {
            resp += getText(R.string.respSeven);
            textView.setTextColor(getResources().getColor(R.color.color7));
        }
        textView.setText(resp);
    }

    public void hideKeyBoardInactive() {

        View view = this.getCurrentFocus();

        if(view!= null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}