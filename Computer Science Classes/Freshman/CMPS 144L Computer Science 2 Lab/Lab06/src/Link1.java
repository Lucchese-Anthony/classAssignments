/** An instance of this class contains a reference to an object of the
**  specified type T (the generic type parameter) and a reference to
**  an object of the same kind (i.e., Link1).  The idea is that objects
**  of this class can be used as building blocks to form one-directional 
**  linked structures (i.e., one-way lists).
*/
public class Link1<T> { 

   // instance variables 
   // ------------------

   public T item;
   public Link1<T> next;

 
   // constructors
   // ------------

   public Link1(T item, Link1<T> next) { 
      this.item = item; this.next = next;
   }

   public Link1(T item) { this(item, null); }

   public Link1() { this(null, null); }

}
