package com.example.firststepswithjavaforandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView titleTextMain;
    EditText counterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "onCreate");
        titleTextMain = findViewById(R.id.titleTextMain);
        titleTextMain.setText("Java Java Java");
        counterEditText = findViewById(R.id.counterEditText);
        counterEditText.setText("0");
    }

    public void lessOneButtonOnClick(View view){
        String aux = counterEditText.getText().toString();
        int num = Integer.parseInt(aux);
        num--;
        counterEditText.setText(String.valueOf(num));
        Toast.makeText(MainActivity.this,
                "remove!",
                Toast.LENGTH_LONG
        ).show();
    }

    // Componentes visuais sempre recebem uma view
    public void plusOneButtonOnClick(View view){
        String aux = counterEditText.getText().toString();
        int num = Integer.parseInt(aux);
        num++;
        counterEditText.setText(String.valueOf(num));
        Toast.makeText(MainActivity.this,
                "add!",
                Toast.LENGTH_LONG
        ).show();

    }

//    torna a atividade visível ao usuário, à medida que o aplicativo prepara a atividade
//    para inserir o primeiro plano e se tornar interativa
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Lifecycle", "onStart");
    }

//    Quando terminou carregou tela. Logo depois do OnStart
    @Override
    protected void onResume() {
        super.onResume();
        Log.w("LifeCucle", "onResume");
    }

//    Quando foi interrompida a interracao
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle", "onPause");
    }

//    Quando esta em background
    @Override
    protected void onStop() {
        super.onStop();
        Log.wtf("LofeCycle", "onStop");
    }

//    Quando de fato ela eh encerrada
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("LifeCycle", "onDestroy");
    }
}