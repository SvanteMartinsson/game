import java.awt.Image;

public abstract class object {
	
	protected Image image;

	protected double x, y; 
	
	public object (Image image, double x, double y){
		this.image = image;   
		this.x = y;
		this.y = y;
	}
	
	public abstract void render();
	
	public abstract void update();
	
}
