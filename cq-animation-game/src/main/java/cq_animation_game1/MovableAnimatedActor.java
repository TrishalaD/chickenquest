package cq_animation_game1;

import mayflower.*;
/**
 * Write a description of class MovableAnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovableAnimatedActor extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private int x;
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private String currentAction;
    private String newAction;
    private String direction;
    private Animation fallingRight;
    private Animation fallingLeft;
    private int yVelocity;
    private boolean isJumpingHigher;
    public MayflowerImage hitbox;
    /**
     * Constructor for objects of class MovableAnimatedActor
     */
    public MovableAnimatedActor()
    {
        // initialise instance variables
        x = 0;
        direction = "right";
        yVelocity = 0;
        isJumpingHigher = false;
        hitbox = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterwalkforward\\Hitbox.png");
        
    }

    public void act()
    {

        newAction = null;
        if(currentAction == null)
        {
            newAction = "idle";
        }
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if(Mayflower.isKeyDown(Keyboard.KEY_UP) && Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && super.getCanJump())
        {
            newAction = "fallRight";
            direction = "right";
            isJumpingHigher = true;
            super.setYVelocity(8);
            super.setCanJump(false);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && Mayflower.isKeyDown(Keyboard.KEY_LEFT) && super.getCanJump())
        {
            newAction = "fallLeft";
            direction = "left";
            isJumpingHigher = true;
            super.setYVelocity(8);
            super.setCanJump(false);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && super.getCanJump())
        {
            isJumpingHigher = true;
            if(direction != null && direction.equals("left"))
            {
                newAction = "fallLeft";
            }
            else
            {
                newAction = "fallRight";
            }
            super.setYVelocity(8);
            super.setCanJump(false);
        }
        // else if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
        // {
            // newAction = "walkRight";
            // direction = "right";
            // // setLocation(x + 1, y);
            // super.setXVelocity(super.getXVelocity() + 1);
            // if(isTouching(Block.class))
            // {
                // super.setXVelocity(super.getXVelocity() * -1);
                // super.setXVelocity(0);
            // }
        // }
        // else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        // {
            // newAction = "walkLeft";
            // direction = "left";
            
            // // setLocation(x - 1, y);
            // super.setXVelocity(super.getXVelocity() - 1);
            // if(isTouching(Block.class))
            // {
                // super.setXVelocity(super.getXVelocity() * -1);
                // super.setXVelocity(0);
            // }
        // }
        
        // else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) &&  y + h < 600)
        // {
        // // setLocation(x, y + 1);
        // }
        
        
        else
        {
            newAction = "idle";
            if(direction != null && direction.equals("left"))
            {
                newAction = "idleLeft";
            }
            if(!getCanJump())
            {
                if(direction != null && direction.equals("left"))
                {
                    newAction = "fallLeft";
                }
                else
                {
                    newAction = "fallRight";
                }
            }
        }
        
        super.yMovement();
        xMovement();
        if(!getCanJump())
        {
            if(direction != null && direction.equals("left"))
            {
                newAction = "fallLeft";
            }
            else
            {
                newAction = "fallRight";
            }
        }
        if(!newAction.equals(currentAction) && newAction != null)
        {

            if(newAction.equals("idle"))
            {
                currentAction = newAction;
                setAnimation(idle);
            }
            else if(newAction.equals("idleLeft"))
            {
                currentAction = newAction;
                setAnimation(idleLeft);
            }
            else if(newAction.equals("walkRight"))
            {
                currentAction = newAction;
                setAnimation(walkRight);
            }
            else if(newAction.equals("walkLeft"))
            {
                currentAction = newAction;
                setAnimation(walkLeft);
            }
            else if(newAction.equals("fallRight"))
            {
                currentAction = newAction;
                setAnimation(fallingRight);
            }
            else if(newAction.equals("fallLeft"))
            {
                currentAction = newAction;
                setAnimation(fallingLeft);
            }
        }
        
        if(Mayflower.isKeyDown(Keyboard.KEY_UP) && isJumpingHigher)
        {
            
            
            super.setJumpLength(super.getJumpLength() + 1);
            
        }
        else
        {
            isJumpingHigher = false;
            super.setJumpLength(0);
        }
          
        super.act();
    }

    public void xMovement()
    {
        
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
        {
            newAction = "walkRight";
            direction = "right";
            // setLocation(x + 1, y);
            super.setXVelocity(super.getXVelocity() + 1);
            
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        {
            newAction = "walkLeft";
            direction = "left";
            
            // setLocation(x - 1, y);
            super.setXVelocity(super.getXVelocity() - 1);
            
        }
        if(isTouching(Block.class) || isTouching(IceBlock.class))
        {
            
            setLocation(getX() - super.getXVelocity(), getY());
            for(int i = 0; i < 3; i++)
            {
                if(isTouching(IceBlock.class))
                {
                    setLocation(getX() - super.getXVelocity() * 2, getY());
                }
                else if(isTouching(Block.class))
                {
                    setLocation(getX() - super.getXVelocity(), getY());
                }
                
            }
            
            super.setXVelocity(0);
        }
    }
    
    
    
        
    void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }

    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
        walkRight.setBounds(0, 0, 68, 109);
        super.setAnimation(ani);
    }

    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
        idle.setBounds(0, 0, 88, 109);
        super.setAnimation(ani);
    }

    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
        walkLeft.setBounds(0, 0, 68, 109);
        super.setAnimation(ani);
    }

    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
        idleLeft.setBounds(0, 0, 88, 109);
        super.setAnimation(ani);
    }

    public void setFallLeftAnimation(Animation ani)
    {
        fallingLeft = ani;
        fallingLeft.setBounds(0, 0, 85, 109);
        super.setAnimation(ani);
    }

    public void setFallRightAnimation(Animation ani)
    {
        fallingRight = ani;
        fallingRight.setBounds(0, 0, 85, 109);
        super.setAnimation(ani);
    }
}

