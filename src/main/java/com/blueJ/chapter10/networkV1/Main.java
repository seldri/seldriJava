package com.blueJ.chapter10.networkV1;

public class Main {
    public static void main(String[] args){
        NewsFeed nf1 = new NewsFeed();
        FotoEinsendung f1 = new FotoEinsendung("Bob", "Foto1", "Mein erstes Foto");
        NachrichtenEinsendung n1 = new NachrichtenEinsendung("Bob", "Meine erste Nachricht");

        nf1.erfasseNachricht(n1);
        nf1.erfasseFoto(f1);
        n1.erfasseKommentar("nice");
        nf1.zeigen();
    }
}
