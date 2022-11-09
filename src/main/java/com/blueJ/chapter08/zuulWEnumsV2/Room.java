package com.blueJ.chapter08.zuulWEnumsV2;

import java.util.Set;
import java.util.HashMap;
//import java.util.Iterator;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private boolean hasTrapDoor;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        hasTrapDoor = false;
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public boolean hasTrapDoor(){
        return hasTrapDoor;
    }

    public void setTrapDoor(){
        this.hasTrapDoor = true;
    }
}

