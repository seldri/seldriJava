package com.blueJ.chapter10.networkV2;

//import java.util.ArrayList;

public class FotoEinsendung extends KommentierteEinsendung{
    private String dateiname;
    private String ueberschrift;

    public FotoEinsendung(String autor, String dateiname, String ueberschrift){
        super(autor);
        this.dateiname = dateiname;
        this.ueberschrift = ueberschrift;
    }

    public void printKurzeInfo(){
        System.out.println("Fotopost von " + getBenutzername());
    }

    public String getDateiname(){
        return dateiname;
    }

    public String getUeberschrift(){
        return ueberschrift;
    }
}