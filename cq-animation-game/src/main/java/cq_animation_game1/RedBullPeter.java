package cq_animation_game1;
import mayflower.*;

public class RedBullPeter extends Actor{
    private int frameDelay;
    private int frameTimer;
    private int i;
    private int ones;
    private int tens;
    private int hundreds;
    private MayflowerImage sprite;

    public RedBullPeter() {
        i = 0;
        frameDelay = 5;
        frameTimer = 0;
        ones = 0;
        tens = 0;
        hundreds = 0;
        
        sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterredbull\\frame_000_delay-0.1s.png");
        System.out.println("RedBullPeter was called");
    }

    public void act() {
        boolean touchedRedBull = RedBull.getTouchedRedBull();

        frameTimer++;
        if (touchedRedBull) {
            setPlace(0, 0);
            if (frameTimer >= frameDelay) {
                ones++;
                if (hundreds == 1 && tens == 5 && ones == 1) {
                    ones = 0;
                    tens = 0;
                    hundreds = 0;
                    System.out.println("done animation");
                    RedBull.changeTouchedRedBull(false);
                }
                if (ones == 10) {
                    ones = 0;
                    tens += 1;
                }
                if (tens == 10) {
                    tens = 0;
                    hundreds += 1;
                }
                sprite = new MayflowerImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\peterredbull\\frame_" + hundreds + tens + ones + "_delay-0.1s.png");
                sprite.scale(1920, 1080);
                setImage(sprite);
                frameTimer = 0; 
            }
        } else {
            setPlace(99999999, 99999999);
            sprite.scale(10,10);
        }
    }

    private void setPlace(int x, int y) {
        setLocation(x, y);
    }

    
}
