package com.blueJ.chapter08.zuulv1;
import java.util.HashMap;
import java.util.Set;

import java.util.ArrayList;

public class Room{

    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> itemList;

    public Room(String description){
        this.description = description;
        exits = new HashMap<>();
        itemList = new ArrayList<>();
    }

    public void placeItem(String description, String weight){
        itemList.add(new Item(description, weight));
    }

    public String getDescription(){
        return description;
    }

    public void setExits(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }

    public String getExitListString(){
        String result = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            result += " " + exit; 
        }
        return result;
    }

    public String getLongDescription(){
        return "You are " + this.description + ".\n" + getExitListString() + "\n" + getItemsInfo();
    }

    public String getItemsInfo(){
        String items = "";
        for(Item item : itemList){
            items += item.getItemInfo() + "\n";
        }
        return items;
    }
}