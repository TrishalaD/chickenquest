package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flag extends AnimatedActor
{
    private Animation flag;
    public Flag()
    {   
        String[] d = new String[5];
        for(int i = 0; i < d.length; i++)
        {
            d[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\flag\\0" + (i) + "_flag animation.png";
            
        }
        flag = new Animation(50, d, 5);
        setAnimation(flag);
    }
    
    public void act()
    {
        if(flag != null){            
            super.act();
        }
    }
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
}