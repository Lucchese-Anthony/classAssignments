/* Instances of this class have the same basic capabilities as instances
** of the java.util.ArrayList class, but ONLY the most basic capabilities.
** That is, an instance of this class represents a list (or sequence, if
** you prefer) whose elements are referred to by their positions (numbered 
** starting at zero) and in which element insertions, removals, and 
** replacements can be effected at any position.
**
** Author: R. McCloskey
** Date: March 2019
*/

public class AryListViaLink1<T> {

   // instance variable
   // -----------------

   private Link1<T> dummy;   // reference to dummy node 


   // constructors
   // ------------

   /* Initializes this AryListViaLink1 object by placing into it the
   ** elements in the given array.
   **
   ** post: this.get(k) == ary[k] for all k in [0..ary.length),
   **       this.lengthOf() == ary.length
   */
   public AryListViaLink1(T[] ary) {
      dummy = new Link1(null,null);
      Link1<T> pntr = dummy;
      for (int i=0; i != ary.length; i++) {
         pntr.next = new Link1<T>(ary[i]);
         pntr = pntr.next;
      }
   }
   // Note: The following is equivalent to the body of the for-loop above:
   //   pntr.next = new Link1<T>(); // creates a new node with null values
   //   pntr = pntr.next;           // advances pntr to point to the new node
   //   pntr.item = ary[i];         // places the desired item into the new node
   

   /* Initializes this AryListViaLink1 object to have no elements in it.
   ** post: this.lengthOf() == 0
   */
   public AryListViaLink1() { dummy = new Link1(null,null); }


   // observers
   // ---------

   /* Returns the length (i.e., # of elements in) this list.
   */
   public int lengthOf() {
	   int lengthOfary = 0;
	   Link1<T> pntr = dummy.next;    // start pntr at 0-th position
	      while (pntr != null) {
	         pntr = pntr.next;
	         lengthOfary++;
	      }
      return lengthOfary;
   }
   

   /* Returns the element at position k of this list.
   ** pre: 0 <= k < this.lengthOf()
   */
   public T get(int k) {
      return find(k).item;   // or find(k).getItem();
   }

   /* Displays the elements in the specified sublist of this list, starting
   ** at position 'low' and going up to, but not including, position 'high'.
   ** (The displayed elements are separated by spaces.)
   **
   ** pre: 0 <= low <= high <= this.lengthOf()
   */
   public void display(int low, int high) { 
      // STUB!!  (lowest priority)
   }

   /* Displays all the elements of this list (separated by spaces).
   */
   public void display() { 
      Link1<T> pntr = dummy.next;    // start pntr at 0-th position
      while (pntr != null) {
         System.out.print(pntr.item + " ");
         pntr = pntr.next;
      }
   }
   // Assuming that the previous version of display() works, the 
   // code for this one should be this one-liner:
   //    display(0, lengthOf());



   // mutators
   // --------

   /* Inserts a new element containing the specified item (item) into the 
   ** list at the specified position (k).
   **  
   ** post: For all i<k, get(i) yields the same value as before.
   **       get(k) yields item. 
   **       For all i>k, get(i) yields what get(i-1) did before.
   */
   public void insert(int k, T item) {
	   Link1<T> newItem = find(k-1);
	   Link1<T> newNewItem = newItem.next;
	   newNewItem.item = item;
	   newNewItem.next = find(k+1);
   }


   /* Inserts a new element containing the specified item at the end of
   ** this list.
   */
   public void append(T item) { insert(lengthOf(), item); }


   /* Deletes the element at the specified position (k) of this list
   ** and returns a reference to the deleted element.
   **
   ** pre: 0 <= k < this.lengthOf()
   ** post: For all i<k, get(i) yields same value as before.
   **       For all i>=k, get(i) yields what get(i+1) did before.
   */
   public T delete(int k) {
      Link1<T> deletedItem = find(k);
      find(k-1).next = deletedItem.next;
      return deletedItem.item;
   }

   /* Replaces the element at the specified position (k) with the
   ** specified element (item).
   */
   public void replace(int k, T item) {
      Link1<T> pntr = find(k);
      pntr.item = item;
   }


   /* Reverses this list. 
   */
   public void tsil() {
      if (this.lengthOf() > 1) {
         Link1<T> pntr = dummy.next;    // make pntr point to 0th list node
         Link1<T> pntrSucc = pntr.next; // make pntrSucc point to 1st list node

         // missing code here to make 0th node last

         while (pntrSucc != null) {

            // missing loop body

         }

         // missing code here to bring things to a close

      }
   }


   // private utilities
   // -----------------

   /* Returns a reference to the Link1 node that holds the element at 
   ** position k of this list (or to the dummy node if k == -1).
   ** (Note that positions are numbered beginning with zero.)
   ** pre: -1 <= k < this.lengthOf()
   */
   private Link1<T> find(int k) {
      Link1<T> pntr = dummy;
      for (int i=-1; i != k; i++) {
         pntr = pntr.next;              // or pntr = pntr.getNext();
      }
      return pntr;
   }


   // main() method, for testing purposes
   // -----------------------------------

   public static void main(String[] args)
   {
      // Create a list containing a phrase.
      String[] strAry = new String[] { "The", "cat", "in", "the", "hat" };
      AryListViaLink1<String> aList = new AryListViaLink1(strAry);

      System.out.println("Initial list is:");
      aList.display(); System.out.println();

      aList.insert(4, "big");
      aList.insert(1, "stupid");
      System.out.println("\nAfter inserting \"big\" at 3 and" +
                         " \"stupid\" at 1:\n  ");
      aList.display();  System.out.println();

      aList.delete(5);
      System.out.println("\nAfter deleting 5th item:\n   ");
      aList.display();  System.out.println();

      aList.replace(1, "idiotic");
      System.out.println("\nAfter replacing 1st item with \"idiotic\":\n");
      aList.display();  System.out.println();
   }

}
