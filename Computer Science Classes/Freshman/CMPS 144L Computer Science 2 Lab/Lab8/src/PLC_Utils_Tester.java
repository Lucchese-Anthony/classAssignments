import java.util.Arrays;

/* PLC_Utils_Tester.java
** Java application having as its purpose to test the methods of the
** PL_With_C_Utils class (and, indirectly, those in the underlying classes
** that it uses).
**
** Author: R. McCloskey
** Date: November 2018
*/

public class PLC_Utils_Tester {

   public static void main(String[] args) 
   {
      final String TERMINATOR = " ";  // printed after each list item

      String[] strAry = new String[] { "PIG", "DOG", "DOG", "DOG", "CAT", 
                                       "PIG", "ELK", "MOOSE", "T-REX", 
                                       "ELK", "ELK", "COW", "DOG", "BEAR"
                                     };

      System.out.println("The array to be listified:");
      System.out.println(Arrays.toString(strAry));

      PL_With_C<String> list = PL_With_C_Utils.listify(strAry); 
      System.out.println("After listifying, the list is");
      PL_With_C_Utils.printList(list, TERMINATOR);

      System.out.println("\nThe length of the list is " +
                         PL_With_C_Utils.lengthOf(list));

      // test the find() method by looking for various animals
      findTest(list, "PIG");
      findTest(list, "CAT");
      findTest(list, "COW");
      findTest(list, "LION");
      findTest(list, "BEAR");

     /* 
      System.out.println("\nRemoving adjacent duplicates ...");
      PL_With_C_Utils.removeAdjacentDuplicates(list);
      System.out.println("Afterwards, the list contains");
      PL_With_C_Utils.printList(list, TERMINATOR);
     */

      System.out.println("\nInserting (if not a duplicate) GORN ...");
      try {
         PL_With_C_Utils.insertNonDuplicate(list, "GORN");
      }
      catch (Exception e) {
         e.printStackTrace(System.out);
      }
      System.out.println("Afterwards, the list contains");
      PL_With_C_Utils.printList(list, TERMINATOR);

      System.out.println("\nInserting (if not a duplicate) CAT ...");
      try {
         PL_With_C_Utils.insertNonDuplicate(list, "CAT");
      }
      catch (Exception e) {
         e.printStackTrace(System.out);
      }
      System.out.println("Afterwards, the list contains");
      PL_With_C_Utils.printList(list, TERMINATOR);

      System.out.println("\nRemoving duplicates ...");
      try {
         PL_With_C_Utils.removeDuplicates(list);
      }
      catch (Exception e) {
         e.printStackTrace(System.out);
      }
      System.out.println("Afterwards, the list contains");
      PL_With_C_Utils.printList(list, TERMINATOR);

      System.out.println("\nReversing the list ...");
      try {
         PL_With_C_Utils.reverse(list);
      }
      catch (Exception e) {
         e.printStackTrace(System.out);
      }
      System.out.println("Afterwards, the list contains");
      PL_With_C_Utils.printList(list, TERMINATOR);
   }


   /* For testing the find() method in the PL_With_C_Utils class.
   */
   private static void findTest(PL_With_C<String> list, String str) {
      System.out.println("\nTrying to find " + str + " ...");
      try {
         PLC<String> cursor = PL_With_C_Utils.find(list, str);
         if (cursor.atRear()) {
            System.out.println("Not found.");
         }
         else if (str.equals(cursor.getItem())) {
            if (cursor.atFront()) {
               System.out.println("Found at front of list.");
            }
            else {
               System.out.println("Found at node whose predecessor contains " +
                                  cursor.toPrev().getItem());
            }
         }
         else {  // cursor is at node containing item different from str
            System.out.println("ERROR: found at node containing " +
                               cursor.getItem());
         }
         cursor.dispose();
      }
      catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }

}
