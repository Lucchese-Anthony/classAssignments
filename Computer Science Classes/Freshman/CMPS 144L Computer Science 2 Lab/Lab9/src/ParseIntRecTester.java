import java.util.Scanner;

/* ParseIntRecTester.java
** Java application for testing a recursive method that translates a 
** decimal integer numeral into the corresponding int value.
**
** Author: R. McCloskey and Anthony Lucchese and Abigail Rzucidlo
** Known defects: ...
*/

public class ParseIntRecTester {

   private static final char DOUBLE_QUOTE = '\"';
   private static Scanner keyboard;


   // method of interest
   // ------------------

   /* Given a decimal integer numeral (i.e., a String that is a sequence 
   ** of digit characters), returns the int value that the numeral represents.
   ** In other words, it does the same thing as Integer.parseInt().
   ** 
   ** Uses recursion!
   ** 
   ** Example: "465" maps to 465, "3" maps to 3.
   **
   ** pre: numeral.length() > 0 &&
   **      Character.isDigit(numeral.charAt(i)) for all i in [0..numeral.length())
   */
   public static int parseIntRec(String numeral) {
	   
	   if(numeral.length() == 1) {
		   return digitToInt(numeral.charAt(0));
	   }
	   double y = parseIntRec(numeral.substring(1));
	   double x = digitToInt(numeral.charAt(0));
	   x = x * Math.pow(10, numeral.length() - 1) + y;
	   return (int)x;                                       // STUB!
   }


   /* Given a digit character, returns the corresponding int value.
   ** E.g., '4' maps to 4, '7' maps to 7.
   **
   ** pre: Character.isDigit(digit)
   */
   private static int digitToInt(char digit) { return digit - '0'; }


   // main() method for testing purposes
   // ----------------------------------

   public static void main(String[] args)
   {
      keyboard = new Scanner(System.in);
      String numeral = getResponse("Enter a decimal integer numeral: ").trim();

      while (numeral.length() != 0) {
         int number = parseIntRec(numeral);
         System.out.println("Numeral " + DOUBLE_QUOTE + numeral + DOUBLE_QUOTE +
                            " translates to integer " + number + "\n");

         numeral = getResponse("Enter another decimal integer numeral: ").trim();
      }
   }

   /* Displays the given prompt and returns the String entered at the keyboard
   ** in response.
   */
   private static String getResponse(String prompt) {
      System.out.print(prompt);
      return keyboard.nextLine();
   }
}
