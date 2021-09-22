//names: Anthony Lucchese Steven Prosperino
public class WarningCounter extends BoundedCounter{
   
   public WarningCounter(int init, int min, int max) { 
      super(init, min, max); 
   }
  
   @Override
   protected void decrementFromMin(){/* Partitioner3Color.java
** Author: R. McCloskey and < STUDENT'S NAME >
** Date: February 2020 (CMPS 144; Prog. Assg. #1)
** Known defects: ...
**
** An instance of a concrete descendant class of this abstract class has
** methods by which to rearrange the elements of an array of type char[] 
** into RED, WHITE, and BLUE segments, respectively.  The criteria by which 
** characters are placed into these categories is emodied in the isRed(), 
** isWhite(), and isBlue() methods, which are abstract here (and thus left 
** to descendant classes to provide in full).
**
** After an array is partitioned, observer methods can report how many 
** times "color tests" (i.e., calls to isRed(), etc.) were made and how 
** many swaps of array elements were performed during the partitioning 
** process.
*/

public abstract class Partitioner3Color {

   // instance variables
   // ------------------

   // The array that this object most recently partitioned.
   private char[] ary;   

   // The values of these variables indicate the locations of the RED/WHITE 
   // and WHITE/BLUE boundaries, respectively, in the array most recently
   // partitioned.  Specifically, rw indicates the location at which the
   // WHITE segment begins and wb indicates the location at which the BLUE
   // segment begins.
   private int rw, wb;

   // # of color tests and swaps performed during most recent execution of
   // a method that does partitioning.
   private int colorTestCntr;
   private int swapCntr;   


   // constructors
   // ------------

   // No constructor needed


   // observers
   // ---------

   /* Returns (a reference to) the array that this object most recently 
   ** partitioned.
   */
   public char[] array() { return ary; }

   /* Returns, with respect to the array most recently partitioned,
   ** the location at which the WHITE segment begins.
   */
   public int whiteStart() { return rw; }

   /* Returns, with respect to the array most recently partitioned,
   ** the location at which the BLUE segment begins.
   */
   public int blueStart() { return wb; }

   /* Returns the # of times that color-test methods (isRed(), isWhite(),
   ** and isBlue()) were called during the most recent execution of a 
   ** method that does partitioning.
   */
   public int numColorTests() { return colorTestCntr; }

   /* Returns the # of array element swaps performed during the most
   ** recent execution of a method that does partitioning.
   */
   public int numSwaps() { return swapCntr; }


   // mutators
   // --------

   /* Rearranges the elements of b[] (the given array) so that all RED 
   ** values come before any WHITE values, which come before any BLUE 
   ** values.  The loop has the invariant depicted by this diagram:
   **
   **    0           rw            wq          wb           N
   **   +-----------+-------------+-----------+------------+
   ** b |  all RED  |  all WHITE  |     ?     |  all BLUE  |
   **   +-----------+-------------+-----------+------------+
   */
   public void partition(char[] b)
   {
      // Save reference to the array about to be partitioned and reset
      // the variables that keep track of # color tests and swaps.
      ary = b;  
      colorTestCntr = 0;  swapCntr = 0;

      // Initialize variables so as to truthify the loop invariant 
      // (by making the ?-segment cover the whole array).
      rw = 0;          // RED/WHITE boundary (instance variable)
      int wq = 0;      // WHITE/? boundary   (local variable)
      wb = b.length;   // ?/BLUE boundary    (instance variable)

      /* loop invariant:
      ** 0 <= rw <= wq <= wb <= b.length && segmentIsRed(b,0,rw) && 
      ** segmentIsWhite(b,rw,wq) && segmentIsBlue(b,wb,b.length)
      */

      // Verify that the loop invariant is true before 1st iteration.
      assert loopInvariant(b,rw,wq,wb);

      while (wq != wb) {
         if (isRed(b[wq])) {
            colorTestCntr = colorTestCntr + 1;
            swap(b,wq,rw); 
            rw++; wq++;
         }
         else if (isWhite(b[wq])) {
            colorTestCntr = colorTestCntr + 2;
            wq++;
         }
         else if (isBlue(b[wq])) {
            colorTestCntr = colorTestCntr + 3;
            swap(b,wq,wb-1); 
            wb--;
         }
         else { 
            System.out.println("ERROR: Value " + b[wq] + " at location " +
                               wq + " found to be of no color!");
         }
         // Verify loop invariant is true at the end of each iteration.
         assert loopInvariant(b,rw,wq,wb);
      }
   }


   /* Returns true if and only if 0 <= rw <= wq <= wb < = b.length &&
   ** segmentIsRed(b,0,rw)  &&  segmentIsWhite(b,rw,wq)  &&
   ** segmentIsBlue(b,wb,b.length), corresponding to the loop invariant 
   ** of partition().
   */
   private boolean loopInvariant(char[] b, int rw, int wq, int wb) {
      return 0 <= rw  &&  rw <= wq  &&  wq <= wb  &&  wb <= b.length  &&
             segmentIsRed(b,0,rw)  &&  
             segmentIsWhite(b,rw,wq)  &&  
             segmentIsBlue(b,wb,b.length);
   }


   /* Rearranges the elements of b[] (the given array) so that all RED 
   ** values come before any WHITE values, which come before any BLUE values.
   ** The loop has the invariant depicted by this diagram:
   **
   **    0           rw            wb           bq         N
   **   +-----------+-------------+------------+----------+
   ** b |  all RED  |  all WHITE  |  all BLUE  |    ?     |
   **   +-----------+-------------+------------+----------+
   */
   public void partition2(char[] b)
   {
      // STUB
   }

   /* Returns true if and only if 0 <= rw <= wb <= bq <= b.length &&
   ** segmentIsRed(b,0,rw)  &&  segmentIsWhite(b,rw,wb)  &&
   ** segmentIsBlue(b,wb,bq), corresponding to the loop invariant 
   ** of partition2().
   */
   private boolean loopInvariant2(char[] b, int rw, int wb, int bq) {
      return false;  // STUB
   } 

   /* Rearranges the elements of b[] (the given array) so that all RED 
   ** values come before any WHITE values, which come before any BLUE values.
   ** The loop has the invariant depicted by this diagram:
   **
   **    0           rq          rw            wb           N
   **   +-----------+-----------+-------------+------------+
   ** b |  all RED  |     ?     |  all WHITE  |  all BLUE  |
   **   +-----------+-----------+-------------+------------+
   */
   public void partition3(char[] b) {
      // STUB
   }

   /* Returns true if and only if 0 <= rq <= rw <= wb <= b.length &&
   ** segmentIsRed(b,0,rq)  &&  segmentIsWhite(b,rw,wb)  &&
   ** segmentIsBlue(b,wb, bq), corresponding to the loop invariant 
   ** of partition3().
   */
   private boolean loopInvariant3(char[] b, int rq, int rw, int wb) {
      return false;   // STUB
   } 


   // abstract methods
   // ----------------

   /* Methods that classify a character as being either RED, WHITE, or BLUE.
   */
   protected abstract boolean isRed(char ch);
   protected abstract boolean isWhite(char ch);
   protected abstract boolean isBlue(char ch);


   // utility methods
   // ---------------

   /* Swaps the values at the specified locations (i and j) in the
   ** specified array (a).  (Also increments the swap counter.)
   ** pre: 0 <= i < a.length  &&  0 <= j < a.length
   */
   private void swap(char[] a, int i, int j)
   { 
      swapCntr++;
      char temp = a[i]; a[i] = a[j]; a[j] = temp;
   }


   /** Returns true iff every element in the specified array segment
   **  (namely, a[lower..upper)) is RED.
   **  pre: 0 <= lower <= upper <= a.length
   */
   private boolean segmentIsRed(char[] a, int lower, int upper) {

      int i = lower;
      // loop invariant: 0<=lower<=i<=upper<=a.length  &&
      //                 every element in a[lower..i) is RED
      while (i != upper  &&  isRed(a[i])) {
         i = i+1;
      }
      return i == upper;
   }

   /** Returns true iff every element in the specified array segment
   **  (namely, a[lower..upper)) is WHITE.
   **  pre: 0 <= lower <= upper <= a.length
   */
   private boolean segmentIsWhite(char[] a, int lower, int upper) {

      int i = lower;
      // loop invariant: 0<=lower<=i<=upper<=a.length  &&
      //                 every element in a[lower..i) is WHITE
      while (i != upper  &&  isWhite(a[i])) {
         i = i+1;
      }
      return i == upper;
   }


   /** Returns true iff every element in the specified array segment
   **  (namely, a[lower..upper)) is BLUE.
   **  pre: 0 <= lower <= upper <= a.length
   */
   private boolean segmentIsBlue(char[] a, int lower, int upper) {

      int i = lower;
      // loop invariant: 0<=lower<=i<=upper<=a.length  &&
      //                 every element in a[lower..i) is BLUE
      while (i != upper  &&  isBlue(a[i])) {
         i = i+1;
      }
      return i == upper;
   }

}

      throw new RuntimeException("Cannot increment a WarningCounter at its min"); 
   }
   @Override
   protected void incrementFromMax(){
      throw new RuntimeException("Cannot increment a WarningCounter at its max"); 
   }
}