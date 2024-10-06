package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    private int[] connections;
    private MayflowerImage sprite;
    public Block()
    {
        connections = new int[4];
        // initialise instance variables
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\Tiles\\block1111-.png");
        sprite.scale(128, 128);
        setImage(sprite);
    }
    
    public void act()
    {
        
    }
    public void setPlace(int x, int y)
    {
        setLocation(x, y);
        
        
    }
    
    public void connect(int id, int val)
    {
        connections[id] = val;
    }
    
    public void updateConnect()
    {
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\Tiles\\block" + ((connections[0] + 1) % 2) + ((connections[1] + 1) % 2)  + ((connections[3] + 1) % 2) + ((connections[2] + 1) % 2) + "-.png");
        sprite.scale(128, 128);
        setImage(sprite);
    }
}

