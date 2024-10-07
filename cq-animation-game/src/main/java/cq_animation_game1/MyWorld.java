package cq_animation_game1;

import mayflower.*;
import java.util.Random;

public class MyWorld extends World 
{

    private Cat cat;
    private Chicken enemy;
    
    TitleScreenPeter peterdance;
    private Block block;
    TitleScreen thing;
    public int[][] tilesGrid;
    public Block[][] tilesObject;
    public int xScroll;
    public int yScroll;
    public Chicken[] enemies;
    public BeamLaser laser;
    public boolean hasStarted;
    private boolean transitionedToGameOver;
    private boolean transitionedToYouWon;
    private Flag flag;
    GameOverScreen gameOver;
    public Yarn[][] tilesYarn;
    public Flag[][] tileFlag;
    private Yarn yarn;
    public Flag[][] tilesFlag;
    public static int worldNum;
    public int createCometTimer;
    public static boolean touchedRedBull;
    private RedBullPeter redbullpeter;
    public MyWorld(int world) 
    {
        hasStarted = false;
        worldNum = world;
        cat = new Cat();
        createCometTimer = 0;
        
        if(worldNum == 1)
        {
             thing = new TitleScreen();
             setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World1.jpg");
             addObject(thing,0,0);
             peterdance = new TitleScreenPeter();
             addObject(peterdance,900,650);
        }
        else
        {
            startGame(worldNum);
        }
        
    }
    
    public void startGame(int world)
    {
        if(worldNum == 1)
        {
           world1(); 
        }
        if(worldNum == 2)
        {
           world2(); 
        }
        if(worldNum == 3)
        {
           world3(); 
        }
        
        tilesYarn = new Yarn[60][100];
        tileFlag = new Flag[60][100];
        
        removeObject(peterdance);
        redbullpeter = new RedBullPeter();
        addObject(redbullpeter, 0, 0);
        cat = new Cat();
        addRandomObjects();
        gatherTiles();
        changeConnections();
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
    }
    
    public void act()
    {
        if(worldNum == 1)
        {
            if(thing.start && !hasStarted)
            {
                worldNum = 1;
                startGame(1);
                hasStarted = true;
            }
            else if(thing.start)
            {
                scrollScreen();
            }
        }
        else
        {
            scrollScreen();
        }
        
        if(worldNum == 3 && cat.getY() < 900 && cat.getHealth() > 0 && !cat.hasFinishedGame()){
                createCometTimer++;
                // Every 80 frames, create a new comet
                if (createCometTimer >= 80) {
                    createComet();
                    createCometTimer = 0;
                }
        }
        
        shoot();
        
        if(yScroll < -300)
        {
            //System.out.println(cat.getY());
            transitionToGameOver();
        }
        else if(cat.hasFinishedGame() && worldNum == 3)
        {
            transitionToYouWon();            
        }
        else if(cat.hasFinishedGame())
        {
            worldNum ++;
            Mayflower.setWorld(new MyWorld(worldNum));
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
                    if(tilesGrid[r][c] == 1 || tilesGrid[r][c] == 2|| tilesGrid[r][c] == 3)
                    {
                        // this.removeObject(tilesObject[r][c]);
                        // block = new Block();
                        // tilesObject[r][c] = block;
                        // addObject(block, c * 128 + xScroll, 900 - (r * 128) - 128);
                        tilesObject[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 5)
                    {
                        
                        tilesYarn[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8){
                        tileFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
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
                        
                        tilesYarn[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8){
                        tileFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
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
                        
                        tilesYarn[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8){
                        tileFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
                    }
                }
                
            }
            
            
            
        }
        else if(cat.getY() > 600)
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
                        
                        tilesYarn[r][c].setPlace( c * 128 + xScroll, 900 - (r * 128) + yScroll - 128);
                    }
                    if(tilesGrid[r][c] == 8)
                    {
                        tileFlag[r][c].setPlace(c * 130 + xScroll, 900 - (r * 128) + yScroll - 58); 
                    }
                }
                
            }
            
            
            
        }
        // for(int i = 0; i < enemies.length; i ++)
        // {
            // enemies[i].setPlace(enemies[i].getX() + cat.getXVelocity(), enemies[i].getY() + cat.getYVelocity());
        // }
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
                    block = new RedBull();
                    tilesObject[r][c] = block;
                    addObject(block, c * 128, 900 - (r * 128) - 128);
                
                }
                if(tilesGrid[r][c] == 5)
                {
                    yarn = new Yarn();
                    tilesYarn[r][c] = yarn;
                   
                    
                    addObject(yarn, c * 128, 900 - (r * 128) - 128);
                }
                if(tilesGrid[r][c] == 8)
                {
                    flag = new Flag();
                    tileFlag[r][c] = flag;
                    addObject(flag, c * 128, 900 - (r * 128) - 58); 
                    System.out.println("hi123");
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
                    
                    if(tilesGrid[r + 1][c] != 5 && tilesGrid[r + 1][c] != 3 )
                        tilesObject[r][c].connect(0, tilesGrid[r + 1][c]);
                    if(tilesGrid[r - 1][c] != 5 && tilesGrid[r - 1][c] != 3)
                        tilesObject[r][c].connect(1, tilesGrid[r - 1][c]);
                    if(tilesGrid[r][c + 1] != 5 && tilesGrid[r][c + 1] != 3)
                        tilesObject[r][c].connect(2, tilesGrid[r][c + 1]);
                    if(tilesGrid[r][c - 1] != 5 && tilesGrid[r][c - 1] != 3)
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
        xScroll = 0;
        yScroll = 0;
        
        enemies = new Chicken[5];
        
        enemy = new Chicken();
        enemies[0] = enemy;
        addObject(enemy, 128 * 2, 128 * 2);
        
        enemy = new Chicken();
        enemies[1] = enemy;
        addObject(enemy, 128 * 6, 128 * 2);
        
        enemy = new Chicken();
        enemies[2] = enemy;
        addObject(enemy, 128 * 7, 128 * 4);
        
        enemy = new Chicken();
        enemies[3] = enemy;
        addObject(enemy, 128 * 13, 128 * 9);
        
        enemy = new Chicken();
        enemies[4] = enemy;
        addObject(enemy, 128 * 18, 128 * 9);
        tilesGrid[3][31] = 3;
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
        tilesGrid[2][48] = 8;
    }
        
    
    public void world2()
    {
        setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World2.png");
        
        // WorldLoad w = new WorldLoad();
        // addObject(w,0,0);
        // Detector d = new Detector();
        // addObject(d,643,634);
        
        removeObject(thing);
        
        tilesGrid = new int[60][100];
        tilesObject = new Block[60][100];
        xScroll = 0;
        yScroll = 0;
        
        enemies = new Chicken[7];
        
        enemy = new Chicken();
        enemies[0] = enemy;
        addObject(enemy, 128 * 2, 128 * 2);
        
        enemy = new Chicken();
        enemies[1] = enemy;
        addObject(enemy, 128 * 6, 128 * 2);
        
        enemy = new Chicken();
        enemies[2] = enemy;
        addObject(enemy, 128 * 7, 128 * 4);
        
        enemy = new Chicken();
        enemies[3] = enemy;
        addObject(enemy, 128 * 13, 128 * 9);
        
        enemy = new Chicken();
        enemies[4] = enemy;
        addObject(enemy, 128 * 18, 128 * 9);
        
        enemy = new Chicken();
        enemies[5] = enemy;
        addObject(enemy, 128 * 11, 128 * 6);
        
        enemy = new Chicken();
        enemies[6] = enemy;
        addObject(enemy, 128 * 7, 128 * 3);
        
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
        tilesGrid[6][12] = 3;
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
                tilesGrid[j][i] = 0;
            
            }
            
        }
        for(int i = 8; i < 9; i++)
        {
            for(int j = 14; j < 18; j++)
            {
                tilesGrid[j][i] = 0;
            
            }
            
        }
        for(int i = 5; i < 6; i++)
        {
            for(int j = 19; j < 23; j++)
            {
                tilesGrid[j][i] = 0;
            
            }
            
        }
        for(int i = 8; i < 9; i++)
        {
            for(int j = 24; j < 30; j++)
            {
                tilesGrid[j][i] = 0;
            
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
        tilesGrid[34][17] = 8;
    }
    
    public void shoot()
    {
        if(cat.isHadoukenActive && cat.getTimer() == 1)
        {
            laser = new BeamLaser();
            addObject(laser, cat.getX(), cat.getY());
        }
    }
    
    private void transitionToGameOver() {
        gameOver = new GameOverScreen();
        addObject(gameOver,-160, -120);        
        transitionedToGameOver = true;
    }
    
    private void transitionToYouWon() {
        // Create a new instance of NewWorld
        YouWonScreen youWon = new YouWonScreen();
        
        // Set the new world
        Mayflower.setWorld(youWon);
        
        // Update transition flag to prevent repeated transitions
        transitionedToYouWon = true;
    }
        public void addRandomObjects()
    {
        Random rand = new Random();
        for (int r = 0; r < tilesGrid.length; r++) {
            for (int c = 0; c < tilesGrid[r].length; c++) {
                int randomValue = rand.nextInt(tilesGrid[0].length);
                System.out.println(randomValue);
                if(randomValue < 5 && tilesGrid[r][c] == 0){
                    // int x = c * 115;
                    // int y = 900 - (tilesGrid.length - r) * 119;
                    // Yarn yarn = new Yarn();
                    // addObject(yarn, x, y);
                    // tilesGrid[r][c] = 10;
                    tilesGrid[r][c] = 5;
                }
            }
        }
    } 
    public void world3()
    {
        setBackground(System.getProperty("user.dir") + "\\src\\main\\resources\\img\\BG\\World3.png");
        
        // WorldLoad w = new WorldLoad();
        // addObject(w,0,0);
        // Detector d = new Detector();
        // addObject(d,643,634);
        enemies = new Chicken[1];
        enemy = new Chicken();
        enemies[0] = enemy;
        addObject(enemy, 128 * 2, 128 * 2);
        
        
        tilesGrid = new int[60][100];
        tilesObject = new Block[60][100];
        tilesYarn = new Yarn[60][100];
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
        
        tilesGrid[5][12] = 3;
        
        tilesGrid[19][37] = 8;
        addRandomObjects();
        
    }
    
    public void createComet() {
        int speed = 40 + (int)(Math.random() * 5);  // Random speed between 40 and 45
        int angle = 45 + (int)(Math.random() * 15);  // Angle of 45 to 60 degrees
        
        // Create a new comet with random speed and angle
        FallingComet comet = new FallingComet(speed, angle);

        // Randomize the x-position (starting from the top of the screen)
        int startX = (int)(Math.random() * getWidth());

        // Add comet to the world at random x position, starting from y = 0
        addObject(comet, startX, -100);
    }
}