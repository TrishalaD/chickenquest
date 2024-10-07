package cq_animation_game1;

import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation idle;
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation fallingRight;
    private Animation fallingLeft;
    private int score;
    private int health;
    private Animation hadouken;
    private Animation roadhouse;
    private Animation climbRight;
    private Animation climbLeft;
    private int healthCooldown;
    public Cat() 
    {
        
        score=0;
        health=10;
        
        
        String[] d = new String[7];
        for(int i = 0; i < d.length; i++)
        {
            d[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterwalkforward\\frame_" + (i+1) + ".png";
            
        }
        walkRight = new Animation(50, d, 7);
        String[] e = new String[4];
        for(int i = 0; i < e.length; i++)
        {
            e[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peteridle\\frame_" + (i) + ".png";
            
        }
        idle = new Animation(50, e, 4);
        String[] g = new String[10];
        for(int i = 0; i < e.length; i++)
        {
            g[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peteridle\\frame_" + (i) + ".png";
            
        }
        idleLeft = new Animation(50, g, 4);
        String[] f = new String[7];
        for(int i = 0; i < f.length; i++)
        {
            f[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterwalkbackward\\frame_"+ (i+1) + ".png";
            
        }
        walkLeft = new Animation(50, f, 7);
        
        
        String[] h = new String[2];
        for(int i = 0; i < h.length; i++)
        {
            h[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterfall\\frame_" + (i) + ".png";
            
        }
        fallingRight = new Animation(50, h, 2);
        
        String[] l = new String[2];
        for(int i = 0; i < l.length; i++)
        {
            l[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterfall\\frame_" + (i) + ".png";
            
        }
        fallingLeft = new Animation(50, l, 2);

        
        String[] j = new String[5];
        for(int i = 0; i < j.length; i++) {
            j[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterhadouken\\frame_" + (i) + ".png";
            
        }
        hadouken = new Animation(1, j, 2);
        
        String[] k = new String[2];
        for(int i = 0; i < k.length; i++) {
            k[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterclimb\\peterclimb" + (i + 1) + ".png";
            
        }
        climbRight = new Animation(1, k, 2);
        
        String[] q = new String[2];
        for(int i = 0; i < q.length; i++) {
            q[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterclimb\\peterclimb" + (i + 1) + ".png";
            
        }
        climbLeft = new Animation(1, q, 2);
        
        
        // String[] k = new String[22];
        // for(int i = 0; i < k.length; i++) {
            // k[i] = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterroadhouse\\frame_" + (i) + ".png";
            
        // }
        // roadhouse = new Animation(1, k, 22);
        
        
        
        // walkLeft.mirrorHorizontallySprite();
        // idleLeft.mirrorHorizontallySprite();
        // fallingLeft.mirrorHorizontallySprite();
        
        
        // walkRight.scaleSprite(100, 115);
        // idle.scaleSprite(100, 115);
        // walkLeft.scaleSprite(100, 115);
        // idleLeft.scaleSprite(100, 115);
        // fallingRight.scaleSprite(100, 115);
        // fallingLeft.scaleSprite(100, 115);
        hadouken.scaleSprite(113, 111);
        walkRight.scaleSprite(68, 114);
        idle.scaleSprite(88, 109);
        walkLeft.scaleSprite(68, 113);
        idleLeft.scaleSprite(88, 109);
        fallingRight.scaleSprite(85, 110);
        fallingLeft.scaleSprite(85, 110);
        climbRight.scaleSprite(68, 114);
        climbLeft.scaleSprite(68, 114);
        // walkRight.scaleSprite(68, 115);
        // idle.scaleSprite(88, 115);
        // walkLeft.scaleSprite(68, 115);
        // idleLeft.scaleSprite(88, 115);
        // fallingRight.scaleSprite(85, 115);
        // fallingLeft.scaleSprite(85, 115);
        
        
        setHadoukenAnimation(hadouken);
        setWalkRightAnimation(walkRight);
        setIdleAnimation(idle);
        setWalkLeftAnimation(walkLeft);
        setIdleLeftAnimation(idleLeft);
        setFallLeftAnimation(fallingLeft);
        setFallRightAnimation(fallingRight);
        setClimbRightAnimation(climbRight);
        setClimbLeftAnimation(climbLeft);
        climbLeft.mirrorHorizontallySprite();
        
    }
    public void act()
    {
        super.act();
        
        if (healthCooldown > 0) {
                healthCooldown--;
            }

            // Only apply damage if cooldown has reached 0 (i.e., no cooldown)
            if (healthCooldown == 0) {
                // Check if the cat is touching a comet or tail particle
                if (isTouching(FallingComet.class)) {
                    decreaseHealth(1);  // Reduce health by 10 for touching the comet
                    healthCooldown = 30;  // Set cooldown (e.g., 30 frames)
                } else if (isTouching(CometTail.class)) {
                    decreaseHealth(1);;  // Reduce health by 5 for touching tail particles
                    healthCooldown = 30;  // Set cooldown (e.g., 30 frames)
                }
            }
        //MayflowerImage d = walk.getNextFrame();
        //setImage(d);
    }
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Health: " + health, 10, 30, Color.BLACK);
    }
    private int health()
    {
        health -= 1;
        return health;
    }
    public void increaseScore(int amount)
    {
        score += amount;
        updateText();
    }
    
    public void decreaseHealth(int count)
    {
        health -= count;
        updateText();
    }
    public int getScore()
    {
        return score;
    }
    
    public int getHealth()
    {
        return health;
    }
    private int score()
    {
        score += 1;
        return score;
    }
}
