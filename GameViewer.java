
/**
 * Controls the drawing of the board and game play. 
 * Allows the human player to make goat moves.
 * Calls AIplayer to make tiger moves.
 *
 * @Student 1 Name: 
 * @Student 1 Number: 
 * 
 * @Student 2 Name: 
 * @Student 2 Number: 
 */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.SwingUtilities;

public class GameViewer implements MouseListener
{
    // instance variables
    private int bkSize; // block size - all other measurements to be derived from bkSize
    private int brdSize; // board size
    private SimpleCanvas sc; // an object of SimpleCanvas to draw 
    private GameRules rules; // an object of GameRules
    private Board bd; // an object of Board
    private AIplayer ai; //an object of AIplayer
    
    // 2D coordinates of valid locations on the board in steps of block size                                  
    public static final int[][] locs = {{1,1},                  {4,1},                  {7,1},
    
                                                {2,2},          {4,2},          {6,2},
                                                
                                                        {3,3},  {4,3},  {5,3}, 
                                                        
                                        {1,4},  {2,4},  {3,4},          {5,4},  {6,4},  {7,4},
                                        
                                                        {3,5},  {4,5},  {5,5},
                                                        
                                                {2,6},          {4,6},          {6,6},        
                                        
                                        {1,7},                  {4,7},                  {7,7} };
                                 
    // source and destination for the goat moves                             
    private int[] mov = {-1,-1}; //-1 means no selection

    /**
     * Constructor for objects of class GameViewer
     * Initializes instance variables and adds mouse listener.
     * Draws the board.
     */
    public GameViewer(int bkSize)
    {        
        this.bkSize = bkSize;
        brdSize = bkSize*8;
        sc = new SimpleCanvas("Tigers and Goats", brdSize, brdSize, Color.BLUE);
        sc.addMouseListener(this);           
        rules = new GameRules();
        bd = new Board();
        ai = new AIplayer();              
        drawBoard();                      
    }
    
    /**
     * Constructor with default block size
     */
    public GameViewer( )
    {
        this(80);
    }
    
    /**
     * Draws the boad lines and the pieces as per their locations.
     * Drawing of lines is provided, students to implement drawing 
     * of pieces and number of goats.
     */
    private void drawBoard()
    {
        sc.drawRectangle(0,0,brdSize,brdSize,Color.BLUE); //wipe the canvas
        
        //draw shadows of Goats and Tigers - not compulsory, for beauty only /////////////
        
        //////////////////////////////////////////////////////                
        // Draw the lines
        for(int i=1; i<9; i++)
        {
            //draw the red lines
            if(i<4)
                sc.drawLine(locs[i-1][0]*bkSize, locs[i-1][1]*bkSize,
                        locs[i+5][0]*bkSize, locs[i+5][1]*bkSize, Color.red);
            else if(i==4)
                sc.drawLine(locs[i+5][0]*bkSize, locs[i+5][1]*bkSize,
                        locs[i+7][0]*bkSize, locs[i+7][1]*bkSize, Color.red);
            else if(i==5)
                sc.drawLine(locs[i+7][0]*bkSize, locs[i+7][1]*bkSize,
                        locs[i+9][0]*bkSize, locs[i+9][1]*bkSize, Color.red);              
            else
                sc.drawLine(locs[i+9][0]*bkSize, locs[i+9][1]*bkSize,
                        locs[i+15][0]*bkSize, locs[i+15][1]*bkSize, Color.red);              
           
            if(i==4 || i==8) continue; //no more to draw at i=4,8
            // vertical white lines
            sc.drawLine(i*bkSize, i*bkSize,
                        i*bkSize, brdSize-i*bkSize,Color.white);            
            // horizontal white lines
            sc.drawLine(i*bkSize,         i*bkSize,
                        brdSize-i*bkSize, i*bkSize, Color.white);  
            
        }
        
        // TODO 10 
        // Draw the goats and tigers. (Drawing the shadows is not compulsory)
        // Display the number of goats        
        
    }
    
    /**
     * If vacant, place a goat at the user clicked location on board.
     * Update goat count in rules and draw the updated board
     */
    public void placeGoat(int loc) 
    {
        //Figure out way to reverse engineer location to coordinate on board
        //
        //TODO 2
        //If vacant location then place else error
        int cordX = (locs[loc][0]) * bkSize;
        int cordY = (locs[loc][1]) * bkSize;

        System.out.println("Location to coord X: " + cordX);

        if (bd.isVacant(loc)) {
            sc.drawDisc(cordX, cordY, 25, Color.GREEN);
            bd.setGoat(loc);
            rules.addGoat(1);
        } else {
            System.out.println("Already occupied by goat");
        }
                                
    }
    
    /**
     * Calls the placeTiger method of AIplayer to place a tiger on the board.
     * Increments tiger count in rules.
     * Draws the updated board.
     */
    public void placeTiger() 
    {   
        //TODO 13
               
    }
    
    /**
     * Toggles goat selection - changes the colour of selected goat.
     * Resets selection and changes the colour back when the same goat is clicked again.
     * Selects destination (if vacant) to move and calls moveGoat to make the move.
     */
    public void selectGoatMove(int loc) 
    {   
        //TODO 16
        
    }
    
    /**
     * Make the user selected goat move only if legal otherwise set the destination to -1 (invalid).
     * If did make a goat move, then update board, draw the updated board, reset mov to -1,-1.
     * and call tigersMove() since after every goat move, there is a tiger move.
     */
    public void moveGoat() 
    {   
        //TODO 18        
        
    }
 
    /**
     * Call AIplayer to make its move. Update and draw the board after the move.
     * If Tigers cannot move, display "Goats Win!".
     * If goats are less than 6, display "Tigers Win!".
     * No need to terminate the game.
     */
    public void tigersMove()
    {
        //TODO 20
                                
    }
        
    /**
     * Respond to a mouse click on the board. 
     * Get a valid location nearest to the click (from GameRules). 
     * If nearest location is still far, do nothing. 
     * Otherwise, call placeGoat to place a goat at the location.
     * Call this.placeTiger when it is the tigers turn to place.
     * When the game changes to move stage, call selectGoatMove to move 
     * the user selected goat to the user selected destination.
     */
    public void mousePressed(MouseEvent e) 
    {
        //TODO 1
        // Check where we clicked nearest location
        int x = e.getX();
        int y = e.getY();

        System.out.println("X: " + x + " Y: " + y);

        int loc = rules.nearestLoc(x, y, this.bkSize);

        if (loc != -1) {
            placeGoat(loc);
        }
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}