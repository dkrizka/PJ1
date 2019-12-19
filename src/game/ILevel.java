package game;

import java.util.ArrayList;

public interface ILevel{
			//konstanty
			public static final double WIDTH = 500;
			public static final double HEIGHT = 520;
			public static final double SPEED  = 2;
			//public static final int floor1[] = {1,10,6,13,24,6};
			
			//floor2 = {4,21,11}
			//floor3 = {5,13,16,16,24,16}
			//floor4 = {1,21,21}
			//ladder1 = {15,20,20}
			//ladder2 = {15,20,20,15,20,20}
			//ladder3 = {10,15,260}
			//ladder4 = {5,10,420}
			
	public ArrayList<Sprite> BuildMainBlocks();
	public ArrayList<Sprite> BuildSideBlocks();
	public ArrayList<Sprite> BuildLadders();

}
