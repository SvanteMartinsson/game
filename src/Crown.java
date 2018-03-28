import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Crown extends Object{
	
	private Image image;
	private Random ran;

	public Crown(Image image, double x, double y) {
		super(image, x, y);
		this.image = new ImageIcon("Resources/crownSheet.png").getImage();
		ran = new Random();
		randomSpawn();
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(image, (int)x, (int)y, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub	
	}
	
	public void randomSpawn(){
		x = ran.nextInt(500) + 500;
		y = ran.nextInt(100) + 500;	 
		System.out.println(x + " " + y);
	}
	
	public Rectangle getRect(){
		return new Rectangle((int)x, (int)y, 8, 8);
	}

}
