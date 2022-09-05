package com.blueJ.chapter08.zuulWEnumsV2;

public class Person {

    private String name;
    private Room room;
    private String helpText;

    public Person(String name, Room room, String helpText){
        this.name = name;
        this.room = room;
        this.helpText = helpText;
    }

    public String getName(){
        return name;
    }

    public Room getRoom(){
        return room;
    }

    public void sayHi(){
        System.out.println("Hello my name is " + name + " nice to meet you!");
    }

    public void giveHelp(){
        System.out.println(helpText);
    }
}
