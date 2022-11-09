package com.blueJ.chapter08.zuulWEnumsv1;
import java.util.HashMap;

public class CommandWords{

    private HashMap<String, CommandWord> validCommands;

    public CommandWords(){
        validCommands = new HashMap<>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("gehe", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("look", CommandWord.LOOK);
    }

    public boolean isCommand(String aString){
        return validCommands.containsKey(aString);
    }

    public CommandWord getCommandWord(String commandWord){
        CommandWord command = validCommands.get(commandWord);
        if(command != null){
            return command;
        }
        else{
            return CommandWord.UNKNOWN;
        }
    }
    
    public void showAll(){
        for(String command : validCommands.keySet()){
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}