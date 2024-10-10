package cq_animation_game1;

import mayflower.*;

public class Yarn extends Actor
{
    
    public Yarn()
    {
        MayflowerImage p = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\Tiles\\gem2.png");
        p.scale(100,100);
        setImage(p);
        //p.crop(10, 10, 60, 70);
    }
    
    public void act(){
      if (isTouching(Cat.class)){
          Object a = getOneIntersectingObject(Cat.class);
          Cat c = (Cat) a;
          World w = getWorld(); 
          w.removeObject(this);
          c.increaseScore( 1 );
          Mayflower.playMusic(System.getProperty("user.dir") + "\\src\\main\\resources\\sounds\\petersounds\\peterlaugh.mp3");

      }
    }
    
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
    }
    
}
