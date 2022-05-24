package com.example.comovota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.comovota.domain.Political;
import com.example.comovota.domain.PoliticalParty;
import com.example.comovota.domain.Project;
import com.example.comovota.domain.Vote;
import com.example.comovota.domain.enumeration.ElectivePositionType;
import com.example.comovota.domain.enumeration.TypeOfVote;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSenatorOnClick (View v) {
      Intent intent = new Intent(MainActivity.this, PoliticalActivity.class);
      intent.putExtra("political", "SENADOR");
      startActivity(intent);
  }


  public void goToDeputyOnClick (View v) {
        Intent intent = new Intent(MainActivity.this, PoliticalActivity.class);
    intent.putExtra("political", "DEPUTADO_FEDERAL");
    startActivity(intent);
  }
}