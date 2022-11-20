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
        System.out.println(getBenutzername());
        System.out.println(nachricht);
        System.out.print(zeitString(getZeitstempel()) + ". ");
        if(getGefielWieOft() > 0){
            System.out.println(getGefielWieOft() + " Person(en) gefaellt dies.");
        }
        if(getKommentare().isEmpty()){
            System.out.println("Keine Kommentare");
        }
        else{
            System.out.println(getKommentare().size() + " Kommentare. Hier klicken um anzusehen");
        }
    }
}