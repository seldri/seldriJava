package com.blueJ.chapter13.imageviewer20;

import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;

public class ImageFileManager {
    
    private static final String IMAGE_FORMAT = "jpg";
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    public static OFImage getImage(){
        int returnVal = fileChooser.showOpenDialog(null);

        if(returnVal != JFileChooser.APPROVE_OPTION){
            return null;
        }
        File selectedFile = fileChooser.getSelectedFile();
        return loadImage(selectedFile);
    }

    public static OFImage loadImage(File imageFile){
        try{
            BufferedImage image = ImageIO.read(imageFile);
            if(image == null || (image.getWidth(null) < 0)){
                return null;
            }
            return new OFImage(image);
        }
        catch(IOException exc){
            return null;
        }
    }

    public static void saveImage(OFImage image, File file){
        try{
            ImageIO.write(image, IMAGE_FORMAT, file);
        }
        catch(IOException exc){
            return;
        }
    }
}
