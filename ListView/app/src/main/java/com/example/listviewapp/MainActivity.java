package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> itens = new ArrayList<>();
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        loadItensFromFile();
        updateListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String aux = itens.get(i);
                aux = aux +" clicked";
                itens.set(i, aux);
                updateListView();
                listView.requestFocusFromTouch();
                listView.setSelection(i);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                itens.remove(i);
                updateListView();
                if(i > 1){
                    listView.requestFocusFromTouch();
                    listView.setSelection(i - 1);
                }

                return true;
            }
        });
    }

    public void addButtonClick(View v){
        counter++;
        itens.add("Item" + counter);
        updateListView();
    }

    void updateListView(){
        //        tranforma o array em componente
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );
        listView.setAdapter(adapter);
        saveItensToFile();

    }

    void loadItensFromFile(){
        try {
            InputStream stream = this.openFileInput("Lista.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                itens.add(line);
            }
            reader.close();
            streamReader.close();
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void saveItensToFile(){
        try {
            OutputStream stream = MainActivity.this.openFileOutput(
                    "lista.txt",
                    MODE_PRIVATE
            );
            OutputStreamWriter write = new OutputStreamWriter(stream);
            for (String s: itens){
                write.write(s + "\n");

            }
            write.flush();
            write.close();
            stream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}