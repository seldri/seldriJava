package com.blueJ.chapter10.networkV2;

public class Main {
    public static void main(String[] args){
        NewsFeed n1 = new NewsFeed();

        FotoEinsendung f1 = new FotoEinsendung("John", "Foto1", "Ferien");
        NachrichtenEinsendung m1 = new NachrichtenEinsendung("Tim", "Hier");
        EreignisEinsendung e1 = new EreignisEinsendung("System", "new update");

        n1.addEinsendung(f1);
        n1.addEinsendung(m1);
        n1.addEinsendung(e1);

        n1.zeigen();
    }
}