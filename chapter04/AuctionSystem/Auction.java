package com.blueJ.chapter04.AuctionSystem;
import java.util.ArrayList;

public class Auction{
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    public Auction(){
        nextLotNumber = 1;
        lots = new ArrayList<>();
    }

    public void enterLot(String description){
        lots.add(new Lot(description, nextLotNumber));
        nextLotNumber++;
    }

    public void showLots(){
        for(Lot lot : lots){
            System.out.println(lot.toString());
        }
    }
    
    /*public Lot getLot(int lotNumber){
        
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)){
            Lot selectedLot = lots.get(lotNumber - 1);
            //Confidence check to be sure we have the right lot
            if(selectedLot.getNumber() != lotNumber){
                System.out.println("Invalid number!");
                selectedLot = null;
            }
            return selectedLot;
        }
        else{
            System.out.println("Lot number: " + lotNumber + " does not exist!");
            return null;
        }
    }*/

    public Lot getLot(int lotNumber){
        Lot tempLot = null;
        for(Lot lot : lots){
            if(lotNumber == lot.getNumber()){
                tempLot = lot;
            }
        }
        return tempLot;
    }

    public void makeABid(int lotNumber, Person bidder, long value){
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null){
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful){
                System.out.println("The new Bid for the Lot: " + selectedLot.getDescription() + ", has been added!");
            }
            else{
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("The Lot: " + selectedLot.getDescription() + " has already a Bid of: " + highestBid.getValue());
            }
        }
    }

    public void close(){
        for(Lot lot : lots){
            System.out.println(lot.getNumber() + ": " + lot.getDescription());
            Bid bid = lot.getHighestBid();
            if(bid != null){
                System.out.println("Bidder: " + bid.getBidder().getName() + ", Amount bidden: " + bid.getValue());
            }
            else{
                System.out.println("No bids placed on this lot!");
            }
        }
    }

    public ArrayList<Lot> getUnsold(){
        ArrayList<Lot> unsoldLots = new ArrayList<>();
        for(Lot lot : lots){
            if(lot.getHighestBid() == null){
                unsoldLots.add(lot);
            }
        }
        return unsoldLots;
    }

    /**
     * Delete Lot with the given Number
     * @param number the number of the Lot, which should be removed
     * @return the Lot with the given number, or null if
     * a such Lot does not exist 
     */
    public Lot deleteLot(int number){
        Lot lot = getLot(number);
        if(lot != null){
            lots.remove(lot);
            System.out.println("Lot on number: " + number + " removed!");
        }
        else{
            System.out.println("There is already no Lot on the number: " + number);
        }
        return lot;
    }
}