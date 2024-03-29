package com.example.agendaapp.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import com.example.agendaapp.R;
import com.example.agendaapp.model.Contact;
import com.example.agendaapp.model.DataModel;

public class DetailsActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText phoneEditText;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);

        Bundle extra = getIntent().getExtras();
        index = extra.getInt("index");
        if(index != -1){
            Contact c = DataModel.getInstance().getContacts(index);
            nameEditText.setText(c.getName());
            phoneEditText.setText(c.getPhone());
        }
    }

    @Override
    public void onBackPressed() {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        if(name.length() > 1 && phone.length() > 1){
            if(index == -1){
        DataModel.getInstance().addContact(
                new Contact(name, phone)

        );
            } else {
                Contact c = DataModel.getInstance().getContacts(index);
                c.setName(name);
                c.setPhone(phone);
                DataModel.getInstance().updateContact(c, index);
            }
        finish();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(DetailsActivity.this);
            builder.setTitle(R.string.attention);
            builder.setMessage(R.string.empty_contact_alet_msg);
            builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton(android.R.string.no,
                    null);
            builder.create().show();
        }
    }
}