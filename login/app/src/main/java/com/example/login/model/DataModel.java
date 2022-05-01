package com.example.login.model;

public class DataModel {
    private static DataModel instance = new DataModel();

    private DataModel(){

    }
    public static DataModel getInstance(){
        return instance;
    }
    public UserDetails userDetails = new UserDetails("stopa", "1234");
}
