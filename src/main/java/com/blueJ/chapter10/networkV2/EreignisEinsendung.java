package com.blueJ.chapter10.networkV2;

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