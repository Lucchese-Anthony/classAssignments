import java.util.Scanner;

public class newConway {

    boolean[][] liveGame;
    boolean[][] nextGame;

    static char alive = '1';
    static char dead = '0';

    static int bestFit = 0;

    public static void main(String[] args) {
        int iterateTimes = 0;


        boolean[][] liveGame = new boolean[32][32];
        boolean[][] nextGame = new boolean[32][32];
        init(liveGame, nextGame);


        System.out.print("which design? (1/2/3): ");
        Scanner scanner = new Scanner(System.in);
        String design = scanner.nextLine();
        scanner.close();
        if(design.equals("1")) {
            liveGame[16][12] = true;
            liveGame[16][13] = true;
            liveGame[16][14] = true;
            liveGame[16][15] = true;
            liveGame[16][16] = true;
            liveGame[16][17] = true;
            liveGame[16][18] = true;
            liveGame[16][19] = true;
            designOneTwo(liveGame, nextGame);
        } else if (design.equals("2")) {
            liveGame[14][14] = true;
            liveGame[15][13] = true;
            liveGame[15][14] = true;
            liveGame[15][15] = true;
            liveGame[16][13] = true;
            liveGame[16][15] = true;
            liveGame[17][14] = true;
            designOneTwo(liveGame, nextGame);
        } else {
            while(true) {
                newIterations(liveGame, nextGame, iterateTimes);
                iterateTimes++;

            }
        }
    }

    public static void iterate(boolean[][] array, boolean[][] nextArray) {
        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                checkStatus(i, j, array, nextArray);
            }
        }
    }

    public static int fitnessCount(boolean[][] array) {
        int counter = 0;
        for (int i = 0; i <= 31; i++) {
            for (int j = 0; j <= 31; j++) {
                if(array[i][j]) {
                    counter++;
                }
            }
        }return counter;
    }

    public static void createRandomEight(boolean[][] array){

        for(int i = 12; i <= 19; i++){
            for(int j = 12; j <= 19 ; j++) {
                array[i][j] = (Math.random() < 0.5);
            }
        }

    }

    public static void checkStatus(int x, int y, boolean[][] array, boolean[][] nextArray) {
        boolean cell = array[x][y];
        int NofN = neighbors(x, y, array);
        if (cell) {
            nextArray[x][y] = NofN >= 3 && NofN <= 4;
        } else {
            nextArray[x][y] = NofN == 3;
        }
    }

    public static int neighbors(int x, int y, boolean[][] array) {
        int counter = 0;
        for (int i = x - 1; i <= x+ 1; i++ ) {
            for (int j = y - 1; j <= y+1; j++) {
                if (array[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void init(boolean[][] array, boolean[][] nextArray) {
        //initializes the array to all false
        for (int i = 0; i <= 31; i++) {
            for (int j = 0; j <= 31; j++) {
                array[i][j] = false;
                nextArray[i][j] = false;
            }
        }
    }

    public static char charReturn(boolean value) {
        char result;
        if (value) {
            result = alive;
        } else {result = dead;}
        return result;
    }

    public static String printEight(boolean[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 12; i <= 19; i++) {
            for (int j = 12; j<= 19; j++) {
                result.append(charReturn(array[i][j]));
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String printFull(boolean[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 31; i++) {
            for (int j = 0; j<= 31; j++) {
                result.append(charReturn(array[i][j]));
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String hex(boolean[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 12 ; i <= 19 ; i++){
            StringBuilder hex = new StringBuilder();
            for (int j = 12 ; j <= 19 ; j = j+4){
                int k = 0;
                if (array[i][j]) {k = k+8;}
                if (array[i][j+1]) {k = k+4;}
                if (array[i][j+2]) {k = k+2;}
                if (array[i][j+3]) {k = k+1;}
                hex.append(hexConverter(k));
            }
            result.append(hex).append(", ");
        }
        return result.toString();
    }

    //just a switch statement used in Hexadecimal();
    public static String hexConverter(int i){
        return switch (i) {
            case (10) -> "A";
            case (11) -> "B";
            case (12) -> "C";
            case (13) -> "D";
            case (14) -> "E";
            case (15) -> "F";
            default -> (i + "");
        };
    }

    public static void designOneTwo(boolean[][] array, boolean[][] nextArray) {
        for (int i = 0; i <= 1000; i++) {
            iterate(array, nextArray);
            array = nextArray.clone();
            nextArray = new boolean[32][32];
            int fit = fitnessCount(array);
            if(fit != bestFit) {
                bestFit = fit;
                System.out.println("New Best Fitness: " + bestFit);
            }
        }
        System.out.println("Overall best fitness: " + bestFit);
    }

    public static void newIterations(boolean[][] array, boolean[][] nextArray, int iterateTimes) {
        int localBestFit = 0;
        String startingHex = hex(array);
        createRandomEight(array);
        for (int i = 0; i <= 1000; i++) {
            iterate(array, nextArray);
            array = nextArray.clone();
            nextArray = new boolean[32][32];
            int fit = fitnessCount(array);
            if(fit != localBestFit) {
                localBestFit = fit;
            }
        }if (localBestFit > bestFit) {
            bestFit = localBestFit;
            System.out.println("New best fitness: " + bestFit + "\nIteration: " + iterateTimes + "\n" + startingHex);
        }
    }

}
