package com.blueJ.chapter10.networkV2;

//import java.util.ArrayList;

public class NachrichtenEinsendung extends KommentierteEinsendung{
    private String nachricht;

    public NachrichtenEinsendung(String autor, String text){
        super(autor);
        nachricht = text;
    }

    public String getNachricht(){
        return nachricht;
    }

    public void printKurzeInfo(){
        System.out.println("Nachricht von " + getBenutzername());
    }
}