package com.blueJ.chapter13.imageviewer04;

import java.awt.*;
import java.awt.image.*;
//import javax.swing.*;

public class OFImage extends BufferedImage {
    /**
     * Create an OFImage copied from a BufferedImage.
     * @param image The image to copy.
     */
    public OFImage(BufferedImage image) {
         super(image.getColorModel(), image.copyData(null), 
               image.isAlphaPremultiplied(), null);
    }

    /**
     * Create an OFImage with specified size and unspecified content.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public OFImage(int width, int height) {
        super(width, height, TYPE_INT_RGB);
    }

    /**
     * Set a given pixel of this image to a specified color. The
     * color is represented as an (r,g,b) value.
     * @param x The x position of the pixel.
     * @param y The y position of the pixel.
     * @param col The color of the pixel.
     */
    public void setPixel(int x, int y, Color col)
    {
        int pixel = col.getRGB();
        setRGB(x, y, pixel);
    }
    
    /**
     * Get the color value at a specified pixel position.
     * @param x The x position of the pixel.
     * @param y The y position of the pixel.
     * @return The color of the pixel at the given position.
     */
    public Color getPixel(int x, int y)
    {
        int pixel = getRGB(x, y);
        return new Color(pixel);
    }

    /*
     * Make the given Image brighter
     */
    public void makeImageBrighter(){
        for(int i = 0; i < getHeight(); i++) { 
            for(int j = 0; j < getWidth(); j++) {
                Color pixel = getPixel(j, i);
                setPixel(j, i, pixel.brighter());
            }
        }
    }

    /*
     * Make the given image darker
     */
    public void makeImageDarker(){
        for(int i = 0; i < getHeight(); i++) { 
            for(int j = 0; j < getWidth(); j++) {
                Color pixel = getPixel(j, i);
                setPixel(j, i, pixel.darker());
            }
        }
    }

    /*
     * Apply a given threshold
     */
    public void threshold() { 
        for(int y = 0; y < getHeight(); y++) { 
            for(int x = 0; x < getWidth(); x++) {
                Color pixel = getPixel(x, y);
                int brightness = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                if(brightness <= 100) { 
                    setPixel(x, y, Color.BLACK);
                }
                else if(brightness <= 200) { 
                    setPixel(x, y, Color.GRAY);
                } 
                else { 
                    setPixel(x, y, Color.WHITE); 
                } 
            }
        }
    }
}