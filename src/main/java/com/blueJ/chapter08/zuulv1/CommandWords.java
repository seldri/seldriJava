package com.blueJ.chapter08.zuulv1;

public class CommandWords{

    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    public CommandWords(){

    }

    public boolean isCommand(String aString){
        for(int i = 0; i < validCommands.length; i++){
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
}