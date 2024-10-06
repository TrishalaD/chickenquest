package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class IceBlock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IceBlock extends Block
{
    // instance variables - replace the example below with your own
    
    public IceBlock()
    {
        // initialise instance variables
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\Tiles\\IceBlock.png");
    }
    
    public void act()
    {
        
    }
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
}
