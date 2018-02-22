
import objectdraw.*;
import java.awt.*;
import java.util.Random;



/**
 * Erika Sklaver
 * Lab 2 - Lots of Squares
 * Section 2
 * 02/04/15
 * 
 * Allows the user to create and move numbered squares of random size and color in a canvas window 
 * and to print out information aboout the squares in an output window.
 * 
 *
 * 
 */
public class Events extends FrameWindowController {
private FilledRect rect;
private FramedRect outline;
//variable names for the square and outline of the square

private static final int MAX_COLOR_VALUE = 255;  
// colors are coded from 0-255

private Random generator;
// an object that generates random numbers

private int colorcode1; 
private int colorcode2;
private int colorcode3;
private Color color;
//variable names to allow random colors to be generated 

private int squareside;
private static final int MAX_SQUARE_SIDE = 170;
private static final int MIN_SQUARE_SIDE=30;
//constants and variables that allow random square sizes to be generated 
 
private int counter = 0; 
private Location numberloc; 
private Text counterDisplay; 
//variables to allow increasing numbers to appear in squares 

private int gap = 20; 
//allows the numbers to be in the bottom right corner


    public void begin() {
        //The following are executed when the program begins 
        
        resize (500,500);
        //makes the window 500 by 500 pixels

        generator= new Random ();
        //assign generator to a random object
       
    }

    public void onMousePress(Location point) {
        //The following are executed when the mouse is pressed 
        
        squareside = generator.nextInt(MAX_SQUARE_SIDE)+MIN_SQUARE_SIDE; 
        //creates random lengths of the sides of the square 
        rect = new FilledRect(point.getX()-(squareside/2),point.getY()-(squareside/2),squareside, squareside, canvas); 
        //draws filled squares
        outline = new FramedRect(point.getX()-(squareside/2),point.getY()-(squareside/2),squareside, squareside, canvas);
        //draws the black outline around the filled squares 
        
         
       
       colorcode1 = generator.nextInt(MAX_COLOR_VALUE); 
       colorcode2 = generator.nextInt(MAX_COLOR_VALUE);
       colorcode3 = generator.nextInt(MAX_COLOR_VALUE);
       //assigns each color code to a random number associated with a color 
       
       color = new Color (colorcode1, colorcode2, colorcode3);
       //generates one random color for a box using the 3 random number values 
       
         rect.setColor(color); 
         // each time a rectangle is created it is a new random color
         
         numberloc = new Location(point.getX()+(squareside/2-gap),point.getY()+(squareside/2-gap));
         //numberloc = new Location((3/4)*(squareside),(3/4)*(squareside));
         counter++;
         counterDisplay = new Text(counter, numberloc, canvas); 
         //a number will appear each time the mouse is clicked 
         
         System.out.println("Square " + counter + " has sides of " + squareside + " pixels and a color of (" +
         colorcode1 + ", " + colorcode2 + ", " + colorcode3 + ")");
         //gives information about the square's number, size and color in an output window 
 
    }

    

    public void onMouseEnter(Location point) {
        //The following are executed when the mouse enters the canvas
        
        System.out.println();
        System.out.println();
        System.out.println();
        //creates 3 blank lines 
       
    }

    public void onMouseExit(Location point) {
       //The following are executed when the mouse leaves the canvas  
       canvas.clear();
       //When the mouse leaves the canvas, the most recently drawn box disappears 
       counter = 0;
       //re-sets the counter 
        
    }

  

    public void onMouseDrag(Location dragpoint) {
        //The following are executed periodically while the mouse is being moved with its button depressed 
        
         rect.moveTo(dragpoint.getX()-(squareside/2),dragpoint.getY()-(squareside/2));
         outline.moveTo(dragpoint.getX()-(squareside/2),dragpoint.getY()-(squareside/2));
         //allows the first square to be dragged around the screen and "dropped off" when the mouse is released
         
         counterDisplay.moveTo(dragpoint.getX()+(squareside/2-gap),dragpoint.getY()+(squareside/2-gap));
         //allows the number in the square to be dragged around the screen with the square and "dropped off" with the 
         //square 
        
    }

}
