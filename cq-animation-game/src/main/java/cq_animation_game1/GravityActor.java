package cq_animation_game1;

import mayflower.*;
import java.lang.Math;
/**
 * Write a description of class GravityActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GravityActor extends Actor
{
    private int yVelocity;
    private int xVelocity;
    private int ticky;
    private int tickx;
    private boolean canJump;
    private int howLongJump;
    private boolean touchingIce;
    public int defX;
    public int defY;
    /**
     * Constructor for objects of class GravityActor
     */
    public GravityActor()
    {
        yVelocity = 0;
        xVelocity = 0;
        ticky = 0;
        tickx = 0;
        canJump = false;
        howLongJump = 0;
        touchingIce = false;
    }

    public void act()
    {
        // int x = getX();
        // int y = getY();

        // if(ticky > 3)
        // {
            // yVelocity -= 2;
            
            // ticky = 0;
        // }
        
        // if(howLongJump > 0 && howLongJump < 15)
        // {
            // yVelocity = 8;
        // }
        
        // if(tickx > 4)
        // {
            
            // xVelocity = (int) xVelocity / 2;
            // tickx = 0;
        // }
        
        // ticky++;
        // if(Math.abs(yVelocity) > 1)
        // {
            // canJump = false;
        // }
        
        // tickx++;
        // setLocation(getX() + xVelocity, getY() + (yVelocity * -1));
        // if(isBlocked())
        // {
            // setLocation(getX(), getY() - yVelocity);
            // ticky = 0;
            // yVelocity = 0;
            // canJump = true;
            // if(isBlocked())
            // {
                // setLocation(getX(), getY() - 1);
                // if(isBlocked())
                // {
                    // setLocation(getX(), getY() - 1);
                    // if(isBlocked())
                    // {
                        // setLocation(getX(), getY() - 1);
                        // if(isBlocked())
                        // {
                            // setLocation(getX(), getY() - 1);
                            // if(isBlocked())
                            // {
                                // setLocation(getX(), getY() - 1);
                                // if(isBlocked())
                                // {
                                    // setLocation(getX(), getY() - 1);
            
                                // }
                            // }
                        // }
                    // }
                // }
            // }
        // }
        
    }
    
    public void yMovement()
    {
        int x = getX();
        int y = getY();
        touchingIce = false;
        if(ticky > 3)
        {
            yVelocity -= 2;
            
            ticky = 0;
        }
        
        if(howLongJump > 0 && howLongJump < 15)
        {
            yVelocity = 8;
        }
        
        if(tickx > 5)
        {
            
            xVelocity = (int) xVelocity / 2;
            tickx = 0;
        }
        
        ticky++;
        if(Math.abs(yVelocity) > 1)
        {
            canJump = false;
        }
        
        tickx++;
        setLocation(getX() + xVelocity, getY() + (yVelocity * -1));
        
        x = getX();
        y = getY();
        
        if(isBlocked() || isTouchingIce())
        {
            ticky = 0;
            
            canJump = true;
            ticky = 0;
            // if(isTouching(IceBlock.class))
            // {
                // touchingIce = true;
            if(touchIce())
            {
                canJump = false;
            }
            // }
            setLocation(getX(), getY() + yVelocity);
            x = getX();
            y = getY();
            if(touchingIce)
            {
                
            }
            defX = getX();
            defY = getY();
            touchingIce = isTouchingIce();
            setLocation(defX, defY);
            // setLocation(getX(), getY() - 3);
            // setLocation(getX() + 2, getY());
            // if(isTouching(IceBlock.class))
            // {
                // touchingIce = true;
            // }
            
            // setLocation(getX() - 4, getY());
            // if(isTouching(IceBlock.class))
            // {
                // touchingIce = true;
            // }
            
            // setLocation(getX() + 2, getY());
            
            
            // setLocation(x, y);
            
            if(!touchingIce)
            {
                
                yVelocity = 0;
            }
            else
            {
                
                canJump = false;
            }
            
            
            
            // if(isBlocked())
            // {
                // setLocation(getX(), getY() - 1);
                // if(isBlocked())
                // {
                    // setLocation(getX(), getY() - 1);
                    // if(isBlocked())
                    // {
                        // setLocation(getX(), getY() - 1);
                        // if(isBlocked())
                        // {
                            // setLocation(getX(), getY() - 1);
                            // if(isBlocked())
                            // {
                                // setLocation(getX(), getY() - 1);
                                // if(isBlocked())
                                // {
                                    // setLocation(getX(), getY() - 1);
            
                                // }
                            // }
                        // }
                    // }
                // }
            // }
            
            
            // setLocation(getX(), getY() - 1);
        }
        
    }
    
    

    public void setYVelocity(int amount)
    {
        yVelocity = amount;
    }
    
    public void setXVelocity(int amount)
    {
        xVelocity = amount;
    }
    
    public int getYVelocity()
    {
        return yVelocity;
    }
    
    public int getXVelocity()
    {
        return xVelocity;
    }
    
    public boolean getCanJump()
    {
        return canJump;
    }
    
    public int getJumpLength()
    {
        return howLongJump;
    }
    
    public void setJumpLength(int amount)
    {
        howLongJump = amount;
    }
    
    public void setCanJump(boolean amount)
    {
        canJump = amount;
    }
    
    
    public boolean isFalling()
    {
        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() + 1);
        ret = isBlocked();
        setLocation(getX(), getY() - 1);
        return !ret;
    }

    boolean isBlocked()
    {
        return isTouching(Block.class) || isTouching(IceBlock.class);
    }
    
    
    boolean touchIce()
    {
         return isTouching(IceBlock.class);
    }
    
    public boolean isTouchingIce()
    {
        boolean touched = false;
        setLocation(getX(), getY() - 6);
        
        setLocation(getX() + 6, getY());
        
        
        if(touchIce())
        {
            return true;
        }
        
        setLocation(getX() - 12, getY());
        if(touchIce())
        {
            return true;
        }
    
        
        setLocation(getX() + 6, getY());
        setLocation(getX(), getY() + 6);
        
        return touched;
        
    }
    
    public boolean isClimbRight()
    {
        setLocation(getX() + 15, getY());
        if(isTouching(Block.class))
        {
            setLocation(getX() - 15, getY());
            return true;
        }
        setLocation(getX() - 15, getY());
        return false;
    }
    
    public boolean isClimbLeft()
    {
        setLocation(getX() - 15, getY());
        if(isTouching(Block.class))
        {
            setLocation(getX() + 15, getY());
            return true;
        }
        setLocation(getX() + 15, getY());
        return false;
    }
    
    boolean isTouchingYarn()
    {
        return isTouching(Yarn.class);
    }
    
    boolean hasFinishedGame()
    {
        return isTouching(Flag.class);
    }
}