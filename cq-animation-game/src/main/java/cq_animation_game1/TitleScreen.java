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
    public static boolean isTitleScreenActive;
    /**
     * Constructor for objects of class TitleScreen
     */
    public TitleScreen()
    {
        start = false;
        isTitleScreenActive = true;
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\Chicken Quest Title Screen.png");
    }

    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            start = true;
            isTitleScreenActive = false;
            System.out.println("HI");
            
        }
    }
    
    
}
