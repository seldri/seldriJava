package com.blueJ.chapter11.networkV3;

public class Main {
    public static void main(String[] args){
        NewsFeed nf1 = new NewsFeed();

        FotoEinsendung f1 = new FotoEinsendung("Bob", "File1", "Neues Foto");
        NachrichtenEinsendung n1 = new NachrichtenEinsendung("Tim", "Hatte heute Morgen..." + "\n" + "Doch jetzt habe ich vergessen...");
        EreignisEinsendung e1 = new EreignisEinsendung("Manu", "Newsflash");

        f1.gefaellt();
        f1.gefaellt();

        n1.gefaellt();

        nf1.addEinsendung(f1);
        nf1.addEinsendung(n1);
        nf1.addEinsendung(e1);

        nf1.zeigen();
    }
}