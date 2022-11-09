package com.blueJ.chapter06.scribble;

import java.awt.Color;
import java.util.Random;


public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }
    
    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }
    
    public void drawTriangle(){
        Pen pen = new Pen();
        pen.setColor(java.awt.Color.GREEN);
        for(int i = 0; i < 3; i++){
            pen.move(80);
            pen.turn(240);
        }
    }
    
    public void drawPentagon(){
        Pen pen = new Pen();
        pen.setColor(java.awt.Color.BLUE);
        
        for(int i = 0; i < 5; i++){
            pen.move(50);
            pen.turn(-72);
        }
    }
    
    public void drawPolygon(int n){
        Pen pen = new Pen();
        pen.setColor(java.awt.Color.BLUE);
        
        for(int i = 0; i < n; i++){
            pen.move(50);
            pen.turn(360 / n);
        }
    }
    
    public void drawSpirale(){
        Pen pen = new Pen();
        pen.setColor(java.awt.Color.BLACK);
        pen.penUp();
        pen.moveTo(250, 200);
        pen.penDown();
        int amount = 10;
        for(int i = 0; i < 30; i++){
            pen.move(amount);
            pen.turn(90);
            amount += 10;
        }
    }
    
    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    public void drawPicture(){
        myCanvas.setForegroundColor(java.awt.Color.CYAN);
        myCanvas.fillCircle(50, 50, 50);
        myCanvas.setForegroundColor(java.awt.Color.RED);
        myCanvas.fillRectangle(100, 100, 40, 60);
        myCanvas.setForegroundColor(java.awt.Color.BLUE);
        myCanvas.fillCircle(150, 150, 50);
        myCanvas.setForegroundColor(java.awt.Color.MAGENTA);
        myCanvas.drawString("Hello World", 250, 250);
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
