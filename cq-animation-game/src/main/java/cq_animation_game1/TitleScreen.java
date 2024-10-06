package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class TitleScreen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TitleScreen extends Actor
{
    public boolean start;
    /**
     * Constructor for objects of class TitleScreen
     */
    public TitleScreen()
    {
        start = false;
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\Chicken Quest Title Screen.png");
    }

    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            start = true;
            System.out.println("HI");
            
        }
    }
    
    
}
