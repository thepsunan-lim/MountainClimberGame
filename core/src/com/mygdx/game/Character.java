package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Character {
	public static int g = 0;
	public static Vector2 position;
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    public static final int SPEED = 4;
    public static final int GRAV = 4;
    public static final int JUMP = 5;
    public static final int SLEEP = 500;
    
    public Character(int x, int y) {
        position = new Vector2(x,y);
        
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    public void move(int dir) { 
    	position.x += SPEED * DIR_OFFSETS[dir][0];   
    }
    public void gravity(){
    	if(g==0){
    		position.y += GRAV;
    	}
    	else if (g==1){
    		position.y -= JUMP;
    		 Thread timer = new Thread(){
    		        @Override
    		        public void run() {
    		        	
    		            try {
    		                sleep(SLEEP);//time in milliseconds
    		            } catch (InterruptedException e) {
    		                
    		                e.printStackTrace();
    		            } finally{
    		                
    		            	g=0;
    		            }
    		            
    		        }
    		    };
    		    timer.start();
    
    	}
    	
    }
}
