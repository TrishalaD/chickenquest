package cq_animation_game1;

import mayflower.*;
import java.util.Random;

public class MyWorld extends World 
{

    private Cat cat;
    private GameOverScreen gameOver;
    private YouWonScreen youWon;
    private Yarn chickenTemp;
    private Bomb bomb;
    private Flag flag;
    int timer = 150;
    
    private Block block;
    TitleScreen thing;
    public int[][] tilesGrid;
    public Block[][] tilesObject;
    public Yarn[][] tilesChickenTemp;
    public Flag[][] tilesFlag;
    public int xScroll;
    public int yScroll;
    private int cometSpawnTimer;
    private int currentWorld = 1;
    public boolean hasStarted;

    public MyWorld() 
    {
        hasStarted = false;
        thing = new TitleScreen();
        gameOver = new GameOverScreen();
        youWon = new YouWonScreen();
        setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World1.jpg");
        addObject(thing,0,0);
        cometSpawnTimer = 0;
        tilesFlag = new Flag[20][100];

    }
    
    public void startGame(int world)
    {
    	this.currentWorld = world;
        if(world == 1)
        {
           world1(); 
        }
        if(world == 2)
        {
           world2(); 
        }
        if(world == 3)
        {
           world3(); 
        }
     
        gatherTiles();
        
        changeConnections();
        
        cat = new Cat();
        addObject(cat, 700, 300);
        
        // dog = new Dog();
        // addObject(dog, 200, 100);
        
        // jack = new Jack();
        // addObject(jack, 300, 100);
        
        // ninja = new Ninja();
        // addObject(ninja, 400, 100);
        
        // block = new Block();
        // addObject(block, 400, 500);
        // block = new Block();
        // addObject(block, 528, 372);
        
        Mayflower.showBounds(false);
        showText("Score: " + cat.getScore() + " Health: " + cat.getHealth(), 10, 30, Color.BLACK);
    }
    
    public void act()
    {
        if(thing.start && !hasStarted)
        {
            startGame(3);
            hasStarted = true;
        }
        else if(thing.start)
        {            
            scrollScreen();
            if(cat.getY() > 900 || cat.getHealth()==0){
                addObject(gameOver,-180, -150);
            }else if(cat.hasFinishedGame()){
                addObject(youWon,0, 0);            
            }
        }
        
        if (currentWorld == 3 && cat.getY() < 900 && cat.getHealth() > 0 && !cat.hasFinishedGame()) {
			     
        	cometSpawnTimer++;
            // Every 80 frames, spawn a new comet
            if (cometSpawnTimer >= 80) {
                spawnComet();
                cometSpawnTimer = 0;
            }
        }		
        
    }
    
    
    public void scrollScreen()
    {
        if(cat.getX() > 1000)
        {
            xScroll -= cat.getXVelocity();
            cat.setLocation(1000,cat.getY());
            for(int r = 0; r < tilesGrid.length; r ++)
            {
                for(int c = 0; c < tilesGrid[0].length; c ++)
                {
                    if(tilesGrid[r][c] == 1 || tilesGrid[r][c] == 2 || tilesGrid[r][c] == 3)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesObject[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 5)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesChickenTemp[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8){
                        tilesFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
                    }
                    
                }
                
            }
            
            
            
        }
        else if(cat.getX() < 600)
        {
            xScroll -= cat.getXVelocity();
            cat.setLocation(600,cat.getY());
            for(int r = 0; r < tilesGrid.length; r ++)
            {
                for(int c = 0; c < tilesGrid[0].length; c ++)
                {
                    if(tilesGrid[r][c] == 1 || tilesGrid[r][c] == 2 || tilesGrid[r][c] == 3)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        // tilesObject[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesObject[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 5)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesChickenTemp[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8)
                    {
                        tilesFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
                    }
                    
                }
                
            }
            
            
            
        }
        if(cat.getY() < 300)
        {
            yScroll += cat.getYVelocity();
            cat.setLocation(cat.getX(),300);
            for(int r = 0; r < tilesGrid.length; r ++)
            {
                for(int c = 0; c < tilesGrid[0].length; c ++)
                {
                    if(tilesGrid[r][c] == 1 || tilesGrid[r][c] == 2 || tilesGrid[r][c] == 3)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesObject[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 5)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesChickenTemp[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8){
                        tilesFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
                    }
                    
                }
                
            }
            
            
            
        }
        else if(cat.getY() > 600 && cat.getY() < 680)
        {
            yScroll += cat.getYVelocity();
            cat.setLocation(cat.getX(),600);
            for(int r = 0; r < tilesGrid.length; r ++)
            {
                for(int c = 0; c < tilesGrid[0].length; c ++)
                {
                    if(tilesGrid[r][c] == 1 || tilesGrid[r][c] == 2 || tilesGrid[r][c] == 3)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesObject[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 5)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesChickenTemp[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8){
                        tilesFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
                    }
                    
                }
                
            }
            
            
            
        }
    }
    
    public void gatherTiles()
    {
        for(int r = 0; r < tilesGrid.length; r ++)
        {
            for(int c = 0; c < tilesGrid[0].length; c ++)
            {
                if(tilesGrid[r][c] == 1)
                {
                    block = new Block();
                    tilesObject[r][c] = block;
                    addObject(block, c * 128, 900 - (r * 128) - 128);
                    
                    
                }
                else if(tilesGrid[r][c] == 2)
                {
                    block = new IceBlock();
                    tilesObject[r][c] = block;
                    addObject(block, c * 128, 900 - (r * 128) - 128);
                    
                    
                }
                else if(tilesGrid[r][c] == 3)
                {
                    block = new RockBlock();
                    tilesObject[r][c] = block;
                    addObject(block, c * 128, 900 - (r * 128) - 128);
                    
                    
                }
                else if(tilesGrid[r][c] == 5)
                {
                    chickenTemp = new Yarn();
                    tilesChickenTemp[r][c] = chickenTemp;
                    addObject(chickenTemp, c * 128, 900 - (r * 128) - 128);
                }
                else if(tilesGrid[r][c] == 8)
                {
                    flag = new Flag();
                    tilesFlag[r][c] = flag;
                    addObject(flag, c * 128, 900 - (r * 128) - 58); 
                }
            }
            
        }
    }
    
    public void changeConnections()
    {
        for(int r = 1; r < tilesGrid.length - 1; r ++)
        {
            for(int c = 1; c < tilesGrid[0].length - 1; c ++)
            {
                if(tilesGrid[r][c] == 1)
                {                 
                    
                    tilesObject[r][c].connect(0, tilesGrid[r + 1][c]);
                    tilesObject[r][c].connect(1, tilesGrid[r - 1][c]);
                    tilesObject[r][c].connect(2, tilesGrid[r][c + 1]);
                    tilesObject[r][c].connect(3, tilesGrid[r][c - 1]);
                    tilesObject[r][c].updateConnect();
                }
                
            }
            
        }
    }
    
    public void world1()
    {
        setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World1.jpg");
        
        // WorldLoad w = new WorldLoad();
        // addObject(w,0,0);
        // Detector d = new Detector();
        // addObject(d,643,634);
        
        removeObject(thing);
        
        tilesGrid = new int[60][100];
        tilesObject = new Block[60][100];
        tilesChickenTemp = new Yarn[20][100];
        xScroll = 0;
        yScroll = 0;
        
        
        
        for(int i = 0; i < 68; i++)
        {
            tilesGrid[0][i] = 1;
            tilesGrid[1][i] = 1;
        }
        
        for(int i = 4; i < 10; i++)
        {
            tilesGrid[2][i] = 1;
        }
        
        for(int i = 12; i < 15; i++)
        {
            tilesGrid[2][i] = 1;
            tilesGrid[3][i] = 1;
        }
        
        for(int i = 17; i < 20; i++)
        {
            tilesGrid[2][i] = 1;
            tilesGrid[3][i] = 1;
            tilesGrid[4][i] = 1;
        }
        
        for(int i = 22; i < 31; i++)
        {
            tilesGrid[2][i] = 1;
            tilesGrid[3][i] = 1;
            tilesGrid[4][i] = 1;
            tilesGrid[5][i] = 1;
            tilesGrid[6][i] = 1;
        }
        
        for(int i = 34; i < 38; i++)
        {
            tilesGrid[7][i] = 1;
            tilesGrid[8][i] = 1;
            
        }
        
        for(int i = 41; i < 44; i++)
        {
            tilesGrid[4][i] = 1;
            tilesGrid[5][i] = 1;
            
        }
        
        for(int i = 31; i < 46; i++)
        {
            tilesGrid[0][i] = 0;
            tilesGrid[1][i] = 0;
            
        }
        
        for(int i = 46; i < 48; i++)
        {
            for(int j = 2; j < 10; j++)
            {
                tilesGrid[j][i] = 1;
                
            }
        }
        
        for(int i = 46; i < 62; i++)
        {
            for(int j = 8; j < 12; j++)
            {
                tilesGrid[j][i] = 1;
                
            }
        }
        
        for(int i = 62; i < 65; i++)
        {
            for(int j = 6; j < 14; j++)
            {
                tilesGrid[j][i] = 1;
                
            }
        }
        
        for(int i = 68; i < 70; i++)
        {
            for(int j = 8; j < 11; j++)
            {
                tilesGrid[j][i] = 1;
                
            }
        }
        
        for(int i = 68; i < 70; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                tilesGrid[j][i] = 1;
                
            }
        }
        
        for(int i = 64; i < 68; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                tilesGrid[j][i] = 0;
                
            }
        }
        
        addRandomObjects();

    }
        
    
    public void world2()
    {
        setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World2.png");
        
        // WorldLoad w = new WorldLoad();
        // addObject(w,0,0);
        // Detector d = new Detector();
        // addObject(d,643,634);
        
        removeObject(thing);
        
        tilesGrid = new int[20][100];
        tilesObject = new Block[20][100];
        tilesChickenTemp = new Yarn[20][100];
        tilesFlag = new Flag[20][100];
        xScroll = 0;
        yScroll = 0;
        
        
        
        for(int i = 0; i < 8; i++)
        {
            tilesGrid[0][i] = 1;
            tilesGrid[1][i] = 1;
        }
        for(int i = 7; i < 10; i++)
        {
            tilesGrid[1][i] = 1;
            tilesGrid[2][i] = 1;
        }
        for(int i = 13; i < 15; i++)
        {
            for(int j = 3; j < 8; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        for(int i = 17; i < 19; i++)
        {
            tilesGrid[1][i] = 1;
            tilesGrid[2][i] = 1;
        }
        
        for(int i = 11; i < 18; i++)
        {
            tilesGrid[0][i] = 1;
            tilesGrid[1][i] = 1;
        }
        
        for(int i = 16; i < 25; i++)
        {
            for(int j = 7; j < 9; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        
        for(int i = 18; i < 28; i++)
        {
            for(int j = 2; j < 4; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 30; i < 33; i++)
        {
            for(int j = 2; j < 12; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 24; i < 25; i++)
        {
            for(int j = 7; j < 10; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 19; i < 20; i++)
        {
            for(int j = 7; j < 10; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        for(int i = 6; i < 12; i++)
        {
            for(int j = 7; j < 8; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 5; i < 6; i++)
        {
            for(int j = 7; j < 30; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 8; i < 9; i++)
        {
            for(int j = 9; j < 30; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 5; i < 6; i++)
        {
            for(int j = 10; j < 13; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        for(int i = 8; i < 9; i++)
        {
            for(int j = 14; j < 18; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        for(int i = 5; i < 6; i++)
        {
            for(int j = 19; j < 23; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        for(int i = 8; i < 9; i++)
        {
            for(int j = 24; j < 30; j++)
            {
                tilesGrid[j][i] = 2;
            
            }
            
        }
        for(int i = 8; i < 15; i++)
        {
            for(int j = 30; j < 31; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        for(int i = 14; i < 19; i++)
        {
            for(int j = 30; j < 34; j++)
            {
                tilesGrid[j][i] = 1;
            
            }
            
        }
        
        addRandomObjects();
        
    }
    
    
    	 
    public void world3()
    {
        setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World3.png");
        
        // WorldLoad w = new WorldLoad();
        // addObject(w,0,0);
        // Detector d = new Detector();
        // addObject(d,643,634);
        
        removeObject(thing);
        
        tilesGrid = new int[60][100];
        tilesObject = new Block[60][100];
        tilesChickenTemp = new Yarn[60][100];
        tilesFlag = new Flag[20][100];
        xScroll = 0;
        yScroll = 0;
        
        
        for(int i = 0; i < 5; i++)
        {
            tilesGrid[2][1] = 1;
            tilesGrid[3][3] = 1;
        }
        for(int i = 1; i < 3; i++)
        {
            tilesGrid[i][5] = 1;
        }
        
        for(int i = 1; i < 4; i++)
        {
            tilesGrid[i][10] = 1;
        }
        for(int i = 15; i < 16; i++)
        {
            tilesGrid[1][i] = 1;
        }
        tilesGrid[0][18] = 1;
        for(int i = 3; i < 15; i++)
        {
            tilesGrid[i][20] = 1;
        }
        for(int i = 1; i < 15; i++)
        {
            tilesGrid[i][22] = 1;
        }
        
            tilesGrid[15][26] = 1;
        for(int i = 16; i<19; i++)
        {
            tilesGrid[i][26] = 1;
        }
        
            tilesGrid[20][28] = 1;
            tilesGrid[21][29] = 1;
            tilesGrid[22][30] = 1;
            tilesGrid[23][31] = 1;
            tilesGrid[24][32] = 1;
            tilesGrid[25][33] = 1;
            tilesGrid[26][34] = 1;
            
        for(int i = 16; i<19; i++)
        {
            tilesGrid[i][37] = 1;
        }
        tilesGrid[19][37] = 8;
        addRandomObjects();
        
    }
        
    public void addRandomObjects()
    {
        Random rand = new Random();
        for (int r = 1; r < tilesGrid.length-1; r++) {
            for (int c = 1; c < tilesGrid[r].length-1; c++) {
                int randomValue = rand.nextInt(tilesGrid[0].length);
                if(randomValue < 5 && tilesGrid[r+1][c] != 1 && tilesGrid[r-1][c] != 1 && tilesGrid[r][c] != 1 && tilesGrid[r][c+1] != 1 && tilesGrid[r][c-1] != 1 && tilesGrid[r][c] != 2 && tilesGrid[r][c] != 3 && tilesGrid[r][c] != 8){
                  tilesGrid[r][c] = 5;
                }
            }
        }
    }
    
    public void spawnComet() {
        //int speed = 40 + (int)(Math.random() * 5);  // Random speed between 5 and 10
        //int angle = 45 + (int)(Math.random() * 15);  // Angle of 45 to 60 degrees
        
        int speed = 40;  // Random speed between 5 and 10
        int angle = 45;
        
        // Create a new comet with random speed and angle
        FallingComet comet = new FallingComet(speed, angle);

        // Randomize the x-position (starting from the top of the screen)
        int startX = (int)(Math.random() * getWidth());

        // Add comet to the world at random x position, starting from y = 0
        addObject(comet, startX, -100);
    }
	 
}