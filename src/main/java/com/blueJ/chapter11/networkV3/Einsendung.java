package com.blueJ.chapter11.networkV3;

public class Einsendung {
    private String benutzername;
    private long zeitstempel;

    public Einsendung(String autor){
        benutzername = autor;
        zeitstempel = System.currentTimeMillis();
    }

    protected String getBenutzername(){
        return benutzername;
    }

    protected long getZeitstempel(){
        return zeitstempel;
    }

    public void anzeigen(){
        System.out.println(benutzername);
        System.out.print(zeitString(zeitstempel) + ". ");
    }

    protected String zeitString(long zeit){
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