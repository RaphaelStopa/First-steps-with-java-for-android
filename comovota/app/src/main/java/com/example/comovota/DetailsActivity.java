package com.example.comovota;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comovota.domain.Political;

public class DetailsActivity extends AppCompatActivity {

    private TextView mTextView;

    private Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        String id = extras.getString("id");

        mTextView = (TextView) findViewById(R.id.text);

        try {
            Political political = data.politicalFilterById(id);

            mTextView.setText(political.getName() + "\n" +
                    political.getVotes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}