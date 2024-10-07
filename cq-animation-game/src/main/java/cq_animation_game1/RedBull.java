package cq_animation_game1;
import mayflower.*;

public class RedBull extends Block
{
    public static boolean touchedRedBull;
    // tells RedBullPeter to run until finished
    public boolean touchedThisRedBull;
    // moves only the redbull can touched out of the way
    
    /**
     * Constructor for objects of class RedBull
     */
    public RedBull()
    {
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\redbull.png");
        touchedRedBull = false;
    }
        public void act()
    {
        
        if(!touchedThisRedBull && isTouching(Cat.class))
        {
            System.out.println("RedBull touched Cat");
            setPlace(99999999, 99999999);
            touchedRedBull = true;
            touchedThisRedBull = true;
            Mayflower.playMusic(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\sounds\\petersounds\\andifeel.mp3");
            
            
            
            
        }
        //System.out.println(touchedRedBull);
        if(touchedThisRedBull)
        {
            setPlace(99999999, 99999999);
            //touchedRedBull = true;
            //System.out.println("touchedRedBull");
            
            
            
            
        }
        
    }
        public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
    public static boolean getTouchedRedBull()
    {
        //System.out.println(touchedRedBull);  
        return touchedRedBull; 
          
    }
    public static void changeTouchedRedBull(boolean change)
    {
        touchedRedBull = change;
    }

}

