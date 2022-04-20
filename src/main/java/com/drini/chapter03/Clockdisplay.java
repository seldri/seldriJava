package com.drini.chapter03;

public class Clockdisplay {
    /*Class to put together and display the time
    The variables of the class Clockdisplay hold two Objects from the type Numberdisplay
    One for hours and one for minutes*/
    public Numberdisplay hours;
    public Numberdisplay minutes;
    public String displayValue;
    //Constructor which sets hours and minutes of the clockdisplay to 0 and 0 by creating new Numberdisplay Objects
    public Clockdisplay(){
        hours = new Numberdisplay(24);
        minutes = new Numberdisplay(60);
        updateDisplayValue();
    }

    public Clockdisplay(int hoursStarting, int minutesStarting){
        hours = new Numberdisplay(24);
        minutes = new Numberdisplay(60);
        setStartingTime(hoursStarting, minutesStarting);
        updateDisplayValue();
    }

    public void timeTick(){
        minutes.increment();
        if(minutes.getValue() == 0){
            hours.increment();
        }
        updateDisplayValue();
    }

    public void setStartingTime(int hoursStart, int minutesStart){
        hours.setTime(hoursStart);
        minutes.setTime(minutesStart);
        updateDisplayValue();
    }

    public String getDisplayValue(){
        return displayValue;
    }

    public void updateDisplayValue(){
        displayValue = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }
}