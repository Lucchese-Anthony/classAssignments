/* Counter.java 
** Java class that models the concept of a counter that can be 
** incremented, decremented, and set to a specified value.
**
** Author: R. McCloskey
*/
public class Counter {

   // instance variable
   // -----------------

   private int cntrVal;      // current count value


   // constructors
   // ------------

   /* Initializes this Counter to have the specified count value.
   **
   ** post: this.countVal() = initCntrVal
   */
   public Counter(int initCntrVal) { this.cntrVal = initCntrVal; }


   /* Initializes this Counter to have zero as its count value.
   **
   **  post: this.countVal() = 0
   */
   public Counter() { this(0); }


   // observer
   // --------

   /* Returns this Counter's current count value.
   */
   public int countVal() { return cntrVal; }

   /* Returns String indicating this counter's count value.
   */
   @Override
   public String toString() { return "Counter: " + countVal(); }



   // mutators
   // --------

   /* Increments (i.e., increases by one) this Counter's count value.
   **
   ** pre:  let c = this.countVal()
   ** post: this.countVal() = c + 1
   */
   public void increment() { cntrVal = cntrVal + 1; }


   /* Decrements (i.e., decreases by one) this Counter's count value.
   **
   ** pre:  let c = this.countVal()
   ** post: this.countVal() = c - 1
   */
   public void decrement() { cntrVal = cntrVal - 1; }


   /* Sets this Counter's count value to that specified.
   ** post: this.countVal() = newVal
   */
   public void setTo(int newVal) { cntrVal = newVal; }

}

