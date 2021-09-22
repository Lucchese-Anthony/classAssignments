/* Java application that makes use of the DieBlackJackCompetition class to
** simulate the playing of DieBlackJack as a competition among multiple
** players.  
**
** The program accepts the number of players and the "goal" (both as positive 
** integer values) as either run arguments or in response to prompts.
**
** CMPS 134 Fall 2019 
** Authors: P.M.J & R.W.M. & ...
**
** Collaboration:
**
** Known defects: ...
*/
import java.util.*;
public class DieBlackJackCompetitionClient {
   
   
   public static void main(String[] args) {
      int numberOfPlayers = getIntArg(args,0,"Enter number of players:>");
      int goal = getIntArg(args,1,"Enter goal:>");
      //////////////////////////////////////////////////////////////////////
      DieBlackJackCompetition game = new DieBlackJackCompetition(numberOfPlayers,goal);
      String round;
      System.out.println(game.toString());
      printStatus(game);  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
      //////////////////////////////////////////////////////////////////////
      // Loop to play one round after another until the game is over
      do {
         round = game.playRound();
         System.out.println(round + game.toString());
         printStatus(game);  System.out.println("-----------------------");
      } while (!game.over());
      //////////////////////////////////////////////////////////////////////
      printStatus(game);  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(game.toString());
      System.out.println("Done!!!");
   }

   /* Method that prints out the status of each player (as one of the codes
      'A', 'W' or 'L', for Active, Winner or Loser).
   */
   private static void printStatus(DieBlackJackCompetition game) {
      for(int i=0; i<game.getNumberOfPlayers(); i++) {
         System.out.print(game.getStatus(i));
      }
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
