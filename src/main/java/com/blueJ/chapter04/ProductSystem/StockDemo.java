package com.blueJ.chapter04.ProductSystem;

public class StockDemo{
    //The stock manager
    private StockManager manager;
    
    /**
     * Constructor of the class StockDemo
     * creates a new Stock Manager and 
     * adds some sample items to it.
     */
    public StockDemo(){
        manager = new StockManager();
        manager.addProduct(new Product(1, "Hat"));
        manager.addProduct(new Product(2, "Ball"));
        manager.addProduct(new Product(3, "Toy"));
    }

    /**
     * Provide a simple demonstration of how a Stock Manager
     * might be used. Details of one product are shown,
     * the product is restocked, and then the details are shown again.
     */
    public void demo(){
        //Show details of all of the products
        manager.printProductDetails();
        //Take delivery of 5 items of one of the products
        //manager.delivery(2, 5);
        manager.printProductDetails();
    }

    /**
     * Show details of given product. If found,
     * its name and stock will be shown.
     * @param id The ID of the product.
     */
    public void showDetails(int id){
        Product product = getProduct(id);
        if(product != null){
            System.out.println(product.toString());
        }
    }

    /**
     * Sell one of the given item.
     * Show before and after of the status.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id){
        Product product = getProduct(id);
        if(product != null){
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }

    /**
     * Get product with given id.
     * Error message if no match.
     * @param id The id of the product.
     * @return The product, or null if no matching.
     */
    public Product getProduct(int id){
        Product product = manager.findProduct(id);
        if(product == null){
            System.out.println("Product with ID: " + id + " is not recognized!");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager(){
        return manager;
    }
}