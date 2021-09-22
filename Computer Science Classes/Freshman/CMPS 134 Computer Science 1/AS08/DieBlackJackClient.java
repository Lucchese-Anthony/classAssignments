/* Java application that presents an example use of the DieBlackJack class.
** The use provides the "goal" (as a positive integer value) as either a
** run argument or in response to the prompt.  The program then plays one
** instance of the game.
**
** CMPS 134 Fall 2019 
** Authors: P.M.J & R.W.M. & ...
**
** Collaboration:
**
** Known defects: ...
*/
import java.util.*;
public class DieBlackJackClient {
   public static void main(String[] args) {
      int goal = getIntArg(args,0,"Enter goal:>");
      DieBlackJack DBJ = new DieBlackJack(goal);
      int rollValue;
      
      System.out.println("     " + DBJ.getRollTotal() + " of " + DBJ.getGoal() + ": " + DBJ.toString());
      System.out.println("<<<<<<<<<<<<<<<<<");
      // Loop to play as long as appropriate
      while(DBJ.shouldTakeTurn()) {
         rollValue = DBJ.takeTurn();
         System.out.print("+" + rollValue + " = ");
         System.out.println(DBJ.getRollTotal() + " of " + DBJ.getGoal() + ": " + DBJ.toString());
      }
      
      System.out.println(">>>>>>>>>>>>>>>>>");
      System.out.println("     " + DBJ.getRollTotal() + " of " + DBJ.getGoal() + ": " + DBJ.toString());
      System.out.println(">>>>>>>>>>>>>>>>>");
      System.out.println(DBJ.atGoal() + ", " + DBJ.exceededGoal());
      ///////////////////////////////////////////////////////////////////////////////////////
      // Now try to take another turn, just to see what happens
      try {
         rollValue = DBJ.takeTurn();
         System.out.print("+" + rollValue + " = ");
         System.out.println(DBJ.getRollTotal() + " of " + DBJ.getGoal() + ": " + DBJ.toString());
      } catch (Exception e) {
         System.out.println(e+"\nContinuing ...\n");
         System.out.println("     " + DBJ.getRollTotal() + " of " + DBJ.getGoal() + ": " + DBJ.toString());
      }
      System.out.println(">>>>>>>>>>>>>>>>>");
      ///////////////////////////////////////////////////////////////////////////////////////
      System.out.println(DBJ.atGoal() + ", " + DBJ.exceededGoal());
      System.out.println("Done!!!");
   }

   private static int getIntArg(String args[], int index, String prompt) {
      int result = 0;
      if(args.length > index) {
         result = Integer.parseInt(args[index]);
      } else {
         System.out.print(prompt);
         result = new Scanner(System.in).nextInt();
      }
      return result;
   }
}
