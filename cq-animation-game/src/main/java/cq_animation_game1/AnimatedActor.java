package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class AnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnimatedActor extends GravityActor
{
    private Animation animation = null;
    
   

    
    public AnimatedActor()
    {
        
        
    }

    public void act()
    {
       super.act();
       MayflowerImage d = animation.getNextFrame();
       setImage(d);
    }
    
    void setAnimation(Animation a)
    {
        animation = a;
        
    }
    
    
}

