package com.blueJ.chapter13.imageviewer20;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class ImageViewer
{
    private JFrame frame;
    private ImagePanel imagePanel;
    private OFImage currentImage;
    private JLabel statusLabel;
    private static final String VERSION = "Version 1.0";
    private ArrayList<Filter> filterList;
    
    /**
     * Create an ImageViewer show it on screen.
     */
    public ImageViewer()
    {
        currentImage = null;
        filterList = createFilters();
        makeFrame();
    }

    /*
     *Create the needed filters
     @return List of filters 
     */
    private ArrayList<Filter> createFilters(){
        ArrayList<Filter> filterList = new ArrayList<>();
        filterList.add(new DarkerFilter("Darker"));
        filterList.add(new BrighterFilter("Brighter"));
        filterList.add(new ThresholdFilter("Threshold"));
        
        return filterList;
    }

    // ---- implementation of menu functions ----
    
    /**
     * Open function: open a file chooser to select a new image file.
     */
    private void openFile()
    {
        //OFImage image = ImageFileManager.getImage();
        currentImage = ImageFileManager.getImage();
        imagePanel.setImage(currentImage);
        frame.pack();
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }

    //Filter Method
    private void applyFilter(String filterName){
        if(currentImage != null){
            for(Filter f : filterList){
                if(f.getName().equals(filterName)){
                    f.apply(currentImage);
                    frame.repaint();
                    showStatus("Applied: " + f.getName());
                }
            }
        }
        else{
            showStatus("No Image available!");
        }
    }
    
    private void showStatus(String status){
        statusLabel.setText(status);
    }
   
    // ---- swing stuff to build the frame and all its components ----

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        makeMenuBar(frame);
        
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));
        
        
        JLabel fileNameLabel = new JLabel();
        contentPane.add(fileNameLabel, BorderLayout.NORTH);


        imagePanel = new ImagePanel();
        contentPane.add(imagePanel, BorderLayout.CENTER);

        statusLabel = new JLabel(VERSION);
        contentPane.add(statusLabel, BorderLayout.SOUTH);

        // building is done - arrange the components and show        
        frame.pack();
        frame.setVisible(true);
    }

    /*
     * Display Information on GUI
     */
    private void showInfo(){
        JOptionPane.showMessageDialog(frame, "ImageViewer: " + VERSION, "About ImageViewer", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File manu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        
        JMenuItem openItem = new JMenuItem("Open");
            openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            openItem.addActionListener(e -> openFile());
        fileMenu.add(openItem);

        JMenuItem quitItem = new JMenuItem("Quit");
            quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            quitItem.addActionListener(e -> quit());
        fileMenu.add(quitItem);

        // create Filter menu
        JMenu filterMenu = new JMenu("Filter");
        menubar.add(filterMenu);
         
        // add Filter Options to menu
        for(Filter f : filterList){
            JMenuItem item = new JMenuItem(f.getName());
                item.addActionListener(e -> applyFilter(f.getName()));
            filterMenu.add(item);
        }

        // create help Menu
        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);

        JMenuItem informationItem = new JMenuItem("About");
            informationItem.addActionListener(e -> showInfo());
        helpMenu.add(informationItem);
    }
}