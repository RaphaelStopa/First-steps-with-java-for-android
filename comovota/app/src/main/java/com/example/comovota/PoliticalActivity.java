package com.example.comovota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comovota.domain.Political;

import java.util.ArrayList;



public class PoliticalActivity extends AppCompatActivity {

    //Usei o list view mesmo pq eh algo simples, que poucas vezes vai mudar.
    ListView listView;

    private Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_political);

        Bundle extras = getIntent().getExtras();

        String type = extras.getString("political");

        ArrayList<Political> politicalArrayList = data.politicalFilterByType(type);

        listView = findViewById(R.id.listView);
        ArrayAdapter<Political> adapter = new ArrayAdapter<Political>(
                PoliticalActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                politicalArrayList

        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Political political = politicalArrayList.get(i);
                Intent intent = new Intent(PoliticalActivity.this, DetailsActivity.class);
                intent.putExtra("id", political.getId().toString());
                startActivity(intent);
            }
        });
    }
}