package cq_animation_game1;
import mayflower.*;
import java.util.Random;

public class FallingComet extends Actor {
    private int speed;        // Speed of the comet's fall
    private int angle;        // Angle for diagonal movement
    private Random random;

    // Constructor to set speed and angle of the falling comet
    public FallingComet(int speed, int angle) {
        this.speed = speed;
        this.angle = angle;
        random = new Random();
        
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\bomb\\dot3.png");
    }

    // Act method called in every frame
    public void act() {
        // Move the comet diagonally based on speed and angle
        int moveX = (int)(speed * Math.cos(Math.toRadians(angle)));
        int moveY = (int)(speed * Math.sin(Math.toRadians(angle)));
        setLocation(getX() + moveX, getY() + moveY);

        // Create a fading effect behind the comet
        createFadeEffect();

        // Remove the comet if it goes beyond the screen
        if (getY() > getWorld().getHeight() || getX() > getWorld().getWidth()) {
            getWorld().removeObject(this);
        }
    }

    // Method to create a comet tail effect
    private void createFadeEffect() {
        // Create a fading tail effect and place it behind the comet
        CometTail tail = new CometTail();
        getWorld().addObject(tail, getX(), getY());
    }
}