import java.util.Scanner;

/* Java application for testing recursive methods that operate upon a
** linked structure of nodes from the Link1 class.
*/
public class Link1RecTester {

   // methods of interest
   // -------------------

   /* Returns a reference to the first node in a linked list of Link1 nodes
   ** containing, in order, the integers in the range [0..m).
   ** (In particular, if m == 0, the null value is returned.)
   ** pre: m>=0
   */
   public static Link1<Integer> buildList(int m) {
      return buildList(0,m);  // call the analogous, but more general method
   }

   /* Returns a reference to the first node in a linked list of Link1 nodes 
   ** containing, in order, the integers in the range [m..n).  
   ** (In particular, if m == n, the null value is returned.)
   ** (This method generalizes the one above.)
   ** pre: m <= n
   */
   public static Link1<Integer> buildList(int m, int n) {
      if (m == n) { 
         return null;
      }
      else {
         Link1<Integer> tail = buildList(m+1,n);
         return new Link1<Integer>(m, tail);
      }
   }

    /* Returns the length of the linked structure to which the given 
   ** reference points.
   */
   static int counter = 1;
   public static int lengthOf(Link1 p) {
	   if(p.getNext() != null) {
		   counter++;
		   lengthOf(p.getNext());
	   }
	   return counter;
   }

   /* Prints the elements in the linked structure beginning with
   ** the Link1 object referred to by p.
   */
   public static void printList(Link1 p) {
      System.out.print(p.getItem() + printList(p.getNext()));
      //didnt finish, just an idea
   }

   /* Prints, in reverse order, the elements in the linked structure
   ** beginning with the Link1 object referred to by p.
   */
   public static void printReverseList(Link1 p) {
      System.out.print(printReverseList(p.getNext() + p.getItem()));
      //also didnt finish, just ideas
   }


   // main() method for testing purposes
   // ----------------------------------

   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in); 
      System.out.print("Enter a nonnegative integer: ");
      int n = keyboard.nextInt();

      System.out.printf("\nBuilding a list containing 0..%d\n", n-1);
      Link1<Integer> p = buildList(n);

      System.out.println("\nComputing length of the list...");
      System.out.println("Length of list is " + lengthOf(p));

      System.out.println("\nPrinting elements in list...");
      printList(p);
      System.out.println();

      System.out.println("\nPrinting elements in reverse order...");
      printReverseList(p);
      System.out.println();

      System.out.println("\nGoodbye.");
   }

}
