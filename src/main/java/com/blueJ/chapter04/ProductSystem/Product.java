package com.blueJ.chapter04.ProductSystem;

public class Product{
    //identifying number for this product
    private int id;
    //the name of this product
    private String name;
    //The quantity of this product in stock
    private int quantity;

    /**
     * Constructor of the Class Product.
     * THe initial stock quantity is zero.
     * @param id The products identifying number.
     * @param name The Products name.
     */
    public Product(int id, String name){
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The products id. 
    */
    public int getID(){
        return id;
    }

    /**
     * @return The products name.
    */
    public String getName(){
        return name;
    }

    /**
     * @return The quantity in stock.
    */
    public int getQuantity(){
        return quantity;
    }

    /**
     * @return the id, name and quantity in stock. 
    */
    public String toString(){
        return id + ": " + name + " / Stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     * This must be greater than zero.
     */
    public void increaseQuantity(int amount){
        if(amount > 0){
            quantity += amount;
        }
        else{
            System.out.println("Amount must be over 0!");
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sellOne(){
        if(quantity > 0){
            quantity--;
        }
        else{
            System.out.println("Attempt to sell an out of stock item: " + name);
        }
    }
}