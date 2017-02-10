import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public boolean alive = true;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        // get the Player's location
        if(!alive) return;
        
        int x = getX();
        int y = getY();
        
        // Move the Player. The setLocation() method will move the Player to the new
        // x and y coordinates.
      
        if( Greenfoot.isKeyDown("right") ){
            setLocation(x+1, y);
        } else if( Greenfoot.isKeyDown("left") ){
            setLocation(x-1, y);
        } else if( Greenfoot.isKeyDown("down") ){
            setLocation(x, y+1);
        } else if( Greenfoot.isKeyDown("up") ){
            setLocation(x, y-1);
        } 
        
        removeTouching(Fruit.class);
        if(isTouching(Bomb.class)){
            alive = false;
        }
        
    }    
    
    public void setLocation(int x, int y){
        // has the user tried to move outside the bounds of the world?
        if(x < 0 || x > 19 || y < 0 || y > 19){
            // The user has tried to move outside the bounds of the world, so
            // we call the die() method which causes the Player to die.
            die();
        } else {
            // The user is trying to move within the bounds of the world. Run
            // the Actor class' own setLocation() method to move the Player.
            super.setLocation(x, y);
        }
    }
    public void die(){
        alive = false;
        setImage("dead_player.png");
    }
}
