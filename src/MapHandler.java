import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MapHandler {
	private int width = 100;
	private int height = 80;
	private int blocked = 1;
	private Image wallImg;

	public void render() {

	}

	public void drawMap(Graphics2D g, GenerateMap map) {
		int[][] newMap;
				newMap = map.getMap();
				wallImg = new ImageIcon("Resources/tileset.jpg").getImage();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
					//g.setColor(Color.white);
					//g.fillRect(x*10, y*10, 10, 10);
					//g.setColor(g.getColor().darker());
					//g.drawRect(x*10, y*10, 10, 10);
				if(newMap[x][y] == blocked) {
					g.drawImage(wallImg, x*10, y*10, 10, 10, null);
				}

			}
		}
	}
}
