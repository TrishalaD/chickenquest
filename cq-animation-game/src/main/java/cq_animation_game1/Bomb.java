package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bomb extends AnimatedActor
{
    private Animation bomb;
    public Bomb()
    {            
        String[] d = new String[1];
        for(int i = 0; i < d.length; i++)
        {
            d[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\bomb\\" + (i+1) + "_explosion.png";            
        }
        bomb = new Animation(50, d, 1);
        setAnimation(bomb);
        bomb.setBounds(100, 100, 200, 200);
        
    }
    
    public void act()
    {    	
        if(bomb != null){
            super.setCanJump(false);
            super.setYVelocity(5);
            super.yMovement();
            super.act();
            
            if(isTouching(Cat.class)) {
            	Object a = getOneIntersectingObject(Cat.class);
            	Cat c = (Cat) a;
                World w = getWorld();
                w.removeObject(this);
                c.decreaseHealth(1);
                Explosion explosion = new Explosion();
                w.addObject(explosion, c.getX(), c.getY()-100);
                explosion.act();
            }
            else if(isTouching(Actor.class)) {
            	Object a = getOneIntersectingObject(Actor.class);
            	Actor c = (Actor) a;
            	World w = getWorld();
                w.removeObject(this);
                Explosion explosion1 = new Explosion();
                w.addObject(explosion1, c.getX(), c.getY()-200);
                explosion1.act();
			} 
          }
    }
    
    public Object getTouchingActor() {
    	Object a = null;
    	if(isTouching(Actor.class)) {
    		a = getOneIntersectingObject(Actor.class);    		
    	}
    	return a;
    }
    
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
}
