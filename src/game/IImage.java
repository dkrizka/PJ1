package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface IImage {
	
	public void setImage(Image i);
	public void setImage(String filename);

	public void render(GraphicsContext gc);
}
