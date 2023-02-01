package com.blueJ.chapter13.imageviewer01;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class ImageViewer{
    private JFrame frame;
    
    public ImageViewer(){
        makeFrame();
    }

    private void quit(){
        System.out.println("Program Quit!");
        System.exit(0);
    }

    private void openFile(){
        System.out.println("File Opened!");
    }

    private void about(){
        System.out.println("Pubilsher: seldri // Year: 2023");
    }

    private void makeFrame(){
        frame = new JFrame("ImageViewer");
        makeMenuBar();

        Container contentPane = frame.getContentPane();

        JLabel label = new JLabel("Ich bin ein Label ich kann text darstellen");
        contentPane.add(label);

        frame.pack();
        frame.setVisible(true);
    }

    private void makeMenuBar(){
        JMenuBar menueBar = new JMenuBar();
        frame.setJMenuBar(menueBar);

        JMenu file = new JMenu("Datei");
        menueBar.add(file);

        JMenuItem openFile = new JMenuItem("Öffnen");
        openFile.addActionListener(e -> openFile());
        file.add(openFile);

        JMenuItem quitProgram = new JMenuItem("Beenden");
        quitProgram.addActionListener(e -> quit());
        file.add(quitProgram);

        JMenu help = new JMenu("Hilfe");
        menueBar.add(help);

        JMenuItem information = new JMenuItem("Information");
        information.addActionListener(e -> about());
        help.add(information);
    }
}
