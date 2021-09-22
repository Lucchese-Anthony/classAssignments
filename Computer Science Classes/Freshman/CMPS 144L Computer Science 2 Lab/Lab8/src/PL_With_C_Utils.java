/* PL_With_C_Utils.java
**
** Java class containing several utility methods having to do with 
** positional lists with cursors. 
**
** Author: R. McCloskey and Anthony Lucchese, Steven Prosperino, and Jacob Fink
** Date: Nov. 2018
*/
public class PL_With_C_Utils {

   /* Displays the items in the given list, from front to rear, each one 
   ** followed by the specified terminator String.
   */
   public static void printList(PL_With_C list, String terminator) {
      PLC cur = list.getCursor().toFront();
      while (!cur.atRear()) {
         System.out.print(cur.getItem() + terminator);
         cur.toNext();
      }
      System.out.println();
      cur.dispose();
   }

   /* Returns the length of (i.e., number of nodes in) the given list.
   */
   public static int lengthOf(PL_With_C list) {
      int cntr = 0;
      PLC c = list.getCursor();
      c.toFront();

      // loop invariant: cntr = # of nodes preceding c's position
      while ( !c.atRear() )  {
         cntr = cntr + 1;
         c.toNext();
      }
      c.dispose();
      return cntr;
   } 


   /* Returns a new list that contains the items in the given array, and
   ** in the same order.
   */
   public static <T> PL_With_C<T> listify(T[] ary)
   {
       PL_With_C<T> list = new PL_With_C_ViaArray();
       PLC<T> cursor = list.getCursor();
       cursor.toRear();  // not necessary, as a new cursor is already at rear

       // Insert each array element into the list.
       for (int i = 0; i != ary.length; i++) {
          cursor.insert(ary[i]);
       }
       return list;
   }

   /* Within the given list, removes any node whose predecessor contains
   ** an item equal to its own.
   */
   public static void removeAdjacentDuplicates(PL_With_C list)
   {
      if (list.lengthOf() > 1) {
         PLC pred = list.getCursor().toFront();
         PLC crrnt = list.getCursor().toFront().toNext();

         /* loop invariant: there are no adjacent duplicates in the
         *  portion of list preceding crrnt &&
         *  pred and crrnt are at adjacent positions, the latter being
         *  the successor of the former
         */
         while ( !crrnt.atRear() )   {
            if (pred.getItem().equals(crrnt.getItem()))
               { crrnt.remove(); }
            else { 
               pred.toNext();    // or, equivalently, pred.setTo(crrnt);
               crrnt.toNext();
            }
         }
         pred.dispose();
         crrnt.dispose();
      }
   }

   /* Starting at the given cursor's position and continuing to the rear of
   ** its list, removes every node containing an item equal to the one given.
   ** (Note: Use the equals() method, NOT the == relational operator!!)
   ** As a side effect, the given cursor ends up at the rear position of 
   ** its list.
   */
   public static <T> void removeRest(PLC<T> cursor, T item) {
      while(!cursor.atRear()) {
    	  if(cursor.getItem().equals(item)) {
    		  cursor.remove();
    	  } else {cursor.toNext();}
    	 
      }
   }

   /* Within the given list, removes every node containing an item that 
   ** appears earlier in the list (i.e., closer to the front).
   ** Hint: Use removeRest()
   */
   public static void removeDuplicates(PL_With_C list) {
      PLC cur = list.getCursor().toFront();
      PLC cur2 ?
      while(!cur.atRear()){
         removeRest(cur, cur.getItem()); 
         cur.toNext();
      }
      
   }

   /* Returns a new cursor positioned, within the given list, at the first 
   ** node (i.e., the one closest to the front) containing an item equal to 
   ** the given one.  If there is no such node, the returned cursor is
   ** positioned at the rear of its list.
   */
   public static <T> PLC<T> find(PL_With_C<T> list, T item) {
      boolean equalsItem = false;
      PLC cur = list.getCursor().toFront();
      while(!cur.atRear() && !equalsItem){
         if(cur.getItem().equals(item)){
            equalsItem = !equalsItem;
         }
         cur.toNext();
      }        
      return cur;
   }

   /* If the given list has no node containing an item equal to the given one,
   ** a new node containing the given item is inserted at the rear of the
   ** list.  Otherwise, the list is not changed.
   ** Hint: Use find()
   */
   public static <T> void insertNonDuplicate(PL_With_C<T> list, T item) {
      PLC cur = list.getCursor().toFront();
      int itemIsIn = 0;
      while(!cur.atRear()){
         if(cur.getItem().equals(item)){
            itemIsIn++;
         }
      }
      if(itemIsIn == 0){
         cur.toRear().insert(item);
      }
   }

   /* Modifies the given list by reversing the order in which the items occur.
   ** Hint: Cursors have a swapItems() method.
   */
   public static void reverse(PL_With_C list) {
   
   }

}

