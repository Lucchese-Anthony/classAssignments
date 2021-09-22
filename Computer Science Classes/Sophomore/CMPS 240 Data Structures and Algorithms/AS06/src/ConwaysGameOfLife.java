public class ConwaysGameOfLife {
	
	static Boolean[][] gameLive; 
	
	final static char alive = '-'; 
	final static char dead = '_';
	public static void main(String[] args) {
		gameLive = new Boolean[32][32];
		
		insertFalse(gameLive);
		
		gameLive[8][13] = true;
		gameLive[8][14] = true;
		gameLive[9][13] = true;
		gameLive[9][14] = true;
		gameLive[10][15] = true;
		gameLive[10][16] = true;
		gameLive[11][15] = true;
		gameLive[11][16] = true;
		
		
		iteration();
		printGame(gameLive);
		
		iteration();
		printGame(gameLive);
		
		System.out.println("Done!");
	}
	
	public static void insertFalse(Boolean[][] array) {
		for(int i = 0; i < 32; i++){
			for(int j = 0; j < 32; j++){
				array[i][j] = false;
			}
		}
	}
	
	public static void printGame(Boolean[][] array){
		for(int i = 0; i < 32; i++){
			for(int j = 0; j < 32; j++){
				if(array[i][j]){
					System.out.print(alive);
				} else {
					System.out.print(dead);
				}
			}System.out.println();
		}
		System.out.println();
		for (int i = 0 ; i < 32 ; i++){
			String hex = "";
			for (int j = 0 ; j < 32 ; j = j+4){
				int k = 0;
				if (array[i][j]) {k = k+8;}
				if (array[i][j+1]) {k = k+4;}
				if (array[i][j+2]) {k = k+2;}
				if (array[i][j+3]) {k = k+1;}
				hex = hex + hexConverter(k);
				}
			System.out.println(hex);
			}
		}
	public static String hexConverter(int i){
		switch(i){
		case (10):
			return "A";
		case (11):
			return "B";
		case (12):
			return "C";
		case (13):
			return "D";
		case (14):
			return "E";
		case (15):
			return "F";
		}
		String val = (i + "");
		return val;
		}
	
	
	
	public static Boolean status(int x, int y){
		Boolean cell = gameLive[x][y];
		int neighbors = neighbors(x, y);
		if (cell) {
			if(neighbors > 3 || neighbors < 2) {
				return false;
			} else return true;
		} else {
			if(neighbors == 3) {
				return true;
			} else return false;
		}
	} 	
	 public static int neighbors(int x, int y){
		 int counter = 0;
		 for(int i = (x - 1); i < (x + 2); i++){
			 for(int j = (y - 1); j < (y + 2); j++){
				 if(gameLive[i][j] && !(x == i && y == j)){
					 counter++;
					 }
				 }
			 }
		 return counter;
		 }
	public static void iteration() {
		Boolean[][] newGame = new Boolean[32][32];
		insertFalse(newGame);
		for (int i = 1; i <= 30; i++) {
			for (int j = 1; j <=  30; j++) {
				newGame[i][j] = status(i, j);
			}
		}
		gameLive = newGame;
		
	}
	
}
