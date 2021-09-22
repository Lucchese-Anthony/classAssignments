/* PLC.java (Positional List Cursor)
** An instance of an implementing class serves as a cursor within a
** list represented by an instance of a class that implements the
** PL_With_C (Positional List With Cursors) interface.  A cursor is 
** used for navigating among and accessing the items in such a list.
**
** Author: R. McCloskey
** Date: 2012
*/

public interface PLC<T> extends Cloneable {
   

   /****  observers  ****/

   /* Reports whether or not this cursor is at the front of its list. 
   */
   boolean atFront();


   /* Reports whether or not this cursor is at the rear of its list.
   */
   boolean atRear();


   /* Returns the item associated to the node at which this cursor is
   ** positioned.
   ** excep: if atRear(), throws PLC_Exception 
   */
   T getItem() throws PLC_Exception;


   /* Reports whether or not this cursor is at the same position as the
   ** specified cursor.
   */
   boolean equals(PLC<T> cur);


   /* Returns (a reference to) the list within which this cursor lies.
   */
   PL_With_C<T> getList(); 


   /****  navigation mutators  ****/


   /* Places this cursor at the front of its list and returns a reference
   ** to itself.
   ** post: atFront()
   */
   PLC<T> toFront(); 


   /* Places this cursor at the rear of its list and returns a reference
   ** to itself.
   ** post: atRear()
   */
   PLC<T> toRear();


   /* Moves this cursor one position towards the rear of its list and
   ** returns a reference to itself.
   ** excep: if atRear(), throws a PLC_Exception 
   */
   PLC<T> toNext() throws PLC_Exception;


   /* Moves this cursor one position towards the front of its list
   ** and returns a reference to itself.
   ** excep: if atFront(), throws PositionalListCursorException 
   */
   PLC<T> toPrev() throws PLC_Exception;


   /* Moves this cursor to the same position as the given cursor
   ** and returns a reference to itself.
   ** post: equals(cur)
   ** excep: if getList() != cur.getList(), throws IllegalArgumentException
   */
   PLC<T> setTo(PLC<T> cur);


   /* Signals that this cursor logically has ceased to exist.
   */
   void dispose();


   /***  list mutation  ****/


   /* Inserts into this cursor's list a new node that becomes the predecessor
   ** of this cursor's position and that "contains" the specified item.
   */
   void insert(T item);


   /* Removes from this cursor's list the node at the cursor's position
   ** and returns the item "contained" in that node; the cursor's new
   ** position is what had been its successor.
   ** excep: if atRear(), throws PositionalListCursorException 
   */
   T remove() throws PLC_Exception;


   /* Replaces the item "contained" in the node at this cursor's position 
   ** by the specified item and returns (a reference to) the replaced item.
   ** excep: if atRear(), throws PLC_Exception 
   */
   T replace(T item) throws PLC_Exception;


   /** Swaps the items contained in the nodes indicated by this cursor and 
   **  the specified cursor.
   **  excep: if atRear() or c.atRear(), throws PLC_Exception 
   */
   void swapItems(PLC<T> c);


   /****  clone  ****/

   /** Returns a new cursor that is identical to this one.
   */
   PLC<T> clone();
}

