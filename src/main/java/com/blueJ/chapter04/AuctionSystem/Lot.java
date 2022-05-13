package com.blueJ.chapter04.AuctionSystem;


public class Lot{
    //The highest Bid placed on the lot
    private Bid highestBid;
    //The number of the Lot
    private final int number;
    //The description of the item in the Lot
    private final String description;

    
    public Lot(String description, int number){
        this.description = description;
        this.number = number;
        highestBid = null;
    }

    public String getDescription(){
        return description;
    }

    public Bid getHighestBid(){
        return highestBid;
        }

    public int getNumber(){
        return number;
    }

    public boolean bidFor(Bid bid){
        //There exists no previous Bid this is the first
        if(highestBid == null){
            highestBid = bid;
            return true;
        }
        //The new Bid is better than the old one
        else if(bid.getValue() > highestBid.getValue()){
            highestBid = bid;
            return true;
        }
        //The new Bid is not better than the old one
        else {
            return false;
        }
    }

    /*public void placeNewBid(Bid newBid){
        if(getHighestBid() == null){
            highestBid = newBid;
        }
        else{
            if(highestBid.getValue() > newBid.getValue()){
                System.out.println("The new Bid must be higher than the current bid of: " + highestBid.getValue());
            }
            else {  highestBid = newBid;
                    System.out.println("New Bid: " + highestBid.getValue() + " added.");
            }
        }
    }*/

    public String toString(){
        String details = number + ": " + description;
        if(highestBid != null){
            details += "    Bid: " + highestBid.getValue();
        }
        else{
            details += "    (No Bid)";
        }
        return details;
    }
}