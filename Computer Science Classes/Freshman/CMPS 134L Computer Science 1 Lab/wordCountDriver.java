/* wordCountDriver.java
**
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2017
**
** Last Modified: October 15, 2017
** Collaboration: 
**
** Java application that 
**
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class wordCountDriver {
   public static void main(String[] args) throws FileNotFoundException {
      // Use the first run-time argument as the name of the file to be read
      String fileID = "DoI.txt";
      Scanner input = new Scanner(new File(fileID));
      
      String aString;
      do {
         aString = input.nextLine();
         if(aString.length() > 0) {
            System.out.println(quoted(aString)+" contains "+
                               wordCount(aString) + " words!");
         }
      } while(aString.length() > 0);
      System.out.println(quoted(aString)+" contains "+
                         wordCount(aString) + " words!");
      System.out.println("Done!!!");
   }

   public static int wordCount(String s) {
      Scanner scan = new Scanner(s);
      int result = 0;
      while(scan.hasNext()){
      scan.next();
      result++;
      }
      return result;
   }
   
   public static final String QUOTE = "\"";
   public static String quoted(String s) {
      return QUOTE + s + QUOTE;
   }
}