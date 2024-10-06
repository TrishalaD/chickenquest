package cq_animation_game1;

import mayflower.*;

public class RockBlock extends Block
{
    // instance variables - replace the example below with your own
    
    public RockBlock()
    {
        // initialise instance variables
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\Tiles\\rock.jpg");
    }
    
    public void act()
    {
        
    }
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
}
