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
	    private int healthCooldown;
	    public Cat() 
	    {
	        String[] d = new String[7];
	        for(int i = 0; i < (d.length); i++)
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

	        
	        
	        
	        
	        
	        // walkLeft.mirrorHorizontallySprite();
	        // idleLeft.mirrorHorizontallySprite();
	        // fallingLeft.mirrorHorizontallySprite();
	        
	        
	        // walkRight.scaleSprite(100, 115);
	        // idle.scaleSprite(100, 115);
	        // walkLeft.scaleSprite(100, 115);
	        // idleLeft.scaleSprite(100, 115);
	        // fallingRight.scaleSprite(100, 115);
	        // fallingLeft.scaleSprite(100, 115);
	        
	        walkRight.scaleSprite(68, 114);
	        idle.scaleSprite(88, 109);
	        walkLeft.scaleSprite(68, 113);
	        idleLeft.scaleSprite(88, 109);
	        fallingRight.scaleSprite(85, 110);
	        fallingLeft.scaleSprite(85, 110);
	        
	        // walkRight.scaleSprite(68, 115);
	        // idle.scaleSprite(88, 115);
	        // walkLeft.scaleSprite(68, 115);
	        // idleLeft.scaleSprite(88, 115);
	        // fallingRight.scaleSprite(85, 115);
	        // fallingLeft.scaleSprite(85, 115);
	        
	        

	        setWalkRightAnimation(walkRight);
	        setIdleAnimation(idle);
	        setWalkLeftAnimation(walkLeft);
	        setIdleLeftAnimation(idleLeft);
	        setFallLeftAnimation(fallingLeft);
	        setFallRightAnimation(fallingRight);
	        score = 0;
	        health = 5;
	    }
	    public void act()
	    {
	        super.act();
	        //MayflowerImage d = walk.getNextFrame();
	        //setImage(d);
	        // Damage flag to ensure health is reduced only once per frame
	        
	        if (healthCooldown > 0) {
	            healthCooldown--;
	        }

	        // Only apply damage if cooldown has reached 0 (i.e., no cooldown)
	        if (healthCooldown == 0) {
	            // Check if the cat is touching a comet or tail particle
	            if (isTouching(FallingComet.class)) {
	                decreaseHealth(1);  // Reduce health by 10 for touching the comet
	                healthCooldown = 30;  // Set cooldown (e.g., 30 frames)
	            } else if (isTouching(TailParticle.class)) {
	                decreaseHealth(1);;  // Reduce health by 5 for touching tail particles
	                healthCooldown = 30;  // Set cooldown (e.g., 30 frames)
	            }
	        }
	    }
	    
	    private int score()
	    {
	        score += 1;
	        return score;
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
	    
	    private void updateText()
	    {
	        World w = getWorld();
	        w.removeText(10, 30);
	        w.showText("Score: " + score + " Health: " + health, 10, 30, Color.BLACK);
	    }
	    
	}

