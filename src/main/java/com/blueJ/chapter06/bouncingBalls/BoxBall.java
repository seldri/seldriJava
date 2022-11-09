package com.blueJ.chapter06.bouncingBalls;

//import java.awt.*;
import java.awt.Color;
//import java.awt.geom.*;
import java.util.Random;
import java.util.ArrayList;

public class BoxBall{

    private Random r1;
    private ArrayList<Color> colorList;
    //private final Rectangle2D.Double rectangle;
    //private Ellipse2D.Double circle;
    private Color color;

    private int xPosition;
    private int yPosition;
    private int diameter;
    
    private Canvas canvas;

    private int ySpeed = 1;
    private static final int GRAVITY = 3;
    private int ballDegradation = 2;

    private final int groundPosition;
    private final int leftWallPos;
    private final int rightWallPos;

    private boolean isMovingRight;

    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int groundPos, int leftWall, int rightWall, Canvas drawingCanvas){

        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        leftWallPos = leftWall;
        rightWallPos = rightWall;
        canvas = drawingCanvas;
        r1 = new Random();
        isMovingRight = r1.nextBoolean();

        //this.canvas = canvas;
        //this.color = color;

        /* r1 = new Random();
        colorList = new ArrayList<>();
        rectangle = new Rectangle2D.Double();
        this.groundPosition = groundPosition;
        rectangle.height = 100;
        rectangle.width = 100;
        rectangle.x = 75;
        rectangle.y = 75;
        canvas.setForegroundColor(java.awt.Color.BLACK);
        canvas.draw(rectangle);
        addColors(); */
    }

    public void draw(){
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    public void erase(){
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        ySpeed += GRAVITY;
        yPosition += ySpeed;
        //xPosition +=2;

        // check if it has hit the ground
        /* if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }*/

        //Check for ball direction
        if(isMovingRight){
            xPosition += 2;
        }   
        else{
            xPosition -= 2;
        }

        //Check if it has hit the wall
        if(xPosition <= leftWallPos){
            isMovingRight = true;
            xPosition = leftWallPos;
        }
        if(xPosition >= (rightWallPos - diameter)){
            isMovingRight = false;
            xPosition = rightWallPos - diameter;
        }

        //check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0){
            yPosition = (int) (groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation;
        }

        // draw again at new position
        draw();
    }    

    public int getyPosition(){
        return yPosition;
    }

    public int getDiameter(){
        return diameter;
    }

    public void addColors(){
        colorList.add(java.awt.Color.BLACK);
        colorList.add(java.awt.Color.BLUE);
        colorList.add(java.awt.Color.MAGENTA);
        colorList.add(java.awt.Color.CYAN);
        colorList.add(java.awt.Color.ORANGE);
        colorList.add(java.awt.Color.YELLOW);
        colorList.add(java.awt.Color.GREEN);
        colorList.add(java.awt.Color.GRAY);
    }
}