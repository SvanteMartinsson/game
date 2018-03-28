import java.awt.Image;

public abstract class dynamicObject extends object {

	public dynamicObject(Image image, double x, double y) {
		super(image, x, y);
	}



	protected int speed;
	protected int dy;
	protected int dx;
}
