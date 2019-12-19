package game;

import java.util.ArrayList;

public interface ILevel{
	//konstanty
			public static final double WIDTH = 500;
			public static final double HEIGHT = 520;
			public static final double SPEED  = 2;
	public ArrayList<Sprite> BuildMainBlocks();
	public ArrayList<Sprite> BuildSideBlocks();
	public ArrayList<Sprite> BuildLadders();

}
