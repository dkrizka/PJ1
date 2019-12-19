package game;

public interface ICollision {


	public boolean bottomCollision(Sprite s);
	public boolean topCollision(Sprite s);
	public boolean leftCollision(Sprite s);
	public boolean rightCollision(Sprite s);
}
