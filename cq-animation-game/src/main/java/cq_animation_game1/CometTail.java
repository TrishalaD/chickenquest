package cq_animation_game1;
import mayflower.*;

public class CometTail extends Actor {
    private int life;  // The lifespan of the tail
    
    // Constructor to set lifespan and fade speed
    public CometTail() {
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\animations\\bomb\\dot3.png");

        life = 20;  // The tail will last for 20 frames
    }

    // Act method called every frame
    public void act() {
        life--;
        // Slowly reduce transparency and shrink the comet tail
        getImage().setTransparency(Math.max(0, life * 5)); // Fade out over time
        getImage().scale((int)(getImage().getWidth() * 0.95), (int)(getImage().getHeight() * 0.95)); // Shrink size

        // Remove comet tail when its lifespan is over
        if (life <= 0) {
            getWorld().removeObject(this);
        }
    }
}