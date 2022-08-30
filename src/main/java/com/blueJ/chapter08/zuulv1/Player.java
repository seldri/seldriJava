package com.blueJ.chapter08.zuulv1;

import java.util.ArrayList;

public class Player {

    private String name;
    private Room currentRoom;
    private ArrayList<Item> items;
    public static int MAX_INVENTORY_WEIGHT = 1500;
    private int inventoryWeight;

    public Player(String name, Room startingRoom){
        this.name = name;
        currentRoom = startingRoom;
        //playerItem = null;
        items = new ArrayList<>();
        inventoryWeight = 0;
    }

    public String getName(){
        return name;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public void take(Item item){
        items.add(item);
        inventoryWeight += item.getWeight();
    }

    public int getInventoryWeight(){
        return inventoryWeight;
    }

    public Item dropItem(String itemName){
        Item item = null;
        for(Item i : items){
            if(i.getDescription().equals(itemName)){
                item = i;
                System.out.println("Item: " + item.getDescription() + " has been dropped.");
                inventoryWeight -= item.getWeight();
            }
        }
        items.remove(item);
        if(item == null){
            System.out.println("The player does not have such an item!");
        }
        System.out.println("Current player inventory: ");
        for(Item i : items){
            System.out.println(i.getItemInfo());
        }
        System.out.println("Current inventory weigh: " + inventoryWeight);
        return item;
    }

    public void itemInventory(){
        System.out.println("Current player inventory: ");
        for(Item i : items){
            System.out.println(i.getDescription());
        }
        System.out.println("Current inventory weight: " + inventoryWeight);
    }

    public void eatCookie(){
        MAX_INVENTORY_WEIGHT += 2500;
        System.out.println("Cookie eaten.");
        System.out.println("New max capacity: " + MAX_INVENTORY_WEIGHT);
    }
}
