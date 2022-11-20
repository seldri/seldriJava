package com.blueJ.chapter10.networkV2;

import java.util.ArrayList;

public class NewsFeed {
    private ArrayList<Einsendung> einsendungen;
    
    public NewsFeed(){
        einsendungen = new ArrayList<>();
    }

    /**
     * Fuege dem NewsFeed eine Einsendung hinzu.
     * 
     * @param Einsendung    die hinzuzufuegende Einsendung
     */
    public void addEinsendung(Einsendung einsendung){
        einsendungen.add(einsendung);
    }

    /**
     * Gebe den NewsFeed aus.
     */
    public void zeigen(){
        for(Einsendung einsendung : einsendungen){
            einsendung.anzeigen();
            System.out.println();
        }
    }
}