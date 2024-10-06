package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Explosion extends AnimatedActor
{
    private Animation explosion;
    private int timer = 0;
    
    
    public Explosion()
    {               
        String[] d = new String[12];
        for(int i = 0; i < d.length; i++)
        {
            d[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\bomb\\" + (i+12) + "_explosion.png";
        }
        explosion = new Animation(50, d, 12);
        setAnimation(explosion);
        
    }
    
    public void act()
    {    	
//    	if(explosion != null){
//            super.setCanJump(false);
//            super.act();
//    	}
//    	if(timer > 20 ) {  
//        	World w = getWorld();
//            w.removeObject(this);
//    		timer = 0;
//    	}
//    	timer++;
    	
    }
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
}
