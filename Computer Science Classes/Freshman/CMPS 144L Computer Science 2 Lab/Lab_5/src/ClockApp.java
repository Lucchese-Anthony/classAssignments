import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/* ClockApp.java
** Java application for the purpose of testing the Clock class.
*/

public class ClockApp {

   private static Scanner input;
   private static boolean echo;    // should input be printed?
   private static int initHour;
   private static int initMinute;
   private static int initSecond;

   public static void main(String[] args) {
      String menu = 
         "\n" +
         "(1) tick       (2) set to 24-hour mode  (3) set to AM/PM mode\n" +
         "(4) set hour   (5) set minute           (6) set second\n" +
         "(7) set h/m/s  (8) quit\n> ";

      System.out.println("Welcome to the Clock application.");

      initializeScanner(args);
      Clock clock = initialClock(args);
      //System.out.println("Initially, Clock is showing");
      showClock(clock);

      boolean keepGoing = true;
      while (keepGoing) {
         int choice = getInt(input, menu, echo);
         if (choice == 1) {
            clock.tick();
         }
         else if (choice == 2) {
            clock.setTo24Mode();
         }
         else if (choice == 3) {
            clock.setToAmPmMode();
         }
         else if (choice == 4) {
            int hour = getInt(input, "Enter hour: ", echo);
            clock.setHourTo(hour);
         }
         else if (choice == 5) {
            int minute = getInt(input, "Enter minute: ", echo);
            clock.setMinuteTo(minute);
         }
         else if (choice == 6) {
            int second = getInt(input, "Enter second: ", echo);
            clock.setSecondTo(second);
         }
         else if (choice == 7) {
            int hour = getInt(input, "Enter hour: ", echo);
            int minute = getInt(input, "Enter minute: ", echo);
            int second = getInt(input, "Enter second: ", echo);
            clock.setTo(hour, minute, second);
         }
         else if (choice == 8) { 
            keepGoing = false;
         }
         else {
            System.out.println("Invalid response; try again.");
         }
         // After applying an operation, display the clock's state.
         showClock(clock);
      }
      System.out.println("\nGoodbye.");
   }

   private static void showClock(Clock clock) {
      System.out.printf("\nhour: %d; minute: %d; second: %d\n",
                        clock.getHour(), clock.getMinute(), clock.getSecond());
      System.out.println("24-hour display: " + clock.toString24());
      System.out.println("AM/PM display:   " + clock.toStringAmPm());
      System.out.println("default display: " + clock.toString());
   }


   /* Assigns values to the 'input' and 'echo' global variables according
   ** to the command line arguments, which are passed in via parameter.
   */
   private static void initializeScanner(String[] args) {
      int argsLen = args.length;
      // If the # of command line arguments is zero or three, it means
      // that input is to come from standard input.
      if (argsLen == 0  ||  argsLen == 3) {
         echo = false;
         input = new Scanner(System.in);
      }
      else {
         // Otherwise, the first command line argument is interpreted 
         // to be the name of the file from which input is to be read.
         echo = true;
         try {
            input = new Scanner(new File(args[0]));
         }
         catch (FileNotFoundException e) {
            System.out.println("There is no file named " + args[0]);
            e.printStackTrace();
            System.exit(1);
         }
      }
   }

   /* Returns a new Clock, initialized according to inputs provided via
   ** either the command line arguments (passed in as a parameter) or
   ** from the input Scanner, according to how many command line args
   ** were specified.  
   */
   private static Clock initialClock(String[] args) {
      System.out.println("Initializing clock...");
      int argsLen = args.length;
      int hour, minute, second;
      if (argsLen < 2) {
         hour = getInt(input, "Enter hour: ", echo);
         minute = getInt(input, "Enter minute: ", echo);
         second = getInt(input, "Enter second: ", echo);
      }
      else {
         Scanner argScanner = null;
         if (argsLen == 3) {
            argScanner = new Scanner(args[0] + '\n' + 
                                     args[1] + '\n' + 
                                     args[2] + '\n');
         }
         else if (argsLen == 4) { 
            argScanner = new Scanner(args[1] + '\n' + 
                                     args[2] + '\n' + 
                                     args[3] + '\n');
         }
         hour = getInt(argScanner, "Enter hour: ", true);
         minute = getInt(argScanner, "Enter minute: ", true);
         second = getInt(argScanner, "Enter second: ", true);
      }
      return new Clock(hour, minute, second);
   }

   /* Prints the given prompt and returns the response read using the
   ** given Scanner, interpreted to be an integer.
   */
   private static int getInt(Scanner in, String prompt, boolean echo) {
      System.out.print(prompt);
      int result = in.nextInt();  in.nextLine();
      if (echo) { System.out.println(result); }
      return result;
   }

}
