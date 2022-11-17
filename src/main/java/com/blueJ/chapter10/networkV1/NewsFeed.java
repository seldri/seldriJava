package com.blueJ.chapter10.networkV1;

import java.util.ArrayList;

public class NewsFeed {
    private ArrayList<NachrichtenEinsendung> nachrichten;
    private ArrayList<FotoEinsendung> fotos;

    /**
     * Erzeuge einen leeren Newsfeed.
     */
    public NewsFeed(){
        nachrichten = new ArrayList<>();
        fotos = new ArrayList<>();
    }

    /**
     * Fuege dem Newsfeed eine eingesendete Nachricht hinzu.
     * 
     * @param nachricht     die eingesendete Nachricht, die hinzugefuegt werden soll
     */
    public void erfasseNachricht(NachrichtenEinsendung nachricht){
        nachrichten.add(nachricht);
    }

    /**
     * Fuege em Newsfeed ein eingesendetes Foto hinzu.
     * 
     * @param foto      das eingesendete Foto, das hinzugefuegt werden soll
     */
    public void erfasseFoto(FotoEinsendung foto){
        fotos.add(foto);
    }

    /**
     * Gebe den Newsfeed aus.
     */
    public void zeigen(){
        for(NachrichtenEinsendung n : nachrichten){
            n.anzeigen();
            System.out.println();
        }

        for(FotoEinsendung f : fotos){
            f.anzeigen();
            System.out.println();
        }
    }

}