/* parseDriver.java
**
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2018
**
** Last Modified: October 31, 2018
** Collaboration: 
**
** Java application that 
**
*/
import java.util.Scanner;
public class parseDriver {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      String aString;
      int hour, minute,second;
      
      do {
         System.out.print("Enter:>");
         aString = input.nextLine();
         if(aString.length() > 0) {
            aString = aString.trim();
            System.out.print(quoted(aString)+" yields ");
            hour = TimeSpanOperations.parseOutHour(aString);
            System.out.print(hour + " hours, and ");
            minute = TimeSpanOperations.parseOutMinute(aString);
            System.out.print(minute + " minutes, and ");      
            second = TimeSpanOperations.parseOutSecond(aString);
            System.out.print(second + " seconds.");      
            System.out.println();
         }
      } while(aString.length() > 0);
      System.out.println("Done!!!");
   }

   public static final String QUOTE = "\"";
   public static String quoted(String s) {
      return QUOTE + s + QUOTE;
   }
}