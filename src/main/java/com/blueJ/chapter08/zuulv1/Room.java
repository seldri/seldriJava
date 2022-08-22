package com.blueJ.chapter08.zuulv1;

public class Room{

    private String description;
    private Room northExit;
    private Room eastExit;
    private Room southExit;
    private Room westExit;

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

    public void getExitListString(){
        System.out.println("******************");
        if(northExit != null){
            System.out.println("North: " + northExit);
        }
        if(westExit != null){
            System.out.println("West: " + westExit);
        }
        if(southExit != null){
            System.out.println("South" + southExit);
        }
        if(eastExit != null){
            System.out.println("East: " + eastExit);
        }
        System.out.println("******************");
    }
}