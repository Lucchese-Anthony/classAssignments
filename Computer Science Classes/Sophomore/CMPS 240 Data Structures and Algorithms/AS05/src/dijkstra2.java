import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dijkstra2 {
	
	static Linkedlist queue = new Linkedlist();
	
	static int[][] nodeArray;
	static int[] arrayDistances;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		nodeArray = new int[6][6];
		arrayDistances = new int[6];
		File text = new File("C:\\Users\\thesh\\school\\Notes\\sophomore year\\CMPS 240\\AS05\\src\\matrix.txt");
		Scanner scan = new Scanner(text);
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				nodeArray[i][j] = scan.nextInt();
			}
		}
		
		for(int i = 0; i < 6; i++) {
			arrayDistances[i] = -1;
		}
		
		algorithm(nodeArray);
		
		/*
		 for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(nodeArray[i][j] + " ");
				
			}
			System.out.println();
		}*/
	}
	
	public static void algorithm(int[][] nodeArray){
		
		queue.enqueue(0);
		while(queue.head != null) {
			int dq = queue.dequeue();
			for(int i = 0; i < 6; i++) {
				if(nodeArray[dq][i] != -1) {
					queue.enqueue(i);
					if(arrayDistances[i] == -1) {
						arrayDistances[i] = nodeArray[dq][i];
					} else arrayDistances[i] += nodeArray[dq][i];
				}
			}
			
			System.out.println("  " + arrayDistances[1] + " " + arrayDistances[2] +"\n" + arrayDistances[5] + " " + arrayDistances[0] + "  \n  " + arrayDistances[3] + " " + arrayDistances[4]+ "\n");
		}
	}
}

