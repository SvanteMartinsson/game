import java.awt.Color;
import java.awt.Graphics2D;

public class HUD {
	
	private int width;
	private int height;
	private long time;
	private String pOneScore = "0";
	private String pTwoScore = "0";
	
	public HUD(int WIDTH, int HEIGHT) {
		this.width = WIDTH;
		this.height = HEIGHT;
	}
	
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(0,0,0,0x99));
		g.fillRect(width/4, 0, width/2, height/20);
		g.setColor(Color.green);
		g.drawRect(width/4, 0, width/8, height/20);
		g.drawRect((width/8)*3, 0, width/4, height/20);
		g.drawRect((width/8)*5, 0, width/8, height/20);
		g.drawString(pOneScore, (width/16)*5, height/30);
		g.drawString(pTwoScore, (width/16)*11, height/30);
		
	}
	
	public void updateTime() {
		long nanoTime = System.nanoTime();
		//int sec = 
		
	}
	
	public void updateScore() { // Inparametrar fattas 
		
	}
}
