import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player extends DynamicObject implements KeyListener{

	private boolean playerOne;
	private boolean holdingCrown;
	private Image crownImg;

	// 1 = idle, 2 = running left, 3 = running right, 4 = running up, 5 = running down
	private int state;
	private BufferedImage bigImg;

	public Player(Image image, double x, double y, boolean playerOne) {
		super(image, x, y);
		this.playerOne = playerOne;
		state = 1;
		speed = 1;
		holdingCrown = false;
		crownImg = new ImageIcon("Resources/crownSheet.png").getImage();

		if(playerOne || !playerOne){
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
		}else if(state == 2){
			g.drawImage(bigImg, (int)x, (int)y, (int)x+10, (int)y+10, 0, 10, 10, 20, null);
		}else if(state == 3){
			g.drawImage(bigImg, (int)x, (int)y, (int)x+10, (int)y+10, 0, 20, 10, 30, null);
		}else if(state == 4){
			g.drawImage(bigImg, (int)x, (int)y, (int)x+10, (int)y+10, 0, 30, 10, 40, null);
		}else if(state == 5){
			g.drawImage(bigImg, (int)x, (int)y, (int)x+10, (int)y+10, 0, 0, 10, 10, null);
		}

		if(holdingCrown){
			g.drawImage(crownImg, (int)x + 1, (int)y-10, 8, 8, null);
		}

	}

	public void update() {
		x += speed*dx;
		y += speed*dy;

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}




	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();


		if(playerOne){
			if(key == KeyEvent.VK_W){
				dy=-1;
				state = 4;
			}
			if(key == KeyEvent.VK_S){
				dy=1;
				state = 5;
			}
			if(key == KeyEvent.VK_D){
				dx=1;
				state = 3;
			}
			if(key == KeyEvent.VK_A){
				dx=-1;
				state = 2;
			}
		}else{
			if(key == KeyEvent.VK_UP){
				dy=-1;
				state = 4;
			}
			if(key == KeyEvent.VK_DOWN){
				dy=1;
				state = 5;
			}
			if(key == KeyEvent.VK_RIGHT){
				dx=1;
				state = 3;
			}
			if(key == KeyEvent.VK_LEFT){
				dx=-1;
				state = 2;
			}
		}
	}




	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if(playerOne){
			if(key == KeyEvent.VK_W){
				dy=0;
			}
			if(key == KeyEvent.VK_S){
				dy=0;
			}
			if(key == KeyEvent.VK_D){
				dx=0;
			}
			if(key == KeyEvent.VK_A){
				dx=0;
			}
		}else{
			if(key == KeyEvent.VK_UP){
				dy=0;
			}
			if(key == KeyEvent.VK_DOWN){
				dy=0;
			}
			if(key == KeyEvent.VK_RIGHT){
				dx=0;
			}
			if(key == KeyEvent.VK_LEFT){
				dx=0;
			}
		}

	}

}
