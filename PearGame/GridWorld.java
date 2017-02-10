import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class GridWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridWorld extends World
{
    private Random random = new Random();
    private int fruitPlaced = 0;
    /**
     * Constructor for objects of class GridWorld.
     * 
     */

    public GridWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20, 20, 30, true);
        
        // place a new Player in the middle
        addObject( new Player(), 1, 4 );
        placeFruit();
        placeBomb();
        placeBomb();
        placeBomb();
        placeBomb();
    }
    public void placeFruit(){
        // These two lines generate random numbers from 0 to 19. "random" is the random
        // number generator we created above.
        int x = random.nextInt(20);
        int y = random.nextInt(20);
    
        // Create a new Fruit object and set its location to the values generated above
        addObject( new Fruit(), x, y);
        fruitPlaced += 1;
    }
    public void placeBomb(){
        // These two lines generate random numbers from 0 to 19. "random" is the random
        // number generator we created above.
        int x = random.nextInt(20);
        int y = random.nextInt(20);
    
        // Create a new Fruit object and set its location to the values generated above
        addObject( new Bomb(), x, y);
    }
    public void act(){
        // check to see if we have a Fruit in the world
        if(getObjects(Fruit.class).size() == 0){
            // if there is no fruit we need to add one to our world and update our state
            // this runs the code that adds a new fruit into the world
            placeFruit();
        }
        // This shows the score, which is the number of fruit eated. This is always
        // one less than the number of fruit that have been placed in the world.
        showText("Score: " + (fruitPlaced - 1), 2, 19);
        Greenfoot.setSpeed(25 + (2*fruitPlaced));
    }

}
