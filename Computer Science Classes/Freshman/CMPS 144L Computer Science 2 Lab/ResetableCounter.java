/* ResetableCounter.java
** Java class that extends Counter by adding a reset() method by which a
** counter's value can be changed back to its value at construction.
**
** Author: R. McCloskey
*/
public class ResetableCounter extends Counter {

   // instance variable
   // -----------------
   private final int initVal;   // "remembers" this Counter's initial value

   // constructors
   // ------------

   /* Initializes this ResetableCounter to have the specified count value.
   **
   ** post: this.countVal() == initCntrVal
   */
   public ResetableCounter(int initCntrVal) {
      super(initCntrVal);
      initVal = initCntrVal;
   }

   /* Initializes this ResetableCounter to have zero as its count value.
   **
   ** post: this.countVal() == 0
   */
   public ResetableCounter() { this(0); }


   // observer
   // --------

   /* Returns this ResetableCounter's initial count value.
   */
   public int initialVal() { return initVal; }


   // mutator
   // -------

   /* Restores this ResetableCounter's count value back to what it was
   ** initially.
   **
   ** post: this.countVal() == this.initialVal()
   */
   public void reset() { this.setTo(initVal); }

}

