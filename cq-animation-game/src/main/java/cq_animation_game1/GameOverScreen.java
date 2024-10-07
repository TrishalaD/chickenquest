package cq_animation_game1;

import mayflower.*;
import mayflower.*;
public class GameOverScreen extends Actor
{
    
    public boolean start;
    
    public GameOverScreen(){
        
        start = false;
        setImage(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\game-over.jpg");
    }
    
    public void act(){
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            start = true;
            System.out.println("HIi");
            
        }
        
    }
    
}
