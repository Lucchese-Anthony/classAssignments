/* A utility class intended to be used as a building block for classes whose
** instances represent one-way linked structures (e.g., stacks, queues, lists).
** An instance of this class has two fields, one being of type T (the generic 
** type parameter) and the other being a reference to another Link1 object.
*/

public class Link1<T> {

   // instance variables    (Note that they are public)
   // ------------------
   public T item;         // a data item of interest
   public Link1<T> next;  // a reference to a successor node


   // constructors
   // ------------

   /* Initializes this new Link1 object to have the specified values
   ** in its two fields.
   */
   public Link1(T theItem, Link1<T> successor) {
      item = theItem;
      next = successor;
   }

   /* Initializes this new Link1 object to have the specified value
   ** in its 'item' field and null in its 'next' field.
   */
   public Link1(T theItem) { this(theItem, null); }


   // observers  (superfluous, given that the instance variables are public)
   // ---------

   /* Returns the value of the 'item' field.
   */
   public T getItem() { return item; }

   /* Returns the value of the 'next' field.
   */
   public Link1<T> getNext() { return next; }


   // mutators    (superfluous, given that the instance variables are public)
   // --------

   /* Replaces the value of the 'item' field with the value specified.
   */
   public void setItem(T newItem) { item = newItem; }

   /* Replaced the value of the 'next' field with the value specified.
   */
   public void setNext(Link1<T> newNext) { next = newNext; }

}
