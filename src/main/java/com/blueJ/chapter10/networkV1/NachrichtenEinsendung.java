package com.blueJ.chapter10.networkV1;

import java.util.ArrayList;

public class NachrichtenEinsendung {
    private String benutzername;
    private String nachricht;
    private long zeitstempel;
    private int gefielWieoft;
    private ArrayList<String> kommentare;

    /**
     * Konstruktor fuer Objekte der Klasse NachrichtenEinsendung
     * 
     * @param autor     der Benutzername des Einsenders
     * @param text      der Text dieser Einsendung
     */
    public NachrichtenEinsendung(String autor, String text){
        benutzername = autor;
        nachricht = text;
        zeitstempel = System.currentTimeMillis();
        gefielWieoft = 0;
        kommentare = new ArrayList<>();
    }

    /**
     * Halte fest, dass die Nachricht von einem Benutzer mit 'gefaellt mir' bewertet wurde.
     */
    public void gefaellt(){
        gefielWieoft++;
    }

    /**
     * Halte fest, dass ein Benutzer seine 'gefaellt mir' Bewertung zurueckgezogen hat.
     */
    public void gefaelltNicht(){
        if(gefielWieoft > 0){
            gefielWieoft--;
        }
    }

    /**
     * Fuege der Einsendung einen Kommentar hinzu.
     * 
     * @param text der neu hinzuzufuegende Kommentar.
     */
    public void erfasseKommentar(String text){
        kommentare.add(text);
    }

    /**
     * Liefere den Text dieser Einsendun.
     * 
     * @return den Text der Einsendung.
     */
    public String gibText(){
        return nachricht;
    }

    /**
     * Liefere die Zeit, zu der die Einsendung erstellt wurde.
     * 
     * @return die Zeit, zu der die Einsendung erstellt wurde (als Systemzeit-Wert)
     */
    public long gibZeitstempel(){
        return zeitstempel;
    }

    /**
     * Zeige die Details der Einsendung an.
     */
    public void anzeigen(){
        System.out.println(benutzername);
        System.out.println(nachricht);
        System.out.println(zeitString(zeitstempel));

        if(gefielWieoft > 0){
            System.out.println(" - " + gefielWieoft + " Person(en) gefaellt dies.");
        }
        else{
            System.out.println();
        }

        if(kommentare.isEmpty()){
            System.out.println(" Keine Kommentare.");
        }
        else{
            System.out.println(" " + kommentare.size() + " Kommentar(e). Zum Einsehen hier klicken.");
        }
    }

    /**
     * Erzeuge einen String, der einen in der Vergangenheit liegenden Zeitpunkt im Vergleich zur aktuellen Zeit beschreibt.
     * Bsp: "vor 30 Sekunden" oder "vor 7 Minuten". Derzeit werden nur Sekunden und Minuten für den String verwendet.
     * 
     * @param Zeit der umzuwandelnde Zeitwert (in System-Millisekunden)
     * @return eine relative Zeitbeschreibung für den gegebenen Zeitwert
     */
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