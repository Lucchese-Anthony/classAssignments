/* PL_With_C.java (Positional List with Cursors)
** An instance of an implementing class represents a list in which one
** uses a cursor (specifically, an instance of a class that implements the
** interface PositionalListCursor) in order to navigate among (and access 
** the data items associated to) the nodes in the list.
**
** Author: R. McCloskey
** Date: 2012
*/
public interface PL_With_C<T> {

   /** Reports whether or not this list has any items in it.
   */
   boolean isEmpty();

   /** Reports the number of items in this list.
   */
   int lengthOf();

   /** Returns a new cursor for this list.
   */
   PLC<T> getCursor();

}
