package com.blueJ.chapter08.zuulWEnumsV2;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private final int maxCommands = 5;
    private int commandCounter;

    private Room startingRoom;
    private Room teleportRoom;
    private boolean hasKey;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        commandCounter = 0;
        startingRoom = currentRoom;
        hasKey = false;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        //pub.setExit("east", outside);
        pub.setExit("south", lab);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        lab.setTrapDoor();

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println("You need to reach the office with maximum: " + maxCommands + " commands!");
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        commandCounter++;
        if(commandCounter > maxCommands){
            System.out.println("You have reached the maximum amount of commands!");
            return true;
        }
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                look();
                break;
            
            case CHECKOUT:
                trap();
                break;

            case NOCHECKOUT:
                trapAvoid();
                break;

            case CHARGE:
                chargeBeamer();
                break;
            
            case TELEPORT:
                teleport();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            if(currentRoom.getShortDescription().equals("in a computing lab")){
                if(!hasKey){
                    System.out.println("You have to get the key to the lab first!");
                    currentRoom = currentRoom.getExit("north");
                    //System.out.println(currentRoom.getLongDescription());
                }
                else{
                    System.out.println("You unlocked the door with the key!");
                }
            }

            if(currentRoom.getShortDescription().equals("in the campus pub")){
                hasKey = true;
                System.out.println("You found the key to the lab!");
            }

            System.out.println(currentRoom.getLongDescription());
            if(currentRoom.hasTrapDoor()){
                System.out.println("There is something on the ground!");
                System.out.println("Do you want to check it out?");
                System.out.println("To check it out type: " + CommandWord.CHECKOUT);
                System.out.println("To ignore it type: " + CommandWord.NOCHECKOUT);
            }

            if(currentRoom.getShortDescription().equals("in the computing admin office")){
                System.out.println("You have reached the office! You WON the game!");
                System.out.println("Thank you for playing! Goodbye.");
                System.exit(1);
            }

            if(currentRoom.getShortDescription().equals("in the campus pub")){
                System.out.println("The door slammed shut behind you!");
                System.out.println("You can't go back!");
            }
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
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

    private void look(){
        System.out.println(currentRoom.getLongDescription());
    }

    private void trap(){
        System.out.println("You have fallen into a trap!");
        currentRoom = startingRoom;
        System.out.println("You will restart now at the beginning!");
        commandCounter = 0;
        System.out.println("Your command counter is set back to 0!");
    }

    private void trapAvoid(){
        System.out.println("You have avoided the trap! Not bad..");
        System.out.println("You have won to more commands you can use!");
        commandCounter -= 3;
        System.out.println("Your new command count is: " + commandCounter);
    }

    public void teleport(){
        if(teleportRoom != null){
            currentRoom = teleportRoom;
            System.out.println("You teleported to: " + currentRoom);
            System.out.println("Your beamer is empty again!");
        }
        else{
            System.out.println("Charge your device first!");
        }
    }

    public void chargeBeamer(){
        if(teleportRoom == null){
            teleportRoom = currentRoom;
            System.out.println("Beamer charged with teleport destination!");
        }
        else{
            System.out.println("Beamer already charged!");
        }
    }
}