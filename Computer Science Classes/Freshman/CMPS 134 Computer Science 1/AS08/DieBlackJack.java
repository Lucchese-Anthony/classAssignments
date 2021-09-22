/* Java class instances of which represent an object meant to maintain the
** state and behavior of a "Die Black Jack" game, which involves successive 
** rolls of a single die with the goal being to obtain a total as close as 
** possible, without going over, to some agreed upon goal (often 21).
**  
** See http://www.dice-play.com/Games/TwentyOne.htm for a more detailed explanation.
**
** CMPS 134 Fall 2019 
** Authors: Anthony Lucchese
**
** Collaboration: ...
**
** Known defects: ...
*/
public class DieBlackJack {

   // class constants
   // ---------------
   public static final int GOAL_DEFAULT = 21;   //Default goal

   // instance variables
   // ------------------
   private Die die;        //The Die object to be rolled
   private int goal;       //The goal for this instance of the game
   private int rollTotal;  //The current roll total
   
   // constructors
   // ------------
   public DieBlackJack() {
      initialize(GOAL_DEFAULT);
   }
   
   public DieBlackJack(int goal) {
      initialize(goal);
   }

   // mutators
   // --------

   /* Mutator that takes one turn of rolling the die and updating the state.
   */
   public int takeTurn() {
      int result = 0;
      if(rollTotal < goal) {
         die.roll();
         result = die.getFaceValue();
         rollTotal = rollTotal + result;
      } else {
         if(rollTotal > goal) {
            throw new IllegalStateException("goal already exceeded");            
         } else {
            throw new IllegalStateException("goal already reached");            
         }
      }
      return result;
   }

   // observers
   // ---------

   /* Returns the goal value for this object.
   */
   public int getGoal() {
      return goal;
   }
   
   /* Returns the current roll total for this object.
   */
   public int getRollTotal() {
      return rollTotal;
   }
   
   /* Returns true iff the roll total equals the goal.
   */
   public boolean atGoal() {
      return (rollTotal == goal);
   }
   
   /* Returns true iff the roll total exceeds the goal.
   */
   public boolean exceededGoal() {
      return (rollTotal > goal);
   }
     
   /* Implements a straightforward and naïve strategy that says if the roll 
   ** total is three or less than the goal then the player should “stay” and 
   ** not take another turn.  
   */
   public boolean shouldTakeTurn() {
      int distance = (goal - this.rollTotal);
      return (distance > 3);
   }
   
   /* Implements a more realistic strategy that considers the roll totals 
   ** of other players in determining whether to "stay" or "take" another
   ** turn.
   */
   public boolean shouldTakeTurn(int[] rollTotal) {
      return true; // S t u b b e d ! ! !
   }
   
   public String toString() {
      return "" + rollTotal;
   }

   // Private Methods
   // ---------------
   
   // Does the actual work of constructing the object
   private void initialize(int goal) {
      if(goal >= 0) {
         this.goal = goal;
         die = new Die(); 
      } else {
         throw new IllegalArgumentException("invalid game goal");            
      }
   }
   
}
