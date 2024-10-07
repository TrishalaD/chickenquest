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
    
    private MovableAnimatedActor actor;
    private int i;
    private int test;
    private int timer;
    public static boolean isHadoukenActive;
    public static boolean isRoadhouseActive;
    public static String newAction;
    private int frameDelay;
    private int frameTimer;
    private int j;
    
    public AnimatedActor()
    {
        i = 0;
        frameDelay = 2;
        frameTimer = 0;
        j = 0;
    }
    public boolean returnIsHadoukenActive()
    {
        return isHadoukenActive;
    }
    public void act()
    {
       super.act();
       // MayflowerImage d = animation.getNextFrame();
       // setImage(d);
       
        //System.out.println(animation);
        frameTimer++;

        
        if (animation != null) {
            if (isHadoukenActive)
            {
                if (frameTimer >= frameDelay)
                {
                    
                    //MayflowerImage d = animation.getNextFrame();
                    //setImage(d); 
                    if (i >= 0 && i < 4 && isHadoukenActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_0.png");
                    }
                    else if(i >= 4 && i < 8 && isHadoukenActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_1.png");
                    }
                    else if(i >= 8 && i < 12 && isHadoukenActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_2.png");
                        frameDelay = 4;
                    }
                    else if(i >= 12 && i < 16 && isHadoukenActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_3.png");
                        frameDelay = 2;
                    }
                    else if(i >= 16 && i < 20 && isHadoukenActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_4.png");
                    }
                    else if(i >= 20 && i < 24 && isHadoukenActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_5.png");
                        
                    }
                    
                    
                    
                    
                    
                    i++;

                    
                    if (i >= 24) 
                    {
                        isHadoukenActive = false; 
                        i = 0; 
                    }

                    
                    frameTimer = 0; 
                }
                
                }
                else if (isRoadhouseActive){
                frameDelay = 1;
                if (i >= 0 && i < 4 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_0.png");
                    }
                    else if(i >= 4 && i < 8 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_1.png");
                    }
                    else if(i >= 8 && i < 12 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_2.png");
                        
                    }
                    else if(i >= 12 && i < 16 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_3.png");
                        
                    }
                    else if(i >= 16 && i < 20 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_4.png");
                    }
                    else if(i >= 20 && i < 24 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_5.png");
                    }
                    else if(i >= 28 && i < 32 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_6.png");
                    }
                    else if(i >= 32 && i < 36 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_7.png");
                    }
                    else if(i >= 36 && i < 40 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_8.png");
                    }
                    else if(i >= 40 && i < 44 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_9.png");
                    }
                    else if(i >= 44 && i < 48 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_10.png");
                    }
                    else if(i >= 48 && i < 52 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_11.png");
                    }
                    else if(i >= 52 && i < 56 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_12.png");
                    }
                    else if(i >= 56 && i < 60 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_13.png");
                        Mayflower.playMusic(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\petersounds\\peterroadhouse.mp3");
                    }
                    else if(i >= 60 && i < 64 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_14.png");
                    }
                    else if(i >= 64 && i < 68 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_15.png");
                    }
                    else if(i >= 68 && i < 72 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_16.png");
                    }
                    else if(i >= 72 && i < 76 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_17.png");
                    }
                    else if(i >= 76 && i < 80 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_18.png");
                    }
                    else if(i >= 80 && i < 84 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_19.png");
                    }
                    else if(i >= 84 && i < 88 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_20.png");
                    }
                    else if(i >= 88 && i < 92 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_21.png");
                    }
                    else if(i >= 92 && i < 96 && isRoadhouseActive){
                        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_22.png");
                    }
                    
                    
                    
                i++;
                if (i >= 96) 
                    {
                        isRoadhouseActive = false; 
                        i = 0; 
                    }
                frameTimer = 0; 
                }
                else if (frameTimer >= frameDelay){
                    frameDelay = 2;
                    MayflowerImage d = animation.getNextFrame(); 
                setImage(d);
                frameTimer = 0; 
                }
            }
    }
    
    void setAnimation(Animation a)
    {
        animation = a;
        
    }
    
    public int getTimer()
    {
        return i;
    }
}