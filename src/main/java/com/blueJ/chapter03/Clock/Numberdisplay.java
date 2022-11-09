package com.blueJ.chapter03.Clock;

public class Numberdisplay {

    //Class to display a type of number with a limit and a value it holds at a given time
    private int limit;
    private int value;
    //Constructor of the class which sets the limit depending on the time unit
    public Numberdisplay(int timeLimit) {
        limit = timeLimit;
        value = 0;
    }
    //Returns limit to see what is the maximum
    public int getLimit(){
        return limit;
    }
    //Returns value of the Numberdisplay
    public int getValue(){
        return value;
    }
    //Displays the value of the current time
    public String  getDisplayValue(){
        if(value < 10){
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }
    
    //Starting time can be set, but it cannot be bigger than the limit or smaller than 0
    public void setTime(int startingTime){
        if((startingTime >= 0) && (startingTime < limit)) {
            value = startingTime;
        }
        else {
            throw new IllegalArgumentException("Starting time cannot be bigger than the limit or under 0!");
        }
    }
    //Time unit gets incremented by one
    public void increment(){
        value = (value + 1) % limit;
    }
}