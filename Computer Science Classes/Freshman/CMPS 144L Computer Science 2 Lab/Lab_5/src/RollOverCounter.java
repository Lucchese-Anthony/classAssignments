/* RollOverCounter.java
** Java class that extends BoundedCounter by providing concrete versions of
** incrementFromMax() and decrementFromMin().  The intended behavior of these
** two is to "roll over" (i.e., incrementing from the maximum possible count 
** value yields the minimum possible count value and decrementing from 
** the minimum possible count value yields the maximum possible count value).
**
** Author: R. McCloskey
*/
public class RollOverCounter extends BoundedCounter {

   // constructors
   // ------------

   /* Initializes this RollOverCounter so that its range of possible
   ** count values is min..max and its initial count value is init.
   **
   ** pre: min <= init <= max
   */
   public RollOverCounter(int init, int min, int max)
      { super(init, min, max); }


   /* Initializes this RollOverCounter so that its range of possible
   ** count values is min..max and its initial count value is min.
   **
   ** pre: min <= max
   */
   public RollOverCounter(int min, int max) { this(min, min, max); }


   // mutators  (concrete versions of abstract methods in parent class)
   // --------

   /* Sets this RollOverCounter's count value to the minimum of its range.
   **
   ** post: this.countVal() == this.minimumVal()
   */
   @Override
   protected void incrementFromMax() { setTo(minimumVal()); }


   /* Sets this RollOverCounter's count value to the maximum of its range.
   **
   ** post: this.countVal() == this.maximumVal()
   */
   @Override
   protected void decrementFromMin() { setTo(maximumVal()); }

}

