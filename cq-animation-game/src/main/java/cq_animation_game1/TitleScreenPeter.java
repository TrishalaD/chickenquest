package cq_animation_game1;
import mayflower.*;
public class TitleScreenPeter extends TitleScreen
{
    
    private int frameDelay;
    private int frameTimer;
    private int i;
    public MayflowerImage sprite;
    /**
     * Constructor for objects of class TitleScreenPeter
     */
    public TitleScreenPeter()
    {
        i = 0;
        frameDelay = 3;
        frameTimer = 0;
        //setLocation(0, 0);
        
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_09.png");
        sprite.scale(182, 262);
        setImage(sprite);
        //Mayflower.playMusic("sounds/petersounds/peterdance.mp3");
        
        
    }
    
    public void act()
    {
        //System.out.println(isTitleScreenActive);
        //System.out.println(i);
        frameTimer++;
        if(isTitleScreenActive)
        {
            if(frameTimer >= frameDelay)
            {
                if (i >= 0 && i < 4){
                    
                    frameDelay = 1;
                    sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_09.png");
                    sprite.scale(182, 262);
                    setImage(sprite);
                    }
                    else if(i >= 4 && i < 8){
                        //setImage("img/peterdance/frame_10.png");
                        frameDelay = 1;
                        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_10.png");
                        sprite.scale(182, 262);
                        setImage(sprite);
                    }
                    else if(i >= 8 && i < 12){
                        //setImage("img/peterdance/frame_11.png");
                        frameDelay = 2;
                        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_11.png");
                        sprite.scale(182, 262);
                        setImage(sprite);
                    }
                    else if(i >= 12 && i < 16){
                        //setImage("img/peterdance/frame_12.png");
                        frameDelay = 1;
                        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_12.png");
                        sprite.scale(182, 262);
                        setImage(sprite);
                    }
                    else if(i >= 16 && i < 20){
                        //setImage("img/peterdance/frame_13.png");
                        frameDelay = 1;
                        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_13.png");
                        sprite.scale(182, 262);
                        setImage(sprite);
                    }
                    else if(i >= 20 && i < 24){
                        //setImage("img/peterdance/frame_14.png");
                        frameDelay = 2;
                        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdance\\frame_14.png");
                        sprite.scale(182, 262);
                        setImage(sprite);
                    }
                
                i++;

                    
                if (i >= 24) 
                    {
                        
                        i = 0; 
                    }

                    
                frameTimer = 0; 
            }
        }
    }
    
    

}