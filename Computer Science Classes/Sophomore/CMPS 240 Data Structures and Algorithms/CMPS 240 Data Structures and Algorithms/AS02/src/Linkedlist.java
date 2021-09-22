public class Linkedlist {
	
	static Link head;
	static int counter;
	public Linkedlist(){
		head = null;
	}
	
	public static void main(String[] args) {
		push(2);
		push(1);
		dumpstack();
		push(3);
		push(10);
		pop();
		push(15);
		dumpstack();
		pop();
		pop();
		dumpstack();
		pop();
		pop();
		pop();
		dumpstack();
	}
	
	public static void pop() {
		if (head != null) {
			head = head.next;
			
			counter--;
		}
	}
	
	public static void push(int a){
		Link newLink = new Link(a);
		newLink.next = head;
		head = newLink;
		counter++;
	}
	
	public static void dumpstack(){
		Link temp = head;
		if (head == null) {
			System.out.println("empty");
		}
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		} 
		System.out.println();
	}
}

