/* ftocDriver.java
**
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2018
**
** Last Modified: September 24, 2018
** Collaboration: 
**
** Java application that relates to BJP4 Self-Check 3.12 (Temperature-errors)
**
*/
import java.util.Scanner;
public class ftocDriver {
   public static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) {
   
      int limit = getInt("Enter limit:>",0,212);
      int increment = getInt("Enter increment:>",0,50);
   
      for(int f=0; f<=limit; f=f+increment) {
         double tempf = (double)f;
         double tempc; 
         tempc = ftoc(tempf);
         System.out.println(tempf+" F is equivalent to "+tempc+" C");
      }
   }
    
   // PLACE YOUR ftoc METHOD HERE!!!


      
   /** Functional method that prompts the interactive user to enter an integer value,
    ** reads that value, and validates that it is within the acceptable range of 
    ** values, as definded by the given arguments.  The process is completed as 
    ** necessary until an acceptable value is input.  The resultant value is returned.
    **/
   public static int getInt(String prompt, int lower, int upper) {
      int result;
      do {
         System.out.print(prompt);
         result = keyboard.nextInt();
      } while ((result < lower) || (result > upper));
      return result;
   }
   
   public static double ftoc(double tempf, double tempc) {
        tempc = (tempf - 32) * 5 / 9;
        return tempc;
    }
}