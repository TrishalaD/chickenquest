package cq_animation_game1;
import mayflower.*;
import java.util.Random;

public class FallingComet extends Actor {
    private int speed;        // Speed of the comet's fall
    private int angle;        // Angle of descent for diagonal movement
    private Random random;

    // Constructor to set speed and angle of the falling comet
    public FallingComet(int speed, int angle) {
        this.speed = speed;
        this.angle = angle;
        random = new Random();
        
        // Set the comet image (make sure to have a suitable image for the comet)
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\bomb\\dot3.png");  // Replace with your projectile image path  // Replace with your comet image path
    }

    // Act method called in every frame
    public void act() {
        // Move the comet diagonally based on speed and angle
        int deltaX = (int)(speed * Math.cos(Math.toRadians(angle)));
        int deltaY = (int)(speed * Math.sin(Math.toRadians(angle)));
        setLocation(getX() + deltaX, getY() + deltaY);

        // Create a trailing particle effect behind the comet
        createTailEffect();

        // Remove the comet if it goes beyond the screen
        if (getY() > getWorld().getHeight() || getX() > getWorld().getWidth()) {
            getWorld().removeObject(this);
        }
    }

    // Method to create a comet tail effect
    private void createTailEffect() {
        // Create a fading tail particle and place it behind the comet
        TailParticle tail = new TailParticle();
        getWorld().addObject(tail, getX(), getY());
    }
}
