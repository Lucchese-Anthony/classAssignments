/* ResetableCounter.java
** Java class that extends Counter by adding a method reset() by which a
** counter's value can be changed back to its value at construction.
**
** Author: R. McCloskey
*/
public class ResetableCounter extends Counter {

   // instance variable
   // -----------------
   private int initVal;   // "remembers" this Counter's initial value

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


   // observers
   // ---------

   /* Returns this ResetableCounter's initial count value.
   */
   public int initialVal() { return initVal; }

   /* Returns a string indicating this counter's count value
   ** and its initial value.
   */
   @Override
   public String toString() { 
      return super.toString() + "; initially " + initialVal();
   }


   // mutator
   // -------

   /* Sets this ResetableCounter's count value back to what it had been
   ** initially.
   **
   ** post: this.countVal() == this.initialVal()
   */
   public void reset() { this.setTo(initVal); }

}

