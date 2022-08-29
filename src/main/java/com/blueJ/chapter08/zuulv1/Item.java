package com.blueJ.chapter08.zuulv1;

public class Item{
    
    private String description;
    private String weight;

    public Item(String description, String weight){
        this.description = description;
        this.weight = weight;
    }

    public String getItemInfo(){
        if(description.equals("")){
            return "No item in this room.";
        }
        return "The item in this room is: " + "\n" + description + " " + "Weight: " + weight;
    }
}