package com.example.recyclerview;

import java.util.ArrayList;

public class DataModel {
    private  static DataModel instance = new DataModel();

    private DataModel(){
        products.add(new Product("Banana", 1));
        products.add(new Product("Maca", 1));
        products.add(new Product("Alface", 1));
        products.add(new Product("Pao", 10));
        products.add(new Product("Nescau", 18));
        products.add(new Product("Carne", 20));
        products.add(new Product("Iorgute", 10));
        products.add(new Product("Frango", 10));

    }

    public static DataModel getInstance(){
        return  instance;
    }

    public ArrayList<Product> products = new ArrayList<>();
}
