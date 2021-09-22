/* RollOverCounter.java
** Java class that extends BoundedCounter by providing concrete versions of
** incrementFromMax() and decrementFromMin().  The intended behavior of these
** two is to cause the count value to "roll over" (i.e., change from max to 
** min (when incrementing) and from min to max when decrementing).
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
   protected void incrementFromMax() 
      { setTo(minimumVal()); }


   /* Sets this RollOverCounter's count value to the maximum of its range.
   **
   ** post: this.countVal() == this.maximumVal()
   */
   @Override
   protected void decrementFromMin() 
      { setTo(maximumVal()); }

}

