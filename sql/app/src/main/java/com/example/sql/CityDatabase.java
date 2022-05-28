package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CityDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "cities.sqlite";
    private static final int DB_VERSION = 1;
    private Context context;
    private static String DB_TABLE = "City";
    private static String COL_ID = "id";
    private static String COL_NAME = "name";
    private static String COL_POPULATION = "population";

    public CityDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create Table if not exists " + DB_TABLE + "( " +
                COL_ID + " Integer primary key autoincrement, " +
                COL_NAME + " TEXT, " +
                COL_POPULATION + " INTEGER)" ;
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long createCutyInDB(City c){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, c.name);
        values.put(COL_POPULATION, "" +c.population);
        long id = database.insert(DB_TABLE, null, values);
        database.close();
        return id;
    }

    public ArrayList<City> getCitiesFromDB(){
        ArrayList<City> cities = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(DB_TABLE, null, null, null,
        null, null, null);

        if(cursor.moveToFirst()){
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(COL_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME));
                int population = cursor.getInt(cursor.getColumnIndexOrThrow(COL_POPULATION));
                cities.add(
                        new City(id, name, population)
                );
            }while (cursor.moveToFirst());
        }
        database.close();

        return cities;
    }

    public int updateCityInDB(City c) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, c.name);
        values.put(COL_POPULATION, c.population);
        String id = String.valueOf(c.id);
        int count = database.update(DB_TABLE, values, COL_ID + "=?", new String[]{id});
        database.close();
        return count;
    }

    public int removeCityInDB(City c) {
        SQLiteDatabase database = getWritableDatabase();
        String id = String.valueOf(c.id);
        int count = database.delete(DB_TABLE, COL_ID + "=?", new String[]{id});
        database.close();
        return count;
    }
}
