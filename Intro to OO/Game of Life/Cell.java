import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; //So that I can use the list class

/**
 * Conway's Game of Life Cell
 * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any live cell with more than three live neighbours dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 * 
 * @author C Brooks-Prenger 
 * @version 0.1.pre-video
 */
public class Cell extends Actor
{
    private boolean firstRun = true;
    private boolean living = true;
    private List neighbours;

    /**
     * Create a Cell with the default state (true)
     */
    public Cell() {
        //constructor
        showState();
    }
    
    /**
     * Create a Cell with the given state
     * 
     * @param boolean state to which the cell should initially be set
     */    
    public Cell(boolean status) {
        //constructor
        living = status;
        showState();
    }
    
     
    
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (firstRun) {
            //things to do only once
            neighbours = getNeighbours(1,true,Cell.class);
            firstRun = false;
        }
        
        // Add your action code here.
        living = checkNextState();
        showState();
    }
    
    /**
     * Hide or unhide based on if the cell is "living"
     */
    private void showState() 
    {
        if (living) {
            setImage("ant.png");
        }else {
            setImage("deadAnt.png");
        }
    }
 
    /**
     * Check to see what the state would be in the next round.
     */
    private boolean checkNextState() 
    {
        //getNeighbours returns a list of all the other classes around it in the world
        //We will talk about Lists in the future
        int numberNeighboursLiving = 0;
        for (Object neighbour : neighbours) {
            Cell adjacentCell = (Cell)neighbour;
            if (adjacentCell.getState()) {
                numberNeighboursLiving++;
            }
        }
        
        
        if (living) {
            //* Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
            if ( numberNeighboursLiving < 2 ) {
                return false;
            }
            //* Any live cell with two or three live neighbours lives on to the next generation.
            else if ( numberNeighboursLiving <= 3 ) {
                return true;
            }
             //* Any live cell with more than three live neighbours dies, as if by overpopulation.
            else {
                return false;
            }
            //Note: There is a more efficent way I could have coded the above section, do you see how?
        }
        else { //Cell is dead
             //* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
             if (numberNeighboursLiving == 3) {
                 return true;
             }
        }
        
        return false;
    }
    
    /**
     * Returns the current state of the cell
     * 
     * @return boolean the current state of the cell
     */
    public boolean getState() 
    {
        return living;
    }
    
    /**
     * Flips the current state value
     */
    public void flipState()
    {
        living = !living;
        showState();
    }
}
