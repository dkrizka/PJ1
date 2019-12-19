package game;

import java.util.ArrayList;

public class Character implements ICharacter {

	@Override
	public ArrayList<Sprite> BuildMiner() {
		ArrayList<Sprite> miner = new ArrayList<Sprite>();
		Sprite miner_normal = new Sprite();
		miner_normal.setImage("miner1.png");
		double height =  miner_normal.getHeight();
		miner_normal.setPosition(30, HEIGHT- height  -60);
		miner.add(miner_normal);
				
		Sprite minerR = new Sprite();
		minerR.setImage("minerR.png");
		miner.add(minerR);
		
		Sprite minerL = new Sprite();
		minerL.setImage("minerL.png");
		miner.add(minerL);
		
		Sprite minerU = new Sprite();
		minerU.setImage("minerU.png");
		miner.add(minerU);
		
		
		return miner;
	}
	public ArrayList<Sprite> BuildLifes(int count) 
	{
		ArrayList<Sprite> life = new ArrayList<Sprite>();
		for(int i  = 0 ; i < count; i++) {		
		Sprite l = new Sprite();
		l.setImage("life.png");
		l.setPosition(20 + (22*i), 20); 
		life.add(l);
		}
		return life;
		
	}

	@Override
	public ArrayList<Sprite> BuildEnemy(int count) {
		ArrayList<Sprite> enemies = new ArrayList<Sprite>();
		for(int i  = 0 ; i < count; i++) {
		Sprite enemy = new Sprite();
		enemy.setImage("enemy.png");
		enemy.setPosition(240, 380 - (i * 120));
		enemies.add(enemy);
		}
		
		
		return enemies;
	}
	

}
