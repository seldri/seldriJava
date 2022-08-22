package com.blueJ.chapter08.zuulv1;

public class Game{

    private Parser parser;
    private Room currentRoom;

    public Game(){
        createRooms();
        parser = new Parser();
    }

    public void createRooms(){
        Room center, park, police, hills, hospital, bikeshop, fields, school, creek, railstation, factory, suburbs;
        center = new Room("At the town square");
        park = new Room("next to the school");
        police = new Room("close to the hills");
        hospital = new Room("behind the police");
        hills = new Room("on the edge");
        school = new Room("In the center");
        creek = new Room("below the park");
        railstation = new Room("West of the school");
        factory = new Room("North of the railstation");
        suburbs = new Room("On the western edge");
        bikeshop = new Room("In the northern centre");
        fields = new Room("In the north");

        center.setExits("south", park);

        park.setExits("north", center);
        park.setExits("east", police);
        park.setExits("west", school);
        
        police.setExits("north", hospital);
        police.setExits("east", hills);
        police.setExits("west", park);

        hospital.setExits("south", police);
        hospital.setExits("west", bikeshop);

        hills.setExits("west", police);

        school.setExits("north", bikeshop);
        school.setExits("east", park);
        school.setExits("south", creek);
        school.setExits("west", railstation);

        creek.setExits("north", school);

        railstation.setExits("north", factory);
        railstation.setExits("east", school);

        factory.setExits("east", bikeshop);
        factory.setExits("south", railstation);
        factory.setExits("west", suburbs);

        suburbs.setExits("east", factory);

        bikeshop.setExits("north", fields);
        bikeshop.setExits("east", hospital);
        bikeshop.setExits("south", school);
        bikeshop.setExits("west", factory);

        fields.setExits("south", bikeshop);

        currentRoom = railstation;
    }

    public void play(){
        printWelcome();

        boolean finished = false;
        while(!finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Goodbye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        getRoomInformation();
    }

    private boolean processCommand(Command command){
        boolean wantToQuit = false;

        if(command.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if(commandWord.equals("help")){
            printHelp();
        }
        else if(commandWord.equals("go")){
            goRoom(command);
        }
        else if(commandWord.equals("quit")){
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }
    
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            getRoomInformation();
        }
    }

    public void getRoomInformation(){
        System.out.println("You are " + currentRoom.getLongDescription());
        // currentRoom.getExitListString();
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}