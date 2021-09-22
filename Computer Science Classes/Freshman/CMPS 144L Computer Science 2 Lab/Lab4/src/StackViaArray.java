/* An instance of this generic class represents a stack capable of holding 
** objects of whatever type is specified by the client when creating it.
** The implementation is based on storing the stack items in an array.
** The stack is "bounded" in that its size is constrained not to exceed
** the value provided to the constructor. 
**
**  Author: R. McCloskey
*/

public class StackViaArray<T> {


   // instance variables
   // ------------------

   private int numItems;   // # items occupying the stack
   private T[] items;      // holds (references to) the items on the stack



   // constructors
   // ------------

   /* Initializes the stack to be empty and to have the capacity to hold
   ** the specified number of items.
   */
   public StackViaArray(int capacity)
   {
      numItems = 0;                         // Notice the tortured syntax for 
      items = (T[])(new Object[capacity]);  // creating an array of elements
   }                                        // of type T.


   // observers
   // ---------

   /* Returns the number of items on the stack.
   */
   public int sizeOf() { return numItems; }

   /* Reports whether or not there are no items on the stack.
   */
   public boolean isEmpty() { return sizeOf() == 0; }

   /* Returns the capacity of the stack (i.e., the maximum # of items 
   ** that can occupy it at any one time).
   */
   public int capacityOf() { return items.length; }

   /* Returns (a reference to) the item at the top of the stack.
   ** pre: !isEmpty()
   */
   public T topOf() { return items[numItems-1]; }

   /* Returns a String containing the "images" of the items on the stack, 
   ** nested between square brackets, going from top to bottom, and 
   ** separated by commas.  (E.g., "[5, 13, 8]")
   */
   public String toString() {
      String result = "";
      if (!isEmpty()) {
         StringBuilder s = new StringBuilder();
         s.append(items[numItems-1]);
         for (int i = numItems-2; i >= 0; i--)
         {
            s.append(", " + items[i]);
         }
         result = s.toString();
      }
      return '[' + result + ']';
   }


   // mutators
   // --------

   /* Places the specified item on top of the stack.
   ** pre: sizeOf() < capacityOf()
   */
   public void push( T item ) {
      //System.out.println("Pushing " + item);
      items[numItems] = item;
      numItems = numItems + 1;
   }

   /* Removes the item at the top of the stack and returns (a reference to) it.
   ** pre: !isEmpty()
   */
   public T pop() {
      T itemAtTop = topOf();
      //System.out.println("Popped " + itemAtTop);
      numItems = numItems - 1;
      items[numItems] = null;  // unnecessary, but it aids garbage collection
      return itemAtTop;
   }

}

