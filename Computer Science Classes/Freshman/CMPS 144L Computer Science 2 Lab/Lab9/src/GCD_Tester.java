import java.util.Scanner;

/* GCD_Tester.java
** Java application for testing a recursive method that computes the
** GCD (greatest common divisor) of two integers recursively.
**
** Author: R. McCloskey and Anthony Lucchese and Abigail Rzucidlo 
** Known defects: ...
*/

public class GCD_Tester {

   private static Scanner keyboard;

   /* Returns the greatest common divisor of the two int values given.
   ** Uses recursion!
   ** pre: k >= 0 && m >= 0 && k+m > 0
   */
   public static int gcdViaRec(int k, int m) {
	  
      if(m != 0) {
		 if(k%m == 0) {
			 
		 } else {
			 return gcdViaRec(m, k%m);
		 }
      } else {
    	  return k;
    	  
      } 
      return m;
   }


   /* Returns the greatest common divisor of the two int values given.
   ** Uses a loop.
   ** pre: k >= 0 && m >= 0 && k+m > 0
   */
   public static int gcdViaLoop(int k, int m) {
      // ensure that k >= m by swapping their values if k < m
      if (k < m) { int temp = k; k = m; m = temp; }

      while (m != 0) {
         int newM = k % m;    // replace k by m and m by k % m
         k = m;
         m = newM;
      }
      return k;
   }


  // main () method for testing
  // --------------------------

   public static void main(String[] args)
   {
      final String kPrompt = "Enter a value for k: ";
      final String mPrompt = "Enter a value for m: ";

      keyboard = new Scanner(System.in);

      int k, m = 0;
      k = Integer.parseInt(getResponse(kPrompt).trim());
      if (k >= 0) {
         m = Integer.parseInt(getResponse(mPrompt).trim());
      }

      // Loop terminates when user enters a negative value for k.
      while (k >= 0) {
         int result = gcdViaRec(k, m);
         int correctResult = gcdViaLoop(k,m);
         System.out.println("Your method produced  " + result);
         System.out.println("The correct result is " + correctResult);
         System.out.println();
         k = Integer.parseInt(getResponse(kPrompt).trim());
         if (k >= 0) {
            m = Integer.parseInt(getResponse(mPrompt).trim());
         }
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
