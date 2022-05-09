package com.blueJ.chapter04.FirstPart;
import java.util.ArrayList;

public class ArrayListTraining{

    private ArrayList<String> numberList;

    public ArrayListTraining(){
        numberList = new ArrayList<>();
    }

    public void addToList(){
        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        numberList.add("4");
    }

    public void printOutList(){
        for(String number : numberList){
            System.out.println(number);
        }
    }

}