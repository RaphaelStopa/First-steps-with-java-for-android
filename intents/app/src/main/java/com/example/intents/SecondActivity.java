package com.example.intents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        String nome = extras.getString("nome");
        setTitle("Second Activity: " + nome);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data", "Second Info");
        setResult(RESULT_OK, intent);
        finish();
    }
}