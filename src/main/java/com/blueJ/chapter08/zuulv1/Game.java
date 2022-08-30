package com.blueJ.chapter08.zuulv1;

import java.util.Stack;

public class Game{

    private Parser parser;
    //private Room currentRoom;
    //private Room previousRoom;
    private Stack<Room> previousRooms;

    private Player player;

    public Game(){
        createRooms();
        parser = new Parser();
        //previousRoom = null;
        previousRooms = new Stack<>();
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

        player = new Player("Bob", railstation);
        //currentRoom = railstation;
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

    public void lookAround(){
             System.out.println(player.getCurrentRoom().getLongDescription());
        }

    public void eat(){
        System.out.println("You have now eaten and are not hungry anymore!");
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
        else if(commandWord.equals("look")){
            lookAround();
        }
        else if(commandWord.equals("eat")){
            eat();
        }
        else if(commandWord.equals("back")){
            getBack();
        }
        else if(commandWord.equals("take")){
            take(command);
        }
        else if(commandWord.equals("drop")){
            drop(command);
        }
        else if(commandWord.equals("items")){
            items();
        }
        else if(commandWord.equals("cookie")){
            cookieEat();
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
        System.out.println(parser.getCommands());
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();

        Room nextRoom = player.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            previousRooms.push(player.getCurrentRoom());
            player.setCurrentRoom(nextRoom);
            getRoomInformation();
        }
    }

    public void getBack(){
        if(previousRooms.empty()){
            System.out.println("You are at the first room!");
        }
        else{
            player.setCurrentRoom(previousRooms.pop());
            System.out.println("You are now back at: " + player.getCurrentRoom().getLongDescription());
        }
    }

    public void getRoomInformation(){
        System.out.println("You are " + player.getCurrentRoom().getLongDescription());
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

    private void drop(Command command){
        if(!command.hasSecondWord()){
            System.out.println("Drop what?");
            return;
        }
        String itemName = command.getSecondWord();
        player.getCurrentRoom().addItem(player.dropItem(itemName));
    }

    private void take(Command command){
        if(!command.hasSecondWord()){
            System.out.println("Take what?");
            return;
        }
        String itemName = command.getSecondWord();
        Item item = player.getCurrentRoom().getItem(itemName);
        int playerCapacity = Player.MAX_INVENTORY_WEIGHT;
        if(player.getInventoryWeight() + item.getWeight() <= playerCapacity){
            player.take(item);
            System.out.println(item.getDescription() + " taken");
            player.getCurrentRoom().removeItem(item);
        }
        else{
            System.out.println("The item load is too heavy! Try dropping some items.");
        }
        System.out.println("Current capacity: " + player.getInventoryWeight() + "g");
    }

    public void items(){
        player.itemInventory();
    }

    public void cookieEat(){
        Item cookie = player.getCurrentRoom().getItem("magic_cookie");
        if(cookie != null){
            player.eatCookie();
            player.getCurrentRoom().removeItem(cookie);
        }
        else{
            System.out.println("No cookie :/");
        }
    }
}