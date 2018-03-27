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
				int num = ran.nextInt(2) + 1;
				mapGenArr[i][y] = num;
				System.out.print(mapGenArr[i][y]);
			}
			System.out.println();
		}


		/*for(int i = 0; i < 5; i++){
			int[][] mapOne = loadFromTextFile(Integer.toString(mapGenArr[i][0]));
			int[][] mapTwo = loadFromTextFile(Integer.toString(mapGenArr[i][1]));
			int[][] mapThree = loadFromTextFile(Integer.toString(mapGenArr[i][2]));
			int[][] mapFour = loadFromTextFile(Integer.toString(mapGenArr[i][3]));
			int[][] mapFive =loadFromTextFile(Integer.toString(mapGenArr[i][4]));
			for(int h = 0; h < 5; h++){
				for(int z = 0; z < 16; z++){
					for(int k = 0; k < 20; k++){
						System.out.println(k);
						if(h == 0){
							fullMap[k][z] = mapOne[k][z];
						}
						if(h == 1){
							fullMap[k][z] = mapTwo[k][z];
						}
						if(h == 2){
							fullMap[k][z] = mapThree[k][z];
						}
						if(h == 3){
							fullMap[k][z] = mapFour[k][z];
						}
						if(h == 4){
							fullMap[k][z] = mapFive[k][z];
						}


					}
				}
			}	
		}*/
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


		for(int i = 0; i < 80; i++){
			for(int y = 0; y < 100; y++){
				System.out.print(fullMap[y][i]);
			}
			System.out.println();
		}

	}

	public int[][] loadFromTextFile(String fileName){
		int[][] map;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("Maps/" + fileName));	
			//String lineOne = reader.readLine();
			//String[] lineArr = lineOne.split(":");
			//this.width = Integer.parseInt(lineArr[0]);
			//this.height = Integer.parseInt(lineArr[1]);

			int width = 20;
			int height = 16;

			map = new int[width][height];
			//System.out.println(reader.readLine());
			for(int y = 0; y < height; y++) {
				String line = reader.readLine();
				//System.out.println(line);
				String[] lineArrLoop = line.split("");
				for(int x = 0; x < width; x++) {
					map[x][y] = Integer.parseInt(lineArrLoop[x]);
				}
			}

			/*for(int i = 0; i < 16-1; i++){
				for(int y = 0; y < 20; y++){
					System.out.print(map[y][i]);
				}
				System.out.println();
			}*/

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
