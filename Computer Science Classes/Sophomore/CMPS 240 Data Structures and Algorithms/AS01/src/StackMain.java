public class StackMain {
	
	 static int counter = 0;
	 static int stackArray[] = new int[10];
	
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
	
	public static void pop(){
		if(counter > 0){
			stackArray[counter] = -1;
			counter--;
		}
	}
	
	public static void push(int a) {
		if(counter < 10) {
			stackArray[counter] = a;
			counter++;
		}
	}
	
	public static void dumpstack(){
		if(counter == 0) {
			System.out.println("array is empty");
		}
		for(int i = counter - 1; i >= 0; i--) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
		
	}
}
