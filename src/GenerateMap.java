import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GenerateMap {

	private int[][] mapGenArr;
	private Random ran;
	private int[][] fullMap;

	public GenerateMap(){
		mapGenArr = new int[5][5];
		fullMap = new int[100][80];
		ran = new Random();
		generateRandom();
	}
	
	
	public void generateRandom(){
		for(int i = 0; i < 5; i++){
			for(int y = 0; y < 5; y++){
				
				// if and else if statements are setting the corner blocks
				if(i == 0 && y == 0){
					mapGenArr[0][0] = 10;
				}else if(i == 0 && y == 4){
					mapGenArr[0][4] = 13;
				}else if(i == 4 && y == 0){
					mapGenArr[4][0] = 11;
				}else if(i == 4 && y == 4){
					mapGenArr[4][4] = 12;
				}else{
					System.out.println("i = " + i + " y = " + y);
					int num = ran.nextInt(4) + 1;
					mapGenArr[i][y] = num;
				}
				
			}
		}

		for(int blockRow = 0; blockRow < 5; blockRow++){
			int[][] mapOne = loadFromTextFile(Integer.toString(mapGenArr[blockRow][0]));
			int[][] mapTwo = loadFromTextFile(Integer.toString(mapGenArr[blockRow][1]));
			int[][] mapThree = loadFromTextFile(Integer.toString(mapGenArr[blockRow][2]));
			int[][] mapFour = loadFromTextFile(Integer.toString(mapGenArr[blockRow][3]));
			int[][] mapFive =loadFromTextFile(Integer.toString(mapGenArr[blockRow][4]));

			for(int blockY = 0; blockY < 16; blockY++){
				for(int mapNum = 0; mapNum < 5; mapNum++){
					for(int blockX = 0; blockX < 20; blockX++){
						if(mapNum == 0){
							fullMap[mapNum*20+blockX][16*blockRow+blockY] = mapOne[blockX][blockY];
						}
						if(mapNum == 1){
							fullMap[mapNum*20+blockX][16*blockRow+blockY] = mapTwo[blockX][blockY];
						}
						if(mapNum == 2){
							fullMap[mapNum*20+blockX][16*blockRow+blockY] = mapThree[blockX][blockY];
						}
						if(mapNum == 3){
							fullMap[mapNum*20+blockX][16*blockRow+blockY] = mapFour[blockX][blockY];
						}
						if(mapNum == 4){
							fullMap[mapNum*20+blockX][16*blockRow+blockY] = mapFive[blockX][blockY];
						}
					}
				}
			}
		}

	}

	public int[][] loadFromTextFile(String fileName){
		int[][] map;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("Maps/" + fileName));	

			int width = 20;
			int height = 16;

			map = new int[width][height];
			for(int y = 0; y < height; y++) {
				String line = reader.readLine();
				String[] lineArrLoop = line.split("");
				for(int x = 0; x < width; x++) {
					map[x][y] = Integer.parseInt(lineArrLoop[x]);
				}
			}

			reader.close();

			return map;

		}catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return null;
		}	

	}
	
	public int[][] getMap(){
		return fullMap;
	}



}
