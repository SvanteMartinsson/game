import java.awt.Graphics2D;

public class Handler {
	private Player playerOne;
	private Player playerTwo;
	private HUD hud;
	private GenerateMap map;
	private MapHandler mapHandler;
	private boolean mapDrawn = false;
	private Crown crown;
	
	public Handler(HUD hud, GenerateMap map) {
		this.map = map;
		this.hud = hud;
		mapHandler = new MapHandler();
		playerOne = new Player(null, 100, 100, true);
		playerTwo = new Player(null, 600, 600, false);
		crown = new Crown(null, 10, 10);
	}
	
	public void render(Graphics2D g){
		//if(!mapDrawn) {
		mapHandler.drawMap(g, map);
		//mapDrawn = true;
		//}
		hud.render(g);
		playerOne.render(g);
		playerTwo.render(g);
		crown.render(g);
		
	}
	public void update(){
		playerOne.update();
		playerTwo.update();
		playerOne.playerCollision(map, mapHandler);
		playerTwo.playerCollision(map, mapHandler);
		crown.update();

	}
	
	public Player getPlayerOne(){
		return playerOne;
	}
	
	public Player getPlayerTwo(){
		return playerTwo;
	}
}
