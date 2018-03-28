import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends dynamicObject{
	
	private boolean playerOne;
	
	// 1 = idle, 2 = running left, 3 = running right, 4 = running up, 5 = running down
	private int state;
	private BufferedImage bigImg;

	public Player(Image image, double x, double y, boolean playerOne) {
		super(image, x, y);
		this.playerOne = playerOne;
		state = 1;
		speed = 4;
		
		if(playerOne){
			try {
				bigImg = ImageIO.read(new File("Resources/spritesheetPlayerOne.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	

	public void render(Graphics2D g) {
		if(state == 1){
			g.drawImage(bigImg, (int)x, (int)y, (int)x+10, (int)y+10, 0, 0, 10, 10, null);
		}
		x = speed*dx;
		y = speed*dy;
	}

	public void update() {
		
		
	}

}
