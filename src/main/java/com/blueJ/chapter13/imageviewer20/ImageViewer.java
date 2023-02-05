package com.blueJ.chapter13.imageviewer20;

import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.io.File;
//import java.util.List;
import java.util.ArrayList;
//import java.util.Iterator;


public class ImageViewer
{
    private static final String VERSION = "Version 2.0";
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
    private static final int UPSCALE_FACTOR = 2;
    private static final int DOWNSCALE_FACTOR = 2;

    private JFrame frame;
    private ImagePanel imagePanel;
    private OFImage currentImage;
    private JLabel statusLabel;
    private JLabel filenameLabel;
    private ArrayList<Filter> filterList;
    private JButton bigButton;
    private JButton smallButton;
    
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
        int returnVal = fileChooser.showOpenDialog(frame);

        if(returnVal != JFileChooser.APPROVE_OPTION) {
            return;  // cancelled
        }
        File selectedFile = fileChooser.getSelectedFile();
        currentImage = ImageFileManager.loadImage(selectedFile);

        if(currentImage == null) {   // image file was not a valid image
            JOptionPane.showMessageDialog(frame,
                    "The file was not in a recognized image file format.",
                    "Image Load Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        imagePanel.setImage(currentImage);
        bigButton.setEnabled(true);
        smallButton.setEnabled(true);
        showFilename(selectedFile.getPath());
        showStatus("File loaded.");
        frame.pack();
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }

    /*
     * Close function; close current image
     */
    private void close(){
        currentImage = null;
        bigButton.setEnabled(false);
        smallButton.setEnabled(false);
        imagePanel.clearImage();
        showFilename(null);
    }

    //Filter Method
    private void applyFilter(Filter filter){
        if(currentImage != null){
            filter.apply(currentImage);
            frame.repaint();
            showStatus("Applied: " + filter.getName());
        }
        else{
            showStatus("No Image available!");
        }
    }
    
    /*
     * Show the about dialog
     */
    private void showAbout()
    {
        JOptionPane.showMessageDialog(frame, 
                    "ImageViewer\n" + VERSION,
                    "About ImageViewer", 
                    JOptionPane.INFORMATION_MESSAGE);
    }

    private void showStatus(String status){
        statusLabel.setText(status);
    }

    /**
     * Display a file name on the appropriate label.
     * @param filename The file name to be displayed.
     */
    private void showFilename(String filename)
    {
        if(filename == null) {
            filenameLabel.setText("No file displayed.");
        }
        else {
            filenameLabel.setText("File: " + filename);
        }
    }

    private void makeLarger() { 
        if(currentImage != null) {
            int width = currentImage.getWidth();
            int height = currentImage.getHeight();
            OFImage newImage = new OFImage(width * UPSCALE_FACTOR, height * UPSCALE_FACTOR);
            int newWidth = newImage.getWidth();
            int newHeight = newImage.getHeight();
            for (int x = 0; x < newWidth; x++) {
                for (int y = 0; y < newHeight; y++) {
                Color pixel = currentImage.getPixel(x / UPSCALE_FACTOR, y / UPSCALE_FACTOR);
                newImage.setPixel(x, y, pixel);
                } 
            } 
            currentImage = newImage;
            imagePanel.setImage(currentImage);
            frame.pack(); 
        } 
    }

    private void makeSmaller() { 
        if(currentImage != null) { 
            int width = currentImage.getWidth();
            int height = currentImage.getHeight(); 
            OFImage newImage = new OFImage(width/DOWNSCALE_FACTOR, height/DOWNSCALE_FACTOR); 
            int newWidth = newImage.getWidth();
            int newHeight = newImage.getHeight(); 
            for (int x = 0; x < newWidth; x++) {
                for (int y = 0; y < newHeight; y++) {
                Color pixel = currentImage.getPixel(x * DOWNSCALE_FACTOR, y * DOWNSCALE_FACTOR); 
                newImage.setPixel(x, y, pixel);
                }
            } 
            currentImage = newImage;
            imagePanel.setImage(currentImage);
            frame.pack(); 
        } 
    }
   
    // ---- swing stuff to build the frame and all its components ----

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        //Container contentPane = frame.getContentPane();
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(12,12,12,12));
        
        contentPane.setLayout(new BorderLayout(6,6));
        

        makeMenuBar(frame);
        
        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(6, 6));
        
        filenameLabel = new JLabel();
        contentPane.add(filenameLabel, BorderLayout.NORTH);

        imagePanel = new ImagePanel();

        imagePanel.setBorder(new EtchedBorder());
    

        contentPane.add(imagePanel, BorderLayout.CENTER);

        statusLabel = new JLabel(VERSION);
        contentPane.add(statusLabel, BorderLayout.SOUTH);
        
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0,1));

        smallButton = new JButton("Smaller");
            smallButton.addActionListener(e -> makeSmaller());
        toolbar.add(smallButton);
        smallButton.setEnabled(false);

        bigButton = new JButton("Bigger");
            bigButton.addActionListener(e -> makeLarger());
        toolbar.add(bigButton);
        bigButton.setEnabled(false);

        JPanel flow = new JPanel();
        flow.add(toolbar);

        contentPane.add(flow, BorderLayout.WEST);

        

        // building is done - arrange the components and show        
        showFilename(null);
        frame.pack();
        
        // center the frame on screen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);
        
        item = new JMenuItem("Open");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            item.addActionListener(e -> openFile());
        menu.add(item);

        item = new JMenuItem("Close");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, SHORTCUT_MASK));
            item.addActionListener(e -> close());
        menu.add(item);
        menu.addSeparator();
        
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(e -> quit());
        menu.add(item);


        // create the Filter menu
        menu = new JMenu("Filter");
        menubar.add(menu);
        
        for(Filter filter : filterList) {
            item = new JMenuItem(filter.getName());
            item.addActionListener(e -> applyFilter(filter));
            menu.add(item);
        }

        // create the Help menu
        menu = new JMenu("Help");
        menubar.add(menu);
        
        item = new JMenuItem("About ImageViewer...");
            item.addActionListener(e -> showAbout());
        menu.add(item);
    }
}