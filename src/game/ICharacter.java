package game;

import java.util.ArrayList;

public interface ICharacter {
	
	public static final double WIDTH = 500;
	public static final double HEIGHT = 520;
	public static final double SPEED  = 2;
	public ArrayList<Sprite> BuildMiner();
	public ArrayList<Sprite> BuildLifes(int count);
	public ArrayList<Sprite> BuildEnemy(int count);
}
