package com.blueJ.chapter11.networkV3;

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

    public void anzeigen(){
        super.anzeigen();
        System.out.println(nachricht);
    }
}