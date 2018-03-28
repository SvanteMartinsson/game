import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Main extends Canvas{
	
	private GenerateMap genMap;
	private Handler handler;
	private HUD hud;
	
	// Window variables
	static final int WIDTH = 1000;
	static final int HEIGHT = 820;
	static final String title = "Game";


	
	boolean isRunning = false;
	
	private BufferStrategy buffer;
	
	public Main(){
		isRunning = true;
		hud = new HUD(WIDTH, HEIGHT);
		Window window = new Window(WIDTH, HEIGHT, title, this);
		this.createBufferStrategy(3);
		buffer = this.getBufferStrategy();
		genMap = new GenerateMap();
		handler = new Handler(hud, genMap);
		
		gameLoop();
	}

	public static void main(String[] args) {

		new Main();
	}
	
	public void gameLoop(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;


			while(delta >=1){
				update();
				delta--;
			}

			if(isRunning){
				render();

			}

			frames++;
			
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: "+ frames);
				frames = 0;
			}
			
			
		}
	}
	
	public void render(){
		
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		handler.render(g);
		
		g.dispose();
		buffer.show();
	}
	
	public void update(){		
		handler.update();
	}

}
