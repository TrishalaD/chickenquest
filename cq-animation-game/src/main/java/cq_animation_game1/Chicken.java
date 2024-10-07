package cq_animation_game1;
import mayflower.*;

public class Chicken extends Actor
{
    public int frame;
    public MayflowerImage sprite;
    private int x;
    private int y;
    /**
     * Constructor for objects of class Chicken
     */
    public Chicken()
    {
        frame = 0;
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\enemy\\tile021.png");
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\enemy\\tile021.png");
        sprite.scale(128, 128);
        setImage(sprite);
        System.out.println("HI22");
        x = 10;
        y = 0;
    }

    public void act()
    {
        frame++;
        // if(frame < 120)
        // {
            // setLocation(getX() + 1, getY());
        // }
        // else if(frame < 360)
        // {
            // setLocation(getX() - 1, getY());
        // }
        // else if(frame < 480)
        // {
            // setLocation(getX() + 1, getY());
        // }
        // else
        // {
            // frame = 0;   
        // }
        
        setLocation(getX() - 2, getY() + 2);
        if(getX() < 0)
        {
            setLocation(2000, getY());
        }
        
        if(getY() > 1200)
        {
            setLocation(getX(), 0);
        }
        if(isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld(); 
            w.removeObject(this);
            c.decreaseHealth(1);
        }
        if(isTouching(BeamLaser.class))
        {
            
            
            World w = getWorld(); 
            w.removeObject(this);
            
        }
        if(isTouching(RedBullPeter.class))
        {
            World w = getWorld(); 
            w.removeObject(this);
            
        }
    }
    
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
        
    }
}

