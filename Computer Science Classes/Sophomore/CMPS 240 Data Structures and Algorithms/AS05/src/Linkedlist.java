public class Linkedlist {
	
	static Link head;
	static Link tail;
	public Linkedlist(){
		head = null;
		tail = null;
	}
	
	public static int dequeue() {
		int temp = 0;
		if(head != null) {
			temp = head.value;
			head = head.next;	
		}
		return temp;
	}
	public void enqueue(int a){
		Link newLink = new Link(a);
		if(tail == null) {
			head = newLink;
			tail = newLink;
		} else {
			newLink = tail.next;
			tail = newLink;
		}
		
		
	}
	

	
}