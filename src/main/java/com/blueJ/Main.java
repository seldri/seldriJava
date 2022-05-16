package com.blueJ;

import com.blueJ.chapter04.ProductSystem.*;
    
public class Main {

    public static void main(String[] args) {

        StockManager sm1 = new StockManager();

        sm1.addProduct(new Product(1, "Shoe"));
        sm1.addProduct(new Product(2, "Hat"));
        sm1.addProduct(new Product(3, "Jacket"));
        
        //System.out.println(sm1.findProduct(2));

        sm1.delivery(1, 2);
        sm1.delivery(2, 5);
        sm1.delivery(3, 6);

        sm1.addProduct(new Product(1, "Bob"));
        //sm1.printProductDetails();

        System.out.println(sm1.findProductName("Hat"));
    }
} 