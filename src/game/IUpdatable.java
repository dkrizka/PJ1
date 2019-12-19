package game;

public interface IUpdatable {
    public void update();
    public int getX();
    public int getWidth();
    public void setSpeed(int speed);
    public boolean collides(int objX, int objY, int objWidth, int objHeight);
    public boolean isUp();
}
