import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HUD {

	private int width;
	private int height;
	private long time;
	private boolean HUDDrawn = false;
	private String pOneScore = "0";
	private String pTwoScore = "0";
	private Image crownImg;

	public HUD(int WIDTH, int HEIGHT) {
		this.width = WIDTH;
		this.height = HEIGHT;
		crownImg = new ImageIcon("Resources/bigCrown.png").getImage();
	}


	public void update() {

	}

	public void render(Graphics2D g) {
		if(!HUDDrawn) {
			g.setColor(new Color(0,0,0,0x75));
			g.fillRect(width/4, 0, width/2, height/20);
			g.setColor(Color.green);
			g.drawRect(width/4, 0, width/8, height/20);
			g.drawRect((width/8)*3, 0, width/4, height/20);
			g.drawRect((width/8)*5, 0, width/8, height/20);
			HUDDrawn = true;
		}
		g.setColor(Color.green);
		g.drawString(pOneScore, (width/16)*5, height/30);
		g.drawString(pTwoScore, (width/16)*11, height/30);
		g.drawImage(crownImg, ((width/16)*5)-42, (height/30)-20, null);
		g.drawImage(crownImg, ((width/16)*11)+22, (height/30)-20, null);

	}

	public void updateTime() {
		long nanoTime = System.nanoTime();
		//int sec = 

	}

	public void updateScore() { // Inparametrar fattas 

	}
}
