package com.blueJ.chapter10.networkV1;

import java.util.ArrayList;

public class FotoEinsendung {
    private String benutzername;
    private String dateiname;
    private String ueberschrift;
    private long zeitstempel;
    private int gefielWieoft;
    private ArrayList<String> kommentare;    

    /**
     * Konstruktor für Objekte der Klasse FotoEinsendung.
     * 
     * @param autor             der Benutzername des Einsenders
     * @param dateiname         der Dateiname des Bildes in dieser Einsendung
     * @param ueberschrift      eine Ueberschrift fuer das Bild
     */
    public FotoEinsendung(String autor, String dateiname, String ueberschrift){
        benutzername = autor;
        this.dateiname = dateiname;
        this.ueberschrift = ueberschrift;
        zeitstempel = System.currentTimeMillis();
        gefielWieoft = 0;
        kommentare = new ArrayList<>();
    }

    /**
     * Halte fest, dass das Bild von einem Benutzer mit 'gefaellt mir' bewertet wurde.
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
     * @param text      der neu hinzuzufuegende Kommentar
     */
    public void erfasseKommentar(String text){
        kommentare.add(text);
    }

    /**
     * Liefere den Dateinamen des Bildes aus der Einsendung.
     * 
     * @return  den Namen der Bilddatei
     */
    public String gibBildDateiname(){
        return dateiname;
    }

    /**
     * Liefere die Ueberschrift des Bildes aus der Einsendung.
     * 
     * @return die Ueberschrift des Bildes
     */
    public String gibUeberschrift(){
        return ueberschrift;
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
     * 
     */
    public void anzeigen(){
        System.out.println(benutzername);
        System.out.println(" [" + dateiname + "]");
        System.out.println(" " + ueberschrift);
        System.out.println(zeitString(zeitstempel));

        if(gefielWieoft > 0){
            System.out.println(" - " + gefielWieoft + " Person(en) gefaellt das.");
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
     * @param zeit      der umzuwandelnde Zeitwert (in System-Millisekunden)
     * @return          eine relative Zeitbeschreibung fuer den gegebenen Zeitwert
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