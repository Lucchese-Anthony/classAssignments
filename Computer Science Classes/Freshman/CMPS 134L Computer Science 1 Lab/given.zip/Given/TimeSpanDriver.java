/* TimeSpanDriver.java
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
public class TimeSpanDriver {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      String aString;
      int hour, minute,second;
      TimeSpan prev = new TimeSpan(0,0,0);
      TimeSpan one, two;
      
      do {
         System.out.print("Enter:>");
         aString = input.nextLine().trim();
         if(aString.length() > 0) {
            one = new TimeSpan(aString);
            two = new TimeSpan(one.toString());
            System.out.println(one + ".equals(" + two  + ") yields " + (one.equals(two)));
            if(prev != null) {
               System.out.println(prev + ".equals(" + one  + ") yields " + (prev.equals(one)));
            }
            prev = new TimeSpan(one.getHour(),one.getMinute(),one.getSecond());
         }
      } while(aString.length() > 0);
      System.out.println("Done!!!");
   }

   public static final String QUOTE = "\"";
   public static String quoted(String s) {
      return QUOTE + s + QUOTE;
   }
}