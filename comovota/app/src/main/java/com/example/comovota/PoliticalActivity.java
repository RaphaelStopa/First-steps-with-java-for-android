package com.example.comovota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comovota.domain.Political;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class PoliticalActivity extends AppCompatActivity {

    //Usei o list view mesmo pq eh algo simples, que poucas vezes vai mudar.
    ListView listView;

    SearchView searchView;

    private Data data = new Data();

    ArrayAdapter<Political> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_political);

        Bundle extras = getIntent().getExtras();

        String type = extras.getString("political");

        searchView = findViewById(R.id.searchView);

        filterList(null, type);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                filterList(s, type);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                filterList(s, type);

                return false;
            }
        });
    }

    public void filterList(String filter, String type){

        ArrayList<Political> politicalArrayList = data.politicalFilterByType(type);
        listView = findViewById(R.id.listView);

        if(filter == null){

            listView = findViewById(R.id.listView);

            adapter = new ArrayAdapter<Political>(
                    PoliticalActivity.this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    politicalArrayList
            );

        } else {
            adapter = new ArrayAdapter<Political>(
                    PoliticalActivity.this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    politicalArrayList.stream()
                            .filter(x -> x.getName().toLowerCase().contains(filter.toLowerCase()))
                            .collect(Collectors.toCollection(ArrayList::new))

            );
        }
        
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