public class Dijkstra extends Matrix{
    private int start;
    private Matrix matrix;
    private int[] distances;
    private boolean[] inGraph;
    private int counter = 1;

    public Dijkstra(int i, int s, Matrix g) {
        super(i);
        matrix = g;
        start = s;
        distances = new int[i];
        inGraph = new boolean[i];
        for (int a = 0 ; a < i ; a++) {
            distances[a] = 2147483000;
            inGraph[a] = false;
        }
        distances[s] = 0;
    }

    public boolean finished() {
        for (int i = 0 ; i < nodeCount ; i++) {
            if (!inGraph[i]) {
                return false;
            }
        }
        return true;
    }

    public void relax() {
        int node = 0; 
        int cost = 2147483647;
        for (int i = 0 ; i < nodeCount ; i++) {
            if(distances[i] < cost && !inGraph[i]) {
                node = i;
                cost = distances[i];
            }
        }
        inGraph[node] = true;
        for(int i = 0 ; i < nodeCount ; i++) {
            int dist = distances[node] + matrix.getDistance(node, i);
            if (!inGraph[i] && matrix.getDistance(node, i) != -1 &&dist < distances[i]) {
                int temp = matrix.getDistance(node, i);
                removePaths(i);
                path(node, i, temp);
                distances[i] = dist;
            }
        }
    }

    public void printDistances() {
        System.out.println("Iteration " + counter);
        for (int i = 0 ; i < nodeCount ; i++) {
            String distance = distances[i] +"";
            if (distances[i] == 2147483000) {
                distance = "infinite";
            }
            System.out.println("the distance from " + start + " to " + i +" is " + distance);
        }
        System.out.println();
        counter++;
    }
	public static void main(String[] args) {
        Matrix matrix =  new Matrix(6);
        matrix.path(0, 2, 3);
        matrix.path(1, 0, 4);
        matrix.path(1, 5, 2);
        matrix.path(2, 4, 3);
        matrix.path(3, 0, 6);
        matrix.path(3, 1, 1);
        matrix.path(3, 4, 10);
        matrix.path(5, 0, 1);
        Dijkstra algorithm = new Dijkstra(6, 3, matrix);
        while (!algorithm.finished()) {
            algorithm.relax();
            algorithm.printDistances();
        }
    }

}