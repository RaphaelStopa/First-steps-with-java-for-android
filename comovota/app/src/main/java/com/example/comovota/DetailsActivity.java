package com.example.comovota;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comovota.domain.Political;
import com.example.comovota.domain.Vote;

import java.util.List;
import java.util.stream.Collectors;

public class DetailsActivity extends AppCompatActivity {

    private TextView mTextView;

    private Data data = new Data();


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        String id = extras.getString("id");

        mTextView = (TextView) findViewById(R.id.text);

        Political political = null;
        try {
            political = data.politicalFilterById(id);
            mTextView.setText(political.getName() + "\n" + "\n" + political.getPoliticalParty() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            mTextView.setText("Erro");
        }

        listView = findViewById(R.id.listView);
        ArrayAdapter<Vote> adapter = new ArrayAdapter<Vote>(
                DetailsActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                political.getVotes().stream().collect(Collectors.toList())

        );

        listView.setAdapter(adapter);
    }
}