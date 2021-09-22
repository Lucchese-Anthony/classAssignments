/* BaseballGameClient.java
**
** Java application having as its purpose to illustrate the use of the
** BaseballGame class.  It creates an instance of the class and repeatedly
** accepts commands to "record" outs and runs until the user either quits
** or the game is over.
**
** The program is designed to take its input from either a file, who's name
** is given as a "Run Argument" or interactively via a prompt.
**
** Author: P.M.J.
** Date: November 2019
*/

import java.util.Scanner;
import java.io.*;
public class BaseballGameClient {
   private static final char OUT = 'O';
   private static final char RUN = 'R';
   private static final char QUIT = 'Q';
   private static final String COMMANDS = "" + OUT + RUN + QUIT;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = null;
      if(args.length > 0) {
         input = new Scanner(new File(args[0]));
      }
      
      int innings = getInt(input,"Enter Innings:>", 1, 20);
      BaseballGame BG = new BaseballGame(innings);
      System.out.println(BG);
      char c;
      do {
         c = getChar(input,"Enter:>",COMMANDS);
         if(c == OUT) {
            BG.recordOut();  System.out.print("out ... ");
         } else if(c == RUN) {
            BG.recordRun();  System.out.print("run ... ");
         }
         System.out.print(BG);
         System.out.printf(", Score: %d-%d, Innings: %d,%d%n",
                           BG.runsScored(BaseballGame.VISITOR),
                           BG.runsScored(BaseballGame.HOME),                           
                           BG.inningsCompleted(BaseballGame.VISITOR),
                           BG.inningsCompleted(BaseballGame.HOME)
                          );
      } while((c != QUIT) && !BG.isOver());
      System.out.println("Done!");
   }
   
   /* Reads and returns an integer from either a file, when the given Scanner
      has been previously constructed, or from interactive input otherwise.
   */
   private static int getInt(Scanner input, String prompt, int min, int max) {
      int result;
      if(input == null) {
         input = new Scanner(System.in);
         result = getIntFromUser(input,prompt,min,max);
      } else {
         result = input.nextInt();
         System.out.println(prompt+result);
      }
      return result;
   }

   /* Prints the specified prompt and returns the user's response, but
   ** only after the user has entered a number within the specified
   ** bounds.
   */
   private static int getIntFromUser(Scanner keyboard, String prompt, int min, int max) {
      int result;
      do {
         System.out.print(prompt);
         result = keyboard.nextInt();
         if ((result < min) || (result > max)) {
            System.out.println("ERROR: Must be between " + min + 
                               " and " + max + "; try again!");
         }
      } while ((result < min) || (result > max));
      return result;
   }
   
   /* Reads and returns a single character from either a file, when the given Scanner
      has been previously constructed, or from interactive input otherwise.
   */
   private static char getChar(Scanner input, String prompt, String acceptables) {
      char result;
      if(input == null) {
         input = new Scanner(System.in);
         result = getCharFromUser(input,prompt,acceptables);
      } else {
         result = nextChar(input,false,prompt);
      }
      return result;
   }

   /* Prints the specified prompt and returns the user's response, but
   ** only after the user has entered a character that is one of the given
   ** "acceptable" ones.
   */
   private static char getCharFromUser(Scanner input, String prompt, String acceptables) {
      char result;
      do {
         result = nextChar(input,true,prompt);
         if(acceptables.indexOf(result) < 0) {
            System.out.println("INVALID '"+result+"'; Must be one of {" + acceptables + 
                               "}; try again!");
         }
      } while (acceptables.indexOf(result) < 0);
      return result;
   }
   
   private static String buffer = "";
   /* Returns a single character from the beginning of a buffer (i.e. line) of
   ** characters which are read as required.
   */
   private static char nextChar(Scanner input, boolean interactive, String prompt) {
      char result;
      while(buffer.length() == 0) {
         System.out.print(prompt);
         buffer = input.next().trim().toUpperCase();
         if(!interactive) { System.out.println(buffer); }
      }
      result = buffer.charAt(0);
      buffer = buffer.substring(1);
      return result;
   }
}