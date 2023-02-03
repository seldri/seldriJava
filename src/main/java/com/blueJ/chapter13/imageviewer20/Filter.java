package com.blueJ.chapter13.imageviewer20;

public abstract class Filter {
    private String name;

    public Filter(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void apply(OFImage image);
}
