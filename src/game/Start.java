package game;

import java.util.concurrent.TimeUnit;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Group;


public class Start extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	//konstanty
			public static final double WIDTH = 500;
			public static final double HEIGHT = 520;
			public static final double SPEED  = 2;
	
	@Override
	public void start(Stage stage) {
		
			long start_time = System.nanoTime();
		 	stage.setTitle( "Miner" );
		 	Sprite dimensions = new Sprite();
         
		    Group root = new Group();
		    Scene scene = new Scene( root );
		    stage.setScene( scene );
		    
		    Canvas canvas = new Canvas( WIDTH, HEIGHT );
		    root.getChildren().add( canvas );
		    GraphicsContext gc = canvas.getGraphicsContext2D();
		    Image bg = new Image("bg1.png");
		    gc.drawImage(bg,0,0);
		    	
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<Sprite> gold_tile = new ArrayList<Sprite>();
        
        scene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });

        scene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });
        Level level = new Level();
        final ArrayList<Sprite> tile = level.BuildMainBlocks(); 
        final ArrayList<Sprite> tilesite = level.BuildSideBlocks();
		final ArrayList<Sprite> ladders = level.BuildLadders();	
				
		for (Sprite sprite : ladders) {	
			sprite.render(gc);
		}  
		
		for (Sprite sprite : tile) {
			sprite.render(gc);
		}
		Character characters = new Character();
		ArrayList<Sprite> miner_array = characters.BuildMiner();
		Sprite miner = miner_array.get(0);
		Sprite minerR = miner_array.get(1);
		Sprite minerL = miner_array.get(2);
		Sprite minerU = miner_array.get(3);
		//load normal miner
		miner.render(gc);		
		Sprite enemy = characters.BuildEnemy();
		//add 3 life
		ArrayList<Sprite> life = characters.BuildLifes(3);
		
		final long startNanoTime = System.nanoTime();
		new AnimationTimer()
        {
        	public void handle(long currentNanoTime) {
        		double t = (currentNanoTime - startNanoTime) / 1000000000.0;
        		double x = miner.getX();
        		double y = miner.getY();
        		double ex = enemy.getX() + Math.cos(t/3);

        		 	boolean top=false;
					boolean bot=false;
					boolean left=false;
					boolean right=false;
					boolean inladder = false;
					boolean ladderunder = false;
					boolean gravity = false;
					boolean minerLeft =  false;
					boolean minerRight = false;
					boolean minerUp = false;
					boolean dead = false;
					
					enemy.setPosition(ex, 280);
					
					
					//checkCollision(ladders)					
					for (Sprite sprite : ladders) {
						if(miner.intersects(sprite)) {
							inladder = true;
						}
						if(miner.bottomCollision(sprite)) {
							ladderunder = true;
						}
						else ladderunder =  false;
					}

					for (Sprite sprite : tilesite )
					{
						if(miner.intersects(sprite))
						{ 
							if(miner.leftCollision(sprite))
							{
								left=true;
							}

							
							if(miner.rightCollision(sprite))
							{
								right=true;
							}
						}
					}
					for (Sprite sprite : tile )
					{
						if(miner.intersects(sprite))
						{
							if(miner.bottomCollision(sprite))
							{
								bot=true;				
							
							}
							
							if(miner.topCollision(sprite))
							{
								top=true;
							}
						}
						if(miner.intersects(sprite))
						{ 
							if(miner.leftCollision(sprite))
							{
								left=true;
							}

							
							if(miner.rightCollision(sprite))
							{
								right=true;
							}
						}
						
					}		
				if(bot) {
					boolean exist = false;
					
					for (Sprite map : tile) { 
							if(miner.intersects(map)) {
								
								Sprite GoldTile = new Sprite();
								GoldTile.setImage("gold_tile.png");
								double px  =  map.getX();
								double py  = map.getY();
								for (Sprite sprite : gold_tile) {
									if((sprite.getX() == px)&&(sprite.getY() == py))
									{
										exist = true;
									}
								}
								if(!exist) {
								GoldTile.setPosition(px, py);
								gold_tile.add(GoldTile);
								}
						} 
					}
				}
				//gravityCheck(inladder,bot)
        		if(!inladder) {
        			if(!bot) {
    					gravity =  true;
    				}
        		}     			
        		else gravity = false;
        		
        		if(gravity) {
        			miner.setPosition(x, y+2);
        		}
				
                if (input.contains("LEFT")&& !right && (bot || inladder))
                {     
                	minerU.setPosition(x-SPEED, y);
                	minerL.setPosition(x-SPEED, y);
                	minerR.setPosition(x-SPEED, y);
                	miner.setPosition(x-SPEED, y);
                	left =  false;     
                	minerLeft = true;
                }
                if (input.contains("RIGHT") && !left && (bot || inladder))
                {    
                	minerU.setPosition(x+SPEED, y);
                	minerL.setPosition(x+SPEED, y);
                	minerR.setPosition(x+SPEED, y);
                	miner.setPosition(x+SPEED, y);
                	right =  false;
                	minerRight = true;
                }
                if (input.contains("UP") && inladder && !top)
                {     
                	minerU.setPosition(x, y-SPEED);
                	minerL.setPosition(x, y-SPEED);
                	minerR.setPosition(x, y-SPEED);
                	miner.setPosition(x, y-SPEED);
                	bot = false;
                	minerUp =  true;
                }
                if (input.contains("DOWN") && inladder  && !bot)
                {        		
                	miner.setPosition(x, y+SPEED);
                }
                if (input.contains("DOWN") && ladderunder)
                {        		
                	miner.setPosition(x, y+SPEED);
                }	
                if (input.contains("DOWN") && ladderunder)
                {        		
                	minerU.setPosition(x, y);
                	minerL.setPosition(x, y);
                	minerR.setPosition(x, y);
                	miner.setPosition(x, y);
                	minerLeft = false;
                	minerRight = false;
                	minerUp = false;
                }
               if (input.contains("LEFT") && input.contains("RIGHT"))
                {      		
                	minerU.setPosition(x, y);
                	minerL.setPosition(x, y);
                	minerR.setPosition(x, y);
                	miner.setPosition(x, y);
                	minerLeft = false;
                	minerRight = false;
                }
                if (input.contains("UP") && input.contains("DOWN"))
                {      		
                	minerU.setPosition(x, y);
                	minerL.setPosition(x, y);
                	minerR.setPosition(x, y);
                	miner.setPosition(x, y);
                	minerLeft = false;
                	minerRight = false;
                	minerUp = false;
                }
                
                if(miner.intersects(enemy)) {
					dead = true;
				}
				
				if(dead) {
					x = 30;
					y = 410;
					dead =  false;
					miner.setPosition(x, y);
					gold_tile.removeAll(gold_tile);
					life.remove(life.size() -1);
				}
				
				if(life.isEmpty())
				{
					
					//dodelat proherni okenko
					this.stop();
					stage.close();
				}
				
				if(gold_tile.size() == 95) {
					this.stop();
					long result = currentNanoTime - startNanoTime;
                    long result_in_sec = result / 1000000;
					Score sc = new Score();
					sc.writeScore(result_in_sec);	
					
					//dodelat vyherni okenko
					
					stage.close();
				}

        		gc.clearRect(0, 0, HEIGHT, WIDTH);  
        		gc.drawImage(bg,0,0);
        		
        		for (Sprite sprite : ladders) {	
        			sprite.render(gc);
        		}  
        		
        		for(Sprite sprite: life) {
        			sprite.render(gc);
        		}
        		
        		for (Sprite sprite : tile) {
        			sprite.render(gc);
        		}
        		
        		for (Sprite sprite : tilesite) {
        			sprite.render(gc);
        		}

        		enemy.render(gc);
           		if(minerUp) {
            		minerU.render(gc);
            		}
          		if(minerRight) {
            		minerR.render(gc);
            		}
           		if(minerLeft) {
            		minerL.render(gc);
            		}
        		if(!minerLeft && !minerRight && !minerUp) {
        			miner.render(gc);
        		}
        		Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 20 );
        	    gc.setFont( theFont );
        	    String s = new String("Score:" + gold_tile.size());
        		gc.fillText(s, 370, 40);
        		
        		
        		for (Sprite sprite : gold_tile) {
        			sprite.render(gc);
        		}
        		
        		                
                long result = currentNanoTime - startNanoTime;
                long result_in_sec = result / 1000000;
                String curr_time = new String("Time:" + result_in_sec/1000 + " s");
        		gc.fillText(curr_time, 280, 40);
                
        	}
        	
        }.start();
        
        
        
        stage.show();//95
        
	}
	
	
}
