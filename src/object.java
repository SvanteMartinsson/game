import java.awt.Graphics2D;
import java.awt.Image;

public abstract class object {
	
	protected Image image;

	protected double x, y; 
	
	public object (Image image, double x, double y){
		this.image = image;   
		this.x = y;
		this.y = y;
	}
	
	public abstract void render(Graphics2D g);
	
	public abstract void update();
	
}
