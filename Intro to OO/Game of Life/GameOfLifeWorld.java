import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOfLifeWorld
 * 
 * This is a world in which the game of life takes place.
 * 
 * @author C Brooks-Prenger
 * @version v0.1.pre-video
 */
public class GameOfLifeWorld extends World
{

    /**
     * Create a GameOfLifeWorld and then populate it
     */
    public GameOfLifeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(50, 50, 10); 
        populateWorld();
    }
    
    /**
     * Populate the world with a set of "cells", one for each grid point.
     */    
    private void populateWorld() 
    {
        for (int i =0; i< getWidth(); i++) {
            for (int j=0; j<getHeight(); j++) {
                //create an object for each position
                Cell tempCell = new Cell( getBiasedRandomBoolean() );
                //Cell tempCell = new Cell();
                
                addObject (tempCell,i,j);

            }
        }
    }
    
    /**
     * Get a "biased" random boolean value
     * 
     * @return boolean value that biases more towards false than true.
     */ 
    private boolean getBiasedRandomBoolean() {
        
        if (Greenfoot.getRandomNumber(9) < 1) {
            return true;
        }
        return false;
    }
}
