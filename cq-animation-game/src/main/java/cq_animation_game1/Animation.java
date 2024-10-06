package cq_animation_game1;

import mayflower.*;

public class Animation 
{
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    private int timer;
    private int leng;
    public Animation(int frameRate, String[] imageFiles, int len)
    {
        frames = new MayflowerImage[len];
        leng = len;
        for(int i = 0; i < len; i++)
        {
            frames[i] = new MayflowerImage(imageFiles[i]);
        }
        this.framerate = framerate;
        currentFrame = 0;
        timer = 0;
        
    }

    public int getFrameRate()
    {
        return framerate;
    }
    
    
    public MayflowerImage getNextFrame()
    {
        
        
        timer++;
        if(timer >= 5)
        {
            currentFrame++;
            timer = 0;
        }
        
        currentFrame %= leng;
        
        MayflowerImage d = frames[currentFrame];
        return d;
    }
    public void scaleSprite(int w, int h)
    {
        for(int i = 0; i < leng; i++)
        {
            frames[i].scale(w, h);
        }
    }
    
    public void setTransparencySprite(int percent)
    {
        for(int i = 0; i < leng; i++)
        {
            frames[i].setTransparency(percent);
        }
    }
    
    public void mirrorHorizontallySprite()
    {
        for(int i = 0; i < leng; i++)
        {
            frames[i].mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h)
    {
        for(int i = 0; i < leng; i++)
        {
            frames[i].crop(x,y,w,h);
        }
    }
}

