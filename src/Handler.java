import java.awt.Graphics2D;

public class Handler {
	private HUD hud;
	private GenerateMap map;
	private MapHandler mapHandler;
	private boolean mapDrawn = false;
	
	public Handler(HUD hud, GenerateMap map) {
		this.map = map;
		this.hud = hud;
		mapHandler = new MapHandler();
	}
	
	public void render(Graphics2D g){
		if(!mapDrawn) {
		mapHandler.drawMap(g, map);
		mapDrawn = true;
		}
		hud.render(g);
		
	}
	public void update(){
		
	}

}
