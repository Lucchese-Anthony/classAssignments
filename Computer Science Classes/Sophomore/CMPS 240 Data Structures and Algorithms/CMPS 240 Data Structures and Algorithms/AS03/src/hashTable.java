//Anthony Lucchese
//Professor Bishop


public class hashTable{

   public static int max = 10;
   public static Node[] arrayNode;

   public static void initialise(){
      arrayNode = new Node[max];
      for (int i = 0 ; i < max ; i++){
         arrayNode[i] = new Node(0);
      }  
   }
   
   public static class Node{
      int data;
      Node next;
      Node(int d){
         data = d;
         next = null;
      }
   } 

   public static int hash(int val){
      return(val%10);
   }

   public static void insert(int num){
	   //inserts a node
      int sort = hash(num);
      Node ptr = new Node(num);
      ptr.next = arrayNode[sort].next;
      arrayNode[sort].next = ptr;
   }
   
   public static void delete(int num){
	   //deletes a node
      int sort = hash(num);
      Node curr = arrayNode[sort];
         while(curr.next != null){
            if(curr.next.data == num){
               curr.next = curr.next.next;
            }
         }
   }
   
   public static void dumphash(){
	   //prints the hash table
      for (int i = 0 ; i < max ; i++){
         System.out.print(i + ": ");
         Node curr = arrayNode[i].next;
         while(curr != null){
            System.out.print(curr.data + "   ");
            curr = curr.next;
         }
         System.out.println();
      }
      System.out.println("\n----------\n");
   }

   public static void main(String[]args){
      initialise();
      insert(1);
      insert(5);
      insert(28);
      delete(5);
      insert(15);
      insert(8);
      dumphash();
      delete(1);
      insert(18);
      insert(25);
      delete(33);
      dumphash();            
   }
}

0: 
1: 1   
2: 
3: 
4: 
5: 15   
6: 
7: 
8: 8   28   
9: 

----------

0: 
1: 
2: 
3: 
4: 
5: 25   15   
6: 
7: 
8: 18   8   28   
9: 

----------