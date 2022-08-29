package com.blueJ.chapter08.zuulv1;
import java.util.HashMap;
import java.util.Set;

public class Room{

    private String description;
    private HashMap<String, Room> exits;
    private Item item;

    public Room(String description){
        this.description = description;
        exits = new HashMap<>();
        item = new Item("", "");
    }

    public Room(String description, String itemDescription, String itemWeight){
        this.description = description;
        exits = new HashMap<>();
        item = new Item(itemDescription, itemWeight);
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
        return "You are " + description + ".\n" + getExitListString() + "\n" + item.getItemInfo(); 
    }

}