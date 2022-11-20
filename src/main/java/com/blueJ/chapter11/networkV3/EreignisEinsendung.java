package com.blueJ.chapter11.networkV3;

public class EreignisEinsendung extends Einsendung{
    private String ereignisTyp;

    public EreignisEinsendung(String autor, String ereignisTyp){
        super(autor);
        this.ereignisTyp = ereignisTyp;
    }

    public String getEreignisTyp(){
        return ereignisTyp;
    }
}