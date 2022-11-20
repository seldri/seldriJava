package com.blueJ.chapter10.networkV2;

//import java.util.ArrayList;

public class Einsendung {
    private String benutzername;
    private long zeitstempel;
    //private int gefielWieoft;
    //private ArrayList<String> kommentare;

    public Einsendung(String autor){
        benutzername = autor;
        zeitstempel = System.currentTimeMillis();
       // gefielWieoft = 0;
      //  kommentare = new ArrayList<>();
    }

    public String getBenutzername(){
        return benutzername;
    }

    /* public void gefaellt(){
        gefielWieoft++;
    } */

    /* public void gefaelltNicht(){
        if(gefielWieoft > 0){
            gefielWieoft--;
        }
    } */

    /* public void addKommentar(String text){
        kommentare.add(text);
    } */

    public long getZeitstempel(){
        return zeitstempel;
    }

    public void anzeigen(){
        System.out.println(benutzername);
        System.out.println(zeitString(zeitstempel));
        /* if(gefielWieoft > 0){
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
        } */
    }

    private String zeitString(long zeit){
        long aktuell = System.currentTimeMillis();
        long vergangeneMillis = aktuell - zeit;
        long sekunden = vergangeneMillis / 1000;
        long minuten = sekunden / 60;

        if(minuten > 0){
            return "vor " + minuten + " Minuten";
        }
        else{
            return "vor " + sekunden + " Sekunden";
        }
    }
}