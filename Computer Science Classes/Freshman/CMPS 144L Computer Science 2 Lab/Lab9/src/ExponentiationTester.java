import java.util.Scanner;

/* ExponentiationTester.java
** Java application for testing a recursive method that raises a given 
** base to a given (integer) power.
**
** Author: R. McCloskey and Anthony Lucchese and Abigail Rzucidlo
** Known defects: ...
*/

public class ExponentiationTester {

   private static Scanner keyboard;
   private static int multCntr;  // keeps track of # multiplications performed

   /* Returns x raised to the n-th power.
   ** Also increases the value of global variable multCntr by the number of
   ** multiplications done here.
   ** pre: n >= 0.
   */
   
   public static double xToTheNRec(double x, int n) {
	   multCntr++;
	   if(n > 0) {
		   x = x * xToTheNRec(x, n - 1);
	   } else {
		   if(n == 0) {
			   x = 1;
		   }
	   }
	   return x;
	   
   }


   // main () method for testing
   // --------------------------

   public static void main(String[] args)
   {
      final String basePrompt = "Enter a base (real number): ";
      final String exponentPrompt = "Enter an exponent (integer): ";

      keyboard = new Scanner(System.in);

      double base = Double.parseDouble(getResponse(basePrompt).trim());
      int exponent = Integer.parseInt(getResponse(exponentPrompt).trim());

      // Loop terminates when user enters a negative value for the exponent.
      while (exponent >= 0) {
         multCntr = 0;   // reset the multiplication counter to zero
         double result = xToTheNRec(base, exponent);
         double correctResult = Math.pow(base,exponent);
         System.out.println("Your method produced " + result);
         System.out.println("Math.pow() produced  " + correctResult);

         System.out.println("Your method performed " + multCntr + " multiplications.\n");

         base = Double.parseDouble(getResponse(basePrompt).trim());
         exponent = Integer.parseInt(getResponse(exponentPrompt).trim());
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
