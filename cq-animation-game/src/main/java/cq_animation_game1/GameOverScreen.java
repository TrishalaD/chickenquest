package cq_animation_game1;

import mayflower.*;
public class GameOverScreen extends Actor
{
    
    public boolean start;
    private int frameDelay;
    private int frameTimer;
    private int i;
    private int ones;
    private int tens;
    private int hundreds;
    private MayflowerImage sprite;
    
    public GameOverScreen(){
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdeath\\ezgif-frame-001.png");
        Mayflower.playMusic(System.getProperty("user.dir") + "\\src\\main\\resources\\sounds\\petersounds\\death.mp3");
        start = true;
        //setImage(sprite);
        frameDelay = 5;
        frameTimer = 0;
        ones = 0;
        tens = 0;
        hundreds = 0;
    }
    
    public void act(){
        System.out.println(ones);
        frameTimer++;
        if (start) {
            setPlace(0, 0);
            if (frameTimer >= frameDelay) {
                
                if (hundreds == 1 && tens == 4 && ones == 9) {
                    //ones = 0;
                    //tens = 0;
                    //hundreds = 0;
                    //System.out.println("done animation");
                    //start = false;
                }
                else{
                    ones++;
                }
                if (ones == 10) {
                    ones = 0;
                    tens += 1;
                }
                if (tens == 10) {
                    tens = 0;
                    hundreds += 1;
                }
                sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterdeath\\ezgif-frame-" + hundreds + tens + ones + ".png");
                sprite.scale(1920, 1080);
                setImage(sprite);
                frameTimer = 0; 
            }
        } 
    }
    private void setPlace(int x, int y) {
        setLocation(x, y);
    }
}