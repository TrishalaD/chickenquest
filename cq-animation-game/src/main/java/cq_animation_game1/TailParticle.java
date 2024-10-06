package cq_animation_game1;
import mayflower.*;

public class TailParticle extends Actor {
    private int lifeSpan;  // The lifespan of the tail particle
    //private int fadeSpeed; // How quickly it fades
    
    // Constructor to set lifespan and fade speed
    public TailParticle() {
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\bomb\\dot3.png");  // Replace with your projectile image path  // Replace with your comet image path

//        setImage("img/particle.png");  // Replace with a small faint image
        lifeSpan = 20;  // The particle will last for 20 frames
        //fadeSpeed = 10;  // Fade out by reducing the size and transparency
    }

    // Act method called every frame
    public void act() {
        lifeSpan--;
        // Slowly reduce transparency and shrink the particle
        getImage().setTransparency(Math.max(0, lifeSpan * 5)); // Fade out over time
        getImage().scale((int)(getImage().getWidth() * 0.95), (int)(getImage().getHeight() * 0.95)); // Shrink size

        // Remove particle when its lifespan is over
        if (lifeSpan <= 0) {
            getWorld().removeObject(this);
        }
    }
}
