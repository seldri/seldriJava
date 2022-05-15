package com.blueJ.chapter04.ProductSystem;

import java.util.ArrayList;

public class StockManager{
    //A List of the products
    private ArrayList<Product> stock;

    /**
     * The constructor of the stockmanager class
     */
    public StockManager(){
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item){
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public delivery(int id, int amount){
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null 
     * if there is none with a matching ID.
     */
    public Product findProduct(int id){
        return null;
    }

    /**
     * Locate a product with the given ID,
     * and return how many of this item are in stock.
     * If the ID does not match any product,
     * return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id){
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails(){
        for(Product product : stock){
            System.out.println(product.toString());
        }
    }
}