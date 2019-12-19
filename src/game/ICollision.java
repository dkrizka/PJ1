package game;

import javafx.geometry.Rectangle2D;

public interface ICollision {


	public boolean bottomCollision(Sprite s);
	public boolean topCollision(Sprite s);
	public boolean leftCollision(Sprite s);
	public boolean rightCollision(Sprite s);
	public boolean intersects(Sprite s);
	public Rectangle2D getBoundary();
	public Rectangle2D getBoundary2();
	public boolean intersects2(Sprite s);
}
