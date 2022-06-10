import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
                ball.move();
                ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void randomPlace(int amount){
        int ground = 400;
        Random r1 = new Random();
        HashSet<BouncingBall> ballSet = new HashSet<>(amount);
        for(int i = 0; i < amount; i++){
            ballSet.add(new BouncingBall(r1.nextInt(200), r1.nextInt(200), r1.nextInt(20),
            Color.BLUE, ground, myCanvas));
        }
        for(BouncingBall ball : ballSet){
            ball.draw();
        }
    }
    
       public void bounce(int amount)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        //Create HashSet with balls

        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.BLUE);
        colorList.add(Color.RED);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.CYAN);
        colorList.add(Color.ORANGE);
        colorList.add(Color.BLACK);
        colorList.add(Color.GREEN);

        Random r1 = new Random();

        //HashSet<BouncingBall> ballSet = new HashSet<>(amount);
        //for(int i = 0; i < amount; i++){
        //    int xPos = 50;
        //    int yPos = 50;
        //    int diam = 16;
        //    ballSet.add(new BouncingBall(xPos, yPos, diam, colorList.get(r1.nextInt(colorList.size())), ground, myCanvas));
        //    xPos = xPos + 10;
        //    yPos = yPos + 10;
        //    diam = diam + 4;
        //}
        
        HashSet<BouncingBall> ballSet = new HashSet<>(amount);
        for(int i = 0; i < amount; i++){
            ballSet.add(new BouncingBall(50 + (amount * 10), 50 + (amount * 15), 16 + (amount * 4), 
            colorList.get(r1.nextInt(colorList.size())), ground, myCanvas));
        }
        //create all the balls in the Set
        ballSet.forEach(BouncingBall :: draw);
        
        

        // create and show the balls
       // BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
       // ball.draw();
        // BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
      //  ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
    
            for(BouncingBall ball : ballSet){
                ball.move();
                if(ball.getXPosition() >= 550) {
                finished = true;
                }
            }
            // stop once ball has traveled a certain distance on x axis
        }
    }
}
