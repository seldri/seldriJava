package com.blueJ.chapter08.zuulv1;

public class Game{

    private Parser parser;
    private Room currentRoom;

    public Game(){
        createRooms();
        parser = new Parser();
    }

    public void createRooms(){
        Room park, police, hills, hospital, bikeshop, fields, school, creek, railstation, factory, suburbs;
        park = new Room("next to the school");
        police = new Room("close to the hills");
        hospital = new Room("behind the police");
        hills = new Room("on the edge");
        school = new Room("In the center");
        creek = new Room("below the park");
        railstation = new Room("West of the school");
        factory = new Room("North of the railstation");
        suburbs = new Room("On the western edge);
        bikeshop = new Room("In the northern centre");
        fields = new Room("In the north");

        park.setExits(null, police, null, school);
        police.setExits(hospital, hills, null, park);
        hospital.setExits(null, null, police, bikeshop);
        hills.setExits(null, null, null, police);
        school.setExits(bikeshop, park, creek, railstation);
        creek.setExits(school, null, null, null);
        railstation.setExits(factory, school, null, null);
        factory.setExits(null, bikeshop, railstation, suburbs);
        suburbs.setExits(null, factory, null, null);
        bikeshop.setExits(fields, hospital, school, factory);
        fields.setExits(null, null, bikeshop, null);
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
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
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

        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print("Exits: ");
            if(currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
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