import java.awt.Image;

public abstract class DynamicObject extends Object {

	public DynamicObject(Image image, double x, double y) {
		super(image, x, y);
	}



	protected int speed;
	protected int dy;
	protected int dx;
}
