package com.blueJ.chapter11.networkV3;

import java.util.ArrayList;

public class KommentierteEinsendung extends Einsendung{
    private int gefielWieoft;
    private ArrayList<String> kommentare;

    public KommentierteEinsendung(String autor){
        super(autor);
        gefielWieoft = 0;
        kommentare = new ArrayList<>();
    }

    public void gefaellt(){
        gefielWieoft++;
    }

    public void gefaelltNicht(){
        if(gefielWieoft > 0){
            gefielWieoft--;
        }
    }

    public void addKommentar(String text){
        kommentare.add(text);
    }

    public void anzeigen(){
        super.anzeigen();
        if(gefielWieoft > 0){
            System.out.println("Gefaellt " + gefielWieoft + " Personen.");
        }
        if(kommentare.isEmpty()){
            System.out.println("Keine Kommentare.");
        }
        else{
            System.out.println(kommentare.size() + " Kommentare. Hier klicken um anzusehen.");
        }
        
    }
}