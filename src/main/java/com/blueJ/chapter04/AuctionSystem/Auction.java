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
    
    public Lot getLot(int lotNumber){
        
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
    }
    
    /*public void makeABid(int lotNumber, long value, Person bidder){
        if(lotNumber >= 0 && lotNumber < lots.size()){
            if(lots.get(lotNumber).bidFor(new Bid(bidder, value)) == true){
                System.out.println("The new Bid was successful!");
            }
            else{
                System.out.println("The Bid must be bigger than the current Bid of: " + lots.get(lotNumber).getHighestBid());
            }
        }
        else{
            System.out.println("The position of the lot must be in between: 0 and " + (lots.size() - 1));
        }
    }*/

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

}
