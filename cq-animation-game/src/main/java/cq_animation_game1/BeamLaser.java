package cq_animation_game1;
import mayflower.*;

public class BeamLaser extends Actor
{
    // instance variables - replace the example below with your own

    MouseInfo mouseInfo = Mayflower.getMouseInfo();
    public int xVol;
    public int yVol;
    public int xPos;
    public int yPos;
    public MayflowerImage sprite;
    /**
     * Constructor for objects of class BeamLaser
     */
    public BeamLaser()
    {
        // initialise instance variables
        
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\enemy\\lazer1.png");
        sprite.scale(128, 128);
        setImage(sprite);
        xVol =  0;
        yVol =  0;
        
        
        
        
    }

    public void act()
    {
        setLocation(getX() + (xVol / 2), getY() - yVol);
        xVol ++;
        if(isTouching(Chicken.class))
        {
            
            // World w = getWorld(); 
            // w.removeObject(this);
            
        }
    }
}
