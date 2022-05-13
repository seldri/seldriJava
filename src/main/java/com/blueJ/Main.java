package com.blueJ;

import com.blueJ.chapter04.AuctionSystem.*;
    
public class Main {

    


    public static void main(String[] args) {

        Auction a1 = new Auction();
        Person bob = new Person("Bob");
        Person tim = new Person("Tim");
        a1.enterLot("Hat");
        a1.enterLot("Toy");
        a1.enterLot("Shoes");
        a1.enterLot("Jacket");
        a1.makeABid(1, bob, 10);
        a1.makeABid(1, tim, 15);
        a1.makeABid(2, tim, 12);
        a1.makeABid(3, bob, 8);
        a1.finish();
        
    }
} 