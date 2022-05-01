package com.example.intents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        String aux = data.getStringExtra("data");
                        setTitle("MainActivity: " + aux);
                    }
                }
            }
    );

    // importante, para evitar erro tem que tirar no manifest o user-libery e meta data
    public void goToSecondActivityButtonOnClick(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("nome", "value");
//        startActivity(intent);
        activityResultLauncher.launch(intent);
    }
}