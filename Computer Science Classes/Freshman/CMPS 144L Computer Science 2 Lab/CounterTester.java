/* CounterTester.java
** Java application program that interacts with the user (at the keyboard) for
** the purpose of testing the various classes in the Counter class hierarchy.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CounterTester {

   private static final char QUIT = 'q';
   private static final char INCREMENT = 'i';
   private static final char DECREMENT = 'd';
   private static final char RESET = 'r';
   private static final char SET_TO = 's';
   private static final char HELP = 'h';

   private static Scanner input;
   private static boolean echo;

   public static void main(String[] args) throws FileNotFoundException  {

      if (args.length > 0) {  // interpret args[0] as name of input file 
         input = new Scanner(new File(args[0]));
         echo = true;
      }
      else {            // read input from standard input
         input = new Scanner(System.in);
         echo = false;
      }

      Counter c = null;
      String responseStr;
      int response;
      int counterKind, init = 0, min = 0, max = 0; 

      println("Welcome to the Counter Tester program!");
      println("\nEnter the kind of Counter to test:");
      println("  (1) (plain) Counter");
      println("  (2) Resetable Counter");
      println("  (3) RollOver Counter");
      println("  (4) Stopping Counter");
      println("  (5) Warning Counter");
       
      counterKind = getInt("> ");
      if (3 <= counterKind  &&  counterKind <= 5) {
         min = getInt("Enter minimum bound: ");
         max = getInt("Enter maximum bound: ");
      }
      init = getInt("Enter initial count value: ");

      if (counterKind == 1) { c = new Counter(init); }
      else if (counterKind == 2) { c = new ResetableCounter(init); }
      else if (counterKind == 3) { c = new RollOverCounter(init, min, max); }
      else if (counterKind == 4) { c = new StoppingCounter(init, min, max); }
      else if (counterKind == 5) { c = new WarningCounter(init, min, max); }
      else { println("Illegal response"); }

      if (c != null) 
         { testLoop(c); }
      else 
         { System.out.println("Program terminating."); }
   }


   /* Prints the specified prompt, reads an integer from the 'input'
   ** scanner, and returns that value.
   */
   private static int getInt(String prompt) {
      System.out.print(prompt);
      int result = input.nextInt();
      if (echo) { System.out.println(result); }
      return result;
   }

   /* Prints the specified prompt, reads a token from the 'input'
   ** scanner, and returns that token.
   */
   private static String getString(String prompt) {
      System.out.print(prompt);
      String result = input.next();
      if (echo) { System.out.println(result); }
      return result;
   }


   /* Repeatedly applies operations to the given Counter object,
   ** according to the commands entered by the user.
   */
   private static void testLoop(Counter c) // throws IOException
   {
      char command = ' ';
      println("Initial counter value = " + c.countVal());
      printHelp();
      while (command != QUIT) {
         try {
            command = getString("> ").charAt(0);
            test(c, command);
         }
         catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println();
         }
      }
   }


   /* Applies to the given Counter object the method indicated by
   ** the given command code.
   */
   private static void test(Counter cntr, char command) 
   { 
      command = Character.toLowerCase(command);

      if (command == QUIT) {
         // do nothing
      }
      else if (command == INCREMENT) {
         cntr.increment();
         println("After incrementing, count is " + cntr.countVal());
      }
      else if (command == DECREMENT) {
         cntr.decrement();
         println("After decrementing, count is " + cntr.countVal());
      }
      else if (command == RESET) {
         if (cntr instanceof ResetableCounter) {
            ((ResetableCounter) cntr).reset();
            println("After resetting, count is " + cntr.countVal());
         }
         else { 
            println("This Counter does not support the reset operation!");
         }
      }
      else if (command == SET_TO) {
         int k = getInt("Set counter to: ");
         try {                  // this try-catch block is to support the
            cntr.setTo(k);      // testing of Activity #3.
            System.out.printf("After setting to %d, count is %d\n", 
                              k, cntr.countVal());
         }
         catch (IllegalArgumentException e) {
            e.printStackTrace(System.out);
         }
      }
      else if (command == HELP) {
         printHelp();
      }
      else {
         println("Unrecognized command; try again:");
         printHelp();
      }
   }

   /* Prints instructions for the user.
   */
   private static void printHelp() {
      println("  Type i to increment, d to decrement, r to reset,\n" +
              "  s to setTo, q to quit, and h for this help");
   }


   /* Surrogate for the System.out.println() method.
   */
   private static void println(String s) { System.out.println(s); }

   /* Surrogate for the System.out.print() method.
   */
   private static void print(String s) { System.out.print(s); }

}
