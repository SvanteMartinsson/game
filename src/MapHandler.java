import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class MapHandler {
	private int width = 100;
	private int height = 80;
	private int blocked = 1;
	private ArrayList<Rectangle> rectList;
	private Image wallImg;

	public void render() {

	}

	public void drawMap(Graphics2D g, GenerateMap map) {
		int[][] newMap = map.getMap();
		rectList = new ArrayList<>();
				wallImg = new ImageIcon("Resources/tileset.jpg").getImage();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
					//g.setColor(Color.white);
					//g.fillRect(x*10, y*10, 10, 10);
					//g.setColor(g.getColor().darker());
					//g.drawRect(x*10, y*10, 10, 10);
				if(newMap[x][y] == blocked) {
					rectList.add(new Rectangle(x*10,y*10,10,10));
					g.drawImage(wallImg, x*10, y*10, 10, 10, null);
				}

			}
		}
	}
	
	public ArrayList<Rectangle> getRectList(GenerateMap map) {
		return rectList;
		
	}
}
