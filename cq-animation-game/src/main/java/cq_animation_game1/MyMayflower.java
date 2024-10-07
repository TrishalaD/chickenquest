package cq_animation_game1;

import mayflower.*;

public class MyMayflower extends Mayflower
{
    //Constructor
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Project1", 1920, 1080);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        World w =  new MyWorld(1);
        Mayflower.setWorld(w);
        
        
    }
    
    public void startGame()
    {
        World w =  new MyWorld(1);
        Mayflower.setWorld(w);
    }
    
    public void act()
    {
        
    }
}
