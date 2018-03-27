import java.awt.Image;

public abstract class dynamicObject extends object {

	protected int speed;
	protected int dy;
	protected int dx;

	public dynamicObject(Image image, double x, double y) {
		super(image, x, y);
	}

		public abstract void move(long deltaTime);
}
