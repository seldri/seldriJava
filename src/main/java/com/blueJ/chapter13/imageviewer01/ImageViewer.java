package com.blueJ.chapter13.imageviewer01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageViewer {
    private JFrame frame;
    
    public ImageViewer(){
        makeFrame();
    }

    private void makeFrame(){
        frame = new JFrame("ImageViewer");
        Container contentPane = frame.getContentPane();

        JLabel label = new JLabel("Put label here");
        contentPane.add(label);

        frame.pack();
        frame.setVisible(true);
    }
}
