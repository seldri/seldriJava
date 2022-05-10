package com.blueJ.chapter04;
import java.util.ArrayList;

public class ArrayListTraining{

    //private ArrayList<String> numberList;
    private ArrayList<String> nameList;

    public ArrayListTraining(){
        //numberList = new ArrayList<>();
        nameList = new ArrayList<>();
    }

    public void addToList(){
        nameList.add("Affe");
        nameList.add("Hund");
        nameList.add("Katze");
        nameList.add("Vogel");
    }

    /*public void printOutList(){
        for(String number : numberList){
            System.out.println(number);
        }
    }

    public void printElements(){
        int index = 0;
        while(index < numberList.size()){
            String number = numberList.get(index);
            System.out.println(number);
            index ++;
        }
    } */

    

    public void selectiveSearch(String search){
        int index = 0;
        boolean match = false;
        while(index < nameList.size()){
            String element = nameList.get(index);
            if(element.contains(search)){
                System.out.println(element);
                index++;
                match = true;
            }
            else{
                index++;
            }
        }
        if(!match){
            System.out.println("No match found!");
        }
    }

    public void selectiveSearch2(String search){
        int index = 0;
        boolean match = false;
        while(index < nameList.size() && !match){
            String element = nameList.get(index);
            if(element.contains(search)){
                System.out.println(element);
                index++;
                match = true;
            }
            else{
                index++;
            }
        }
        if(!match){
            System.out.println("No match found!");
        }
    }

}