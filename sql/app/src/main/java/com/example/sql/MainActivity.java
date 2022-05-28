package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityDatabase database = new CityDatabase(MainActivity.this);
//        database.createCutyInDB(new City("Curitiba", 2000000));
//        database.createCutyInDB(new City("Rio de Janeiro", 1000000));
//        database.createCutyInDB(new City("Sao Paulo", 2000000));
        ArrayList<City> cities = database.getCitiesFromDB();
        for (City c: cities){
            c.print();
        }
//        cities.get(0).name = "NY";
//        database.updateCityInDB(cities.get(0));
//        database.removeCityInDB(cities.get(1));
    }
}