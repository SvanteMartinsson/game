import java.awt.Graphics2D;

public class Handler {
	private Player player;
	private HUD hud;
	private GenerateMap map;
	private MapHandler mapHandler;
	private boolean mapDrawn = false;
	
	public Handler(HUD hud, GenerateMap map) {
		this.map = map;
		this.hud = hud;
		mapHandler = new MapHandler();
		player = new Player(null, 100, 100, true);
	}
	
	public void render(Graphics2D g){
		if(!mapDrawn) {
		mapHandler.drawMap(g, map);
		mapDrawn = true;
		}
		hud.render(g);
		player.render(g);
		
	}
	public void update(){
		player.update();
	}

}
