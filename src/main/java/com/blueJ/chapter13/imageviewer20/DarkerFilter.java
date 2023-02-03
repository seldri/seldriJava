package com.blueJ.chapter13.imageviewer20;

public class DarkerFilter extends Filter {
    
    public DarkerFilter(String name){
        super(name);
    }

    public void apply(OFImage image){
        for(int i = 0; i < image.getHeight(); i++) { 
            for(int j = 0; j < image.getWidth(); j++) {
                image.setPixel(j, i, image.getPixel(j, i).darker());
            }
        }
    }
}
