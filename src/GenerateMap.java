import java.util.Random;

public class GenerateMap {
	
	private int[][] mapGenArr;
	private Random ran;
	
	public GenerateMap(){
		mapGenArr = new int[5][5];
		ran = new Random();
		generateRandom();
	}
	
	public void generateRandom(){
		for(int i = 0; i < 5; i++){
			for(int y = 0; y < 5; y++){
				int num = ran.nextInt(2) + 1;
				mapGenArr[i][y] = num;
				System.out.print(mapGenArr[i][y]);
			}
			System.out.println();
		}
	}
	
	public void loadFromTextFile(){
		
	}
	
}
