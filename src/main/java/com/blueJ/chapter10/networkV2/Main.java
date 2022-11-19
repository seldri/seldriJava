package com.blueJ.chapter10.networkV2;

public class Main {
    public static void main(String[] args){
        EreignisEinsendung ereignis = new EreignisEinsendung("John", "Hit");
        ereignis.anzeigen();
        System.out.println(ereignis.getEreignisTyp());
    }
}