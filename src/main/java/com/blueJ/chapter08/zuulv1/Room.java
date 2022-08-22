package com.blueJ.chapter08.zuulv1;

public class Room{

    public String description;
    public Room northExit;
    public Room eastExit;
    public Room southExit;
    public Room westExit;

    public Room(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public Room getExit(String direction){
        if(direction.equals("north")){
            return northExit;
        }
        if(direction.equals("east")){
            return eastExit;
        }
        if(direction.equals("south")){
            return southExit;
        }
        if(direction.equals("west")){
            return westExit;
        }
        return null;
    }

    public void setExits(Room north, Room east, Room south, Room west){
        if(north != null){
            northExit = north;
        }
        if(east != null){
            eastExit = east;
        }
        if(south != null){
            southExit = south;
        }
        if(west != null){
            westExit = west;
        }
    }
    

}