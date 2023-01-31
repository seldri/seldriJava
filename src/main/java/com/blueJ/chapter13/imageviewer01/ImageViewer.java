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

        JLabel label = new JLabel("Ich bin ein Label ich kann text darstellen");
        contentPane.add(label);

        // JButton button = new JButton("hello");
        // contentPane.add(button);

        makeMenu();

        frame.pack();
        frame.setVisible(true);
    }

    private void makeMenu(){
        JMenuBar menueBar = new JMenuBar();
        frame.setJMenuBar(menueBar);

        JMenu dateiMenue = new JMenu("Datei");
        menueBar.add(dateiMenue);

        JMenuItem openDatei = new JMenuItem("Öffnen");
        dateiMenue.add(openDatei);

        JMenuItem closeDatei = new JMenuItem("Beenden");
        dateiMenue.add(closeDatei);

        JMenu hilfeMenue = new JMenu("Hilfe");
        menueBar.add(hilfeMenue);

        JMenuItem hilfeInfo = new JMenuItem("Info");
        hilfeMenue.add(hilfeInfo);
    }
}
