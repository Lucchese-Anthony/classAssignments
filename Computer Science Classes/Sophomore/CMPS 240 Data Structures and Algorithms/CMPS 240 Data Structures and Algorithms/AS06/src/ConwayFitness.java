import java.util.Random;

public class ConwayFitness {
	private int Boardsize;
	private int generation;
	public static boolean [][] liveGame;
	private int bestFitness;
	private boolean [][] bestBoard;
	static int iterations;
	final static char deadNeighbors = '0';
	static int currBest = 0;
	static int Best = 0;
	
	
	public ConwayFitness () {
		bestFitness = 0;
		generation = 0;
		bestBoard = new boolean[8][8];
		liveGame = new boolean [32][32];
		Boardsize = 32;
		iterations = 1;
	}
	
	public void setTrue(int x, int y) {
		liveGame [x][y] = true;
	}
	
	public void clearBoard () {
		for (int i = 0 ; i < Boardsize ; i++) {
			for (int j = 1 ; j < Boardsize-1 ; j++) {
				liveGame[i][j] = false;
			}
		}
	}
	public void printGraph() {
		for (int i = 12 ; i < 20 ; i++) {
			for (int j = 12 ; j < 20 ; j++) {
				if (liveGame[i][j]) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		ConwayFitness fit = new ConwayFitness();
		for(int i = 12 ; i < 20 ; i++) {//sets design 1
			fit.setTrue(16, i);
		}
		System.out.println("Design 1: \nHex Code: ");
		fit.printHex();
		System.out.println("\nUser Friendly");
		fit.printGraph();
		for (int i = 0 ; i < 1000 ; i++) {
			fit.next();
		}
		int fitness = fit.fitness();
		if (fitness > fit.bestFitness) {
			fit.generation++;
			fit.bestFitness = fitness;
			System.out.print( "fitness = " + fitness);
			System.out.println();
			iterations = 0;
		}
		else {
			iterations++;
		}
		fit.clearBoard();
		//next design (2)
		fit.setTrue(14, 13);
		fit.setTrue(15, 12);
		fit.setTrue(15, 13);
		fit.setTrue(15, 14);
		fit.setTrue(16, 12);
		fit.setTrue(16, 14);
		fit.setTrue(17, 13);
		System.out.println("Design 2: ");
		fit.printHex();
		fit.printGraph();
		
		
		for (int i = 0 ; i < 1000 ; i++) {
			fit.next();
		}
		fitness = fit.fitness();
		if (fitness > fit.bestFitness) {
			fit.generation++;
			fit.bestFitness = fitness;
			System.out.println();
			iterations = 0;
		}
		else {
			iterations++;
		}
		System.out.print("fitness = " + fitness);
		System.out.println();
		fit.generation = 0;
		fit.clearBoard();
		fit.run(liveGame);
	}
	public void run(boolean[][] liveGame) {
		int counter = 0;
		Random rand = new Random();
		while (counter < 500000) {
			clearBoard();
			boolean [][] newBoard = new boolean [8][8];
			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					if(rand.nextInt(2) == 1) {
						newBoard[i][j] = true;
						setTrue(i+12,j+12);
					}
				}
			}
			for (int i = 0 ; i < 1000 ; i++) {
				next();
			}
			int fitness = fitness();
			if (fitness > bestFitness) {
				generation++;
				bestFitness = fitness;
				bestBoard = newBoard;
				System.out.print("New Best Fitness of " + fitness + " : " + smallHex(newBoard));
				System.out.println();
				counter = 0;
			} else {
				counter++;
			}
		}
	}
	
	public String hexadecimal(int a) {
		String result = "";
		if(a ==0){
			result = "0";
		}else if (a == 1 ){
			result = "1";
		}else if(a==2){
			result = "2";
		}else if(a==3){
			result = "3";
		}else if(a==4){
			result = "4";
		}else if(a==5){
			result = "5";
		}else if(a==6){
			result = "6";
		}else if(a==7){
			result = "7";
		}else if(a==8){
			result = "8";
		}else if(a==9){
			result = "9";
		}else if(a==10){
			result = "A";
		}else if(a==11){
			result = "B";
		}else if(a==12){
			result = "C";
		}else if(a==13){
			result = "D";
		}else if(a==14){
			result = "E";
		}else{
			result = "F";
		}
		return result;
	}
	public void printHex() {
		for (int i = 12 ; i < 20 ; i++) {
			String hex = "";
			for (int j = 12 ; j < 20 ; j = j+4) {
				int k = 0;
				if (liveGame[i][j]) {k = k+8;}
				if (liveGame[i][j+1]) {k = k+4;}
				if (liveGame[i][j+2]) {k = k+2;}
				if (liveGame[i][j+3]) {k = k+1;}
				hex = hex + hexadecimal(k);
			}
			System.out.print(hex + " ");
		}
		System.out.println();
		}
	public void next() {
		int counter;
		boolean[][] Board1 = new boolean[Boardsize][Boardsize];
		for (int i = 1 ; i < Boardsize - 1 ; i++) {
			for (int j = 1 ; j < Boardsize - 1 ; j++) {
				counter = 0;
				for (int i1 = i - 1 ; i1 < i + 2 ; i1++) {
					for (int j1 = j - 1; j1 < j + 2 ; j1++) {
						if ((liveGame[i1][j1] && !(i1 == i && j1 == j))) {
							counter++;
						}
					}
				}
				Board1[i][j] = ((counter == 3) || (counter == 2 &&
						liveGame[i][j]));
			}
		}
		liveGame = Board1;
		}
	public int fitness() {
		int alive = 0;
		for (int i = 1 ; i < Boardsize - 1 ; i++) {
			for (int j = 1 ; j < Boardsize - 1 ; j++) {
				if(liveGame[i][j]) {
					alive++;
				}
			}
		}
		return alive;
		}
	public String smallHex(boolean [][] b) {
		String hex = "";
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j = j+4) {
				int k = 0;
				if (b[i][j]) {k = k+8;}
				if (b[i][j+1]) {k = k+4;}
				if (b[i][j+2]) {k = k+2;}
				if (b[i][j+3]) {k = k+1;}
				hex = hex + hexadecimal(k);
			}
			hex = hex + " ";
		}
		return hex;
	}
	
}