package com.blueJ.chapter08.zuulWEnumsV2;

public enum CommandWord{

    GO("go"), QUIT("quit"), 
    HELP("hilfeichbinvollmitschoggi"), 
    UNKNOWN("?"), LOOK("look"),
    CHECKOUT("yes"), NOCHECKOUT("no"),
    CHARGE("charge"), TELEPORT("teleport");


    private String commandString;

    CommandWord(String commandString){
        this.commandString = commandString;
    }

    public String toString(){
        return commandString;
    }
}