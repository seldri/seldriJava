package com.blueJ;

import com.blueJ.chapter04.ProductSystem.*;
    
public class Main {

    public static void main(String[] args) {

        StockManager sm1 = new StockManager();
        Product p1 = new Product(1, "Hat");
        Product p2 = new Product(2, "Shoe");
        Product p3 = new Product(1, "Knot");
        sm1.addProduct(p1);
        sm1.addProduct(p2);
        sm1.addProduct(p3);
        sm1.printProductDetails();
    }
} 