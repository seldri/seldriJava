package com.blueJ.chapter08.zuulv1;
import java.util.HashMap;

public class Room{

    private String description;
    private HashMap<String, Room> exits;

    public Room(String description){
        this.description = description;
        exits = new HashMap<>();
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

    // public void getExitListString(){
    //     System.out.println("******************");
    //     if(northExit != null){
    //         System.out.println("North: " + northExit);
    //     }
    //     if(westExit != null){
    //         System.out.println("West: " + westExit);
    //     }
    //     if(southExit != null){
    //         System.out.println("South" + southExit);
    //     }
    //     if(eastExit != null){
    //         System.out.println("East: " + eastExit);
    //     }
    //     System.out.println("******************");
    // }
}