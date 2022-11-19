package com.blueJ.chapter10.networkV2;

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

    public void zeigenKommentiert(){
        anzeigen();
        if(gefielWieoft > 0){
            System.out.println(" - " + gefielWieoft + " Personen gefaellt dies.");
        }
        else{
            System.out.println();
        }

        if(kommentare.isEmpty()){
            System.out.println(" Keine Kommentare.");
        }
        else{
            System.out.println("  " + kommentare.size() + " Kommentar(e). Hier klicken um anzusehen.");
        }
    }
}