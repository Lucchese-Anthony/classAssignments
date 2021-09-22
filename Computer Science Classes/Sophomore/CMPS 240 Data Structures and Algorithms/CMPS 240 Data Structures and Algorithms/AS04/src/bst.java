//Anthony Lucchese
//Professor Bishop
//Due 9/30/20


public class bst {
		
	public static class Node {
		int data;
	    Node right;
	    Node left;
	    Node(int d){
	    	data = d;
	        right = null;
	        left = null;
	    }
   
	}
	
	static Node head = null;
	
	
	public static void main(String[] args) {
		insert(20);
		insert(10);
		insert(30);
		insert(5);
		insert(7);
		insert(21);
		dumptree();
		delete(20);
		delete(21);
		dumptree();
		delete(35);
		
		
	}
	
	public static Node add(int a, Node temp) {
		
		if(temp == null) {
			return new Node(a);
		} 
		if(a < temp.data){
			temp.left = add(a, temp.left);
		} else if (a > temp.data){
			temp.right = add(a, temp.right);
		} else {
			return temp;
		}
		return temp;
	}
	
	public static void insert(int a) {
		head = add(a, head);
	}
	
	public static Node deletion(Node temp, int a) {
		if(temp == null) {
			return null;
		}
		if(a == temp.data) {
			if(temp.left == null && temp.right == null) {
				return null;
			}
			if(temp.right == null) {
				return temp.left;
			}
			if(temp.left == null) {
				return temp.right;
			}
			int smallValue = smallValue(temp.right);
			temp.data = smallValue;
			temp.right = deletion(temp.right, smallValue);
			return temp;
			
		}
		if(a < temp.data) {
			temp.left = deletion(temp.left, a);
			return temp;
		}
		temp.right = deletion(temp.right, a);
		return temp;
	}
	
	public static void delete(int a) {
		head = deletion(head, a);
	}
	
	public static int smallValue(Node temp) {
		return temp.left == null ? temp.data : smallValue(temp.left);
	}
	
	public static void dumptree() {
		System.out.println("----------");
		printTree(head);
		
	}
	public static void printTree(Node temp) {
		if (temp == null) return;
        System.out.println(temp.data);
        printTree(temp.left);
        printTree(temp.right);
	}
	
	public static boolean locate(Node temp, int a) {
		if(temp == null) {
			return false;
		}
		if(a == temp.data) {
			return true;
		}
		return a < temp.data
		? locate(temp, a) : locate(temp, a);
	}
	
	public static boolean find(int a) {
		return locate(head, a);
	}
}
