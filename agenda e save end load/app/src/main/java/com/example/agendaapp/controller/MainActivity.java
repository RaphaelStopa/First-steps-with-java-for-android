package com.example.agendaapp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.agendaapp.R;
import com.example.agendaapp.model.Contact;
import com.example.agendaapp.model.DataModel;
import com.google.android.material.snackbar.Snackbar;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ContactAdapter adapter = new ContactAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this)
        );

        recyclerView.addItemDecoration(new DividerItemDecoration(
                MainActivity.this, DividerItemDecoration.VERTICAL));

        adapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goToDetailActivity(position);
            }
        });


        adapter.setOnItemLongClickListener(new ContactAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int position) {
                Contact c = DataModel.getInstance().contacts.remove(position);
                adapter.notifyItemRemoved(position);
                DataModel.getInstance().saveToFile(MainActivity.this);
                View contextView = findViewById(android.R.id.content);
                Snackbar.make(contextView,R.string.remove_contact, Snackbar.LENGTH_LONG).setAction(R.string.undo, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataModel.getInstance().contacts.add(position, c);
                        adapter.notifyItemInserted(position);
                    }
                }).show();
                return true;
            }
        });

        DataModel.getInstance().loadFromFile(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

//    void updateListView(){
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                MainActivity.this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                DataModel.getInstance().getStringContacts()
//        );
//        listView.setAdapter(adapter);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    void goToDetailActivity(int index){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_add_contact){
//            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//            startActivity(intent);
            goToDetailActivity(-1);
        }

        return super.onOptionsItemSelected(item);
    }
}