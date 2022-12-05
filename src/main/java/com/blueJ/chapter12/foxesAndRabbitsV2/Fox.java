package com.blueJ.chapter12.foxesAndRabbitsV2;

public class Fox extends Animal{
    protected static int alter = 10;
    public Fox(){}

    public void changeAge(){
        System.out.println(alter);
    }


}