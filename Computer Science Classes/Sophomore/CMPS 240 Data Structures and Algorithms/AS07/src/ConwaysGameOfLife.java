public class ConwaysGameOfLife {

    static Boolean[][] gameLive;

    final static char alive = '1';
    final static char dead = '0';


    static int localBestFitness = 0;
    static int iterateTimes = 1;

    static int totalBestFitness = 0;

    public static void main(String[] args) {

        gameLive = new Boolean[32][32];
        insertFalse(gameLive);
        /*
        //Design 1:
        //only used in design 1
        gameLive[16][12] = true;
        gameLive[16][13] = true;
        gameLive[16][14] = true;
        gameLive[16][15] = true;
        gameLive[16][16] = true;
        gameLive[16][17] = true;
        gameLive[16][18] = true;
        gameLive[16][19] = true;


        //Design 2:
        //only used in design 2
        gameLive[14][14] = true;
        gameLive[15][13] = true;
        gameLive[15][14] = true;
        gameLive[15][15] = true;
        gameLive[16][13] = true;
        gameLive[16][15] = true;
        gameLive[16][18] = true;
        */

        /*
        //this while loop is only used in design 1 and 2
        while(iterateTimes < 1000) {
            iteration(gameLive);
            findBestFit(gameLive);
            if (localBestFitness > totalBestFitness) {
                totalBestFitness = localBestFitness;
                nicePrint(gameLive);
                Hexadecimal(gameLive);
                System.out.println("new best fitness: " + totalBestFitness);
            }
            iterateTimes++;
        }

        */
        //this while loop and methods are only used on rand 8x8
        insertFalse(gameLive);
        createRandomEight(gameLive);
        while(true) {
            newIterations(gameLive);
            iterateTimes++;

        }
    }
    //does 1000 iterations, and prints if there is a better fitness, only used in Rand 8x8
    public static void newIterations(Boolean[][] array) {
        localBestFitness = 0;
        createRandomEight(array);
        String startingHex = Hexadecimal(array);

        for (int i = 0; i <= 1000; i++) {
            iteration(array);
            findBestFit(array);

        }
        if (totalBestFitness < localBestFitness) {
            totalBestFitness = localBestFitness;
            System.out.println("New Best Fitness: " + totalBestFitness);
            System.out.println("Iteration: " + iterateTimes);
            System.out.println(startingHex);
            nicePrint(array);
        }
    }

    public static void insertFalse(Boolean[][] array) {
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < 32; j++){
                array[i][j] = false;
            }
        }
    }

    public static void findBestFit(Boolean[][] array){
        int count = 0;
        for(int i = 0; i < 32; i++){
            for (int j = 0; j < 32; j++) {
                if (array[i][j]) {
                    count++;
                }
            }
        }
        if (count > localBestFitness) {
            localBestFitness = count;

        }
    }

    //uses the math.random function to generate a random boolean, only used for Rand 8x8
    public static void createRandomEight(Boolean[][] array){
        for(int i = 12; i <= 19; i++){
            for(int j = 12; j <= 19 ; j++) {
                array[i][j] = (Math.random() < 0.5);
            }
        }

    }
    public static char returnslive(Boolean cell) {
        if(cell){
            return alive;
        } else return dead;
    }
    //finds if the cell either keeps living, dies, stays dead, or comes alive
    public static Boolean status(int x, int y, Boolean[][] array){
        Boolean cell = array[x][y];
        int neighbors = neighbors(x, y, array);
        if (cell) {
            return neighbors == 3 || neighbors == 2;
        } else {
            return neighbors == 3;
        }
    }
    //returns number of neighbors
    public static int neighbors(int x, int y, Boolean[][] array){
        int counter = 0;
        StringBuilder result = new StringBuilder();
        for(int i = (x - 1); i < (x + 2); i++){
            for(int j = (y - 1); j < (y + 2); j++){
                boolean isTrue = false;
                if(array[i][j] && !(x == i && y == j)){
                    counter++;
                }

            }
        }
        return counter;
    }

    //a single iteration of conways game of life
    public static void iteration(Boolean[][] array) {
        Boolean[][] newGame = new Boolean[32][32];
        insertFalse(newGame);
        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <=  30; j++) {
                newGame[i][j] = status(i, j, array);
            }
        }
        gameLive = newGame;
    }

    //prints only the 8x8 in user friend
    public static void nicePrint(Boolean[][] array) {
        int counter = 1;
        for(int i = 0; i <= 31; i++){
            for(int j = 0; j <= 31; j++) {
                System.out.print(returnslive(array[i][j]));
            } System.out.println();
        }

    }
    //prints only the 8x8 in hex
    public static String Hexadecimal(Boolean[][] array) {
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
    //used when need to print everything
    public static void printGame(Boolean[][] array){
        nicePrint(array);
        Hexadecimal(array);
        System.out.println();
    }

}
