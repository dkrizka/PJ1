package game;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite implements IDimensions,IPosition,ICollision,IMovement{

    private Image image;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    //private double speed;
    
    public Sprite() {
    	this.positionX = 0;
    	this.positionY = 0;
    	this.velocityX = 0;
    	this.velocityY = 0;
    }
 
    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }
 
    public void render(GraphicsContext gc) {
        gc.drawImage( image, positionX, positionY );
    }
 
    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX,positionY,width,height);
    }
 
    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects( this.getBoundary() );
    }	
    
    public double getX() {
    	return this.positionX;
    }
    
    public double getY() {
    	return this.positionY;
    }

    public double getHeight() {
    	return this.height;
    }
    
    public double getWidth() {
    	return this.width;
    }
    
    public double getVelocityX() {
    	return this.velocityX;
    }
    
    public double getVelocityY() {
    	return this.velocityY;
    }
    
    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }
    public boolean bottomCollision(Sprite s)
    {
    	double player_bot=this.positionY+this.height;
    	double block_bot=s.getY()+s.getHeight();
     	double pright=this.positionX+this.width;
    	double bright=s.getX()+s.getWidth();
    	
    	double b_collision = block_bot - this.getY();
    	double t_collision = player_bot - s.getY();
    	double l_collision = pright - s.getX();
    	double r_collision = bright - this.getX();
    	
    	return (t_collision < b_collision && t_collision < l_collision && t_collision < r_collision );
   
    }
    
    public boolean topCollision(Sprite s)
    {
    	double player_bot=this.positionY+this.height;
    	double block_bot=s.getY()+s.getHeight();
     	double pright=this.positionX+this.width;
    	double bright=s.getX()+s.getWidth();
    	
    	double b_collision = block_bot - this.getY();
    	double t_collision = player_bot - s.getY();
    	double l_collision = pright - s.getX();
    	double r_collision = bright - this.getX();
    	
    	return (b_collision < t_collision && b_collision < l_collision && b_collision < r_collision);
   
    } 
    
    public boolean leftCollision(Sprite s)
    {
    	double player_bot=this.positionY+this.height;
    	double block_bot=s.getY()+s.getHeight();
     	double pright=this.positionX+this.width;
    	double bright=s.getX()+s.getWidth();
    	
    	double b_collision = block_bot - this.getY();
    	double t_collision = player_bot - s.getY();
    	double l_collision = pright - s.getX();
    	double r_collision = bright - this.getX();
    	
    	return (l_collision < r_collision && l_collision < t_collision && l_collision < b_collision);
   
    }
    
    public boolean rightCollision(Sprite s)
    {
    	double player_bot=this.positionY+this.height;
    	double block_bot=s.getY()+s.getHeight();
     	double pright=this.positionX+this.width;
    	double bright=s.getX()+s.getWidth();
    	
    	double b_collision = block_bot - this.getY();
    	double t_collision = player_bot - s.getY();
    	double l_collision = pright - s.getX();
    	double r_collision = bright - this.getX();
    	
    	return (r_collision < l_collision && r_collision < t_collision && r_collision < b_collision );
   
    }
    
    public Rectangle2D getBoundary2()
    {
        return new Rectangle2D(positionX+width,positionY+height,width,height);
    }

    public boolean intersects2(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }

	
}
