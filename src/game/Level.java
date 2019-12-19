package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level implements ILevel{
	public ArrayList<Sprite> BuildMainBlocks() 
	{
		//if i read out of file
		/*
		 
		*/
		int f=0,ll=0;
		int level_layout[] = new int [33];
		int floor1[] = new int[6];
		//int floor2[] = new int[3];
		BufferedReader br = null;
	    try {
	        String sCurrentLine;
	        br = new BufferedReader(new FileReader("D:/School/Level1.txt"));
	        while ((sCurrentLine = br.readLine()) != null) {
	        	    System.out.println( sCurrentLine + br.readLine());
	               String[] strArr = sCurrentLine.split("\\;");
	               for(String str:strArr){
	                    System.out.println(str);
	                    if(str!=null) {
	                    level_layout[ll]=Integer.parseInt(str);
	                    System.out.println("index = " + ll+ " number = " + level_layout[ll]);
	                    ll++;   
	                    }
	                    }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (br != null)br.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    for(int lll=0;lll<33;lll++) {
	    if(f<6) {
            floor1[f]=level_layout[lll];
            f++;
            }
	    }
		ArrayList<Sprite> tile = new ArrayList<Sprite>();
		/*top block*/
		for(int i = 0; i < HEIGHT/20 ;i++) {
		Sprite block = new Sprite();
		block.setImage("map.png");
		double width =  block.getWidth();
		block.setPosition(i * width, 0);
		
		tile.add(block);
		}
		
		/*bot block*/
		for(int i = 1; i < HEIGHT/21 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT - height);
			tile.add(block);
			}
		
		
		
		//first floor
		for(int i = floor1[0]; i < floor1[1] ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT -( floor1[2]* height));
			tile.add(block);
			}
		for(int i = floor1[3]; i < floor1[4] ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT -( floor1[5]* height));
			tile.add(block);
			}
		//second floor
		for(int i = 4; i < 21 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT -( 11* height));
			tile.add(block);
			}
		//third floor
		for(int i = 5; i < 13 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT -( 16* height));
			tile.add(block);
			}
		for(int i = 16; i < 24 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT -( 16* height));
			tile.add(block);
			}
		//fourth floor
		for(int i = 1; i < 21 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(i * width, HEIGHT -( 21* height));
			tile.add(block);
			}

		return tile;
		
	}
	public ArrayList<Sprite> BuildSideBlocks(){
		//left block
		ArrayList<Sprite> tilesite = new ArrayList<Sprite>();
		for(int i = 0; i < WIDTH/19 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double height = block.getHeight();
			block.setPosition(0, i*height);
			tilesite.add(block);
			}
		//right block
		for(int i = 0; i < HEIGHT/19 ;i++) {
			Sprite block = new Sprite();
			block.setImage("map.png");
			double width =  block.getWidth();
			double height = block.getHeight();
			block.setPosition(WIDTH-width, i*height);
			tilesite.add(block);
			}
		return tilesite;
	}
	public ArrayList<Sprite> BuildLadders(){
		ArrayList<Sprite> ladders = new ArrayList<Sprite>();

		/*first floor ladder*/
		for(int i = 20; i < 25; i++) {
			Sprite ladder = new Sprite();
			ladder.setImage("ladder.png");
			double width =  ladder.getWidth();
			double height = ladder.getHeight();
			ladder.setPosition(WIDTH - width - 240 , height*i);
			ladders.add(ladder);
		}
		
		/*second floor ladder*/
		for(int i = 15; i < 20; i++) {
			Sprite ladder = new Sprite();
			ladder.setImage("ladder.png");
			double height = ladder.getHeight();
			ladder.setPosition(20 , height*i);
			ladders.add(ladder);
		}
		for(int i = 15; i < 20; i++) {
			Sprite ladder = new Sprite();
			ladder.setImage("ladder.png");
			double height = ladder.getHeight();
			double width = ladder.getWidth(); 
			ladder.setPosition(WIDTH - width - 20 , height*i);
			ladders.add(ladder);
		}
		/*third floor ladder*/
		for(int i = 10; i < 15; i++) {
			Sprite ladder = new Sprite();
			ladder.setImage("ladder.png");
			double height = ladder.getHeight();
			ladder.setPosition(20*13 , height*i);
			ladders.add(ladder);
		}
		/*fourth floor ladder*/
		for(int i = 5; i < 10; i++) {
			Sprite ladder = new Sprite();
			ladder.setImage("ladder.png");
			double height = ladder.getHeight();
			ladder.setPosition(20*21 , height*i);
			ladders.add(ladder);
		}
		/*random ladder, solved problem*/
		
		Sprite ladder = new Sprite();
		ladder.setImage("ladder.png");
		ladders.add(ladder);
		/*----------------------------------------------------------------------------------------*/
		
	return ladders;
	}
}
