public class Matrix {
    protected int nodeCount;
    protected int [][] paths;

    public Matrix (int i){
        nodeCount = i;
        paths = new int [i][i];
        for (int a = 0 ; a < i ; a++) {
            for (int b = 0 ; b < i ; b++) {
                paths [a][b] = -1;
            }
        }
    }

    public int getDistance(int i, int j) {
        return paths[i][j];
    }

    public void path(int from, int to, int cost) {
        paths[from][to] = cost;
    }

    public void removePaths(int to) {
        for (int i = 0 ; i < nodeCount ; i++) {
            paths[i][to] = -1;
        }
    }



}
