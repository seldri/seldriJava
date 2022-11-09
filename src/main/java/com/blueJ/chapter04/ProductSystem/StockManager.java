package com.blueJ.chapter04.ProductSystem;

import java.util.ArrayList;

public class StockManager{
    //A List of the products
    private ArrayList<Product> stock;

    /**
     * The constructor of the StockManager class
     */
    public StockManager(){
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product newProduct){
        boolean taken = false;
        for(Product product : stock){
            if(product.getID() == newProduct.getID()){
                System.out.println("ID already taken!");
                taken = true;
            }
        }
        if(!taken){
            stock.add(newProduct);
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount){
        Product product = findProduct(id);
        if(product != null){
            product.increaseQuantity(amount);
        }
        else {
            System.out.println("No such Product ID!");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null 
     * if there is none with a matching ID.
     */
    public Product findProduct(int id){
        for(Product product : stock){
            if(product.getID() == id){
                return product;
            }
        }
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
        Product product = findProduct(id);
        if(product == null){
            return 0;
        }
        else {
            return product.getQuantity();
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails(){
        for(Product product : stock){
            System.out.println(product.toString());
        }
    }

    public void printProductDetails2(){
        for(Product product : stock){
            System.out.println("ID: " + product.getID() + " / NAME: " + product.getName());
        }
    }

    public void checkStock(int level){
        for(Product product : stock){
            if(product.getQuantity() <= level){
                System.out.println(product.toString());
            }
        }
    }
    
    public Product findProductName(String name){
        for(Product product : stock){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
}