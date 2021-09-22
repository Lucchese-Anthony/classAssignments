/* MeanHHMMSS.java
**
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2018
**
** Last Modified: October 15, 2018
** Collaboration: R. W. M.
**
** Java application that reads a text file containing a sequence of "time values",
** one per line, determines the mean of these values and prints that result.
**
** In this version of the program, each "time value" is expressed as full hours and
** full residual minutes, in the form hh:mm.  Thus, each of the following are valid examples.
**
** "12:34", "942:17", "5:6", etc.
**
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MeanHHMMSS {
   
   public static void main(String[] args) throws FileNotFoundException {
   
      // Use the first run-time argument as the name of the file to be read
      String fileID = args[0];
      Scanner input = new Scanner(new File(fileID));
      
      TimeSpan totalTime = new TimeSpan(0,0,0);
      int count = 0;
      
      // Loop to read and process each time value
      while(input.hasNextLine()) {
         count = count + 1;
         // Read the next line from the input as a string
         String line = input.nextLine().trim();
         // Construct a new object to represent this value
         TimeSpan time = new TimeSpan(line);
         // Add to the total and print the running value
         totalTime.add(time);
         System.out.println(count + ") " + 
                            time.toString() + " accumulates to " + totalTime.toString());
      }
      
      // Determine and print the result
      System.out.print("The mean time is ");
      if(count > 0) {
         int timeInSeconds = totalTime.getTime();
         int meanTimeInSeconds = timeInSeconds / count;
      
         TimeSpan meanTime = new TimeSpan(meanTimeInSeconds);
         System.out.println(meanTime);
      } else {
         System.out.println("unknown!");
      }
      System.out.println();
   }
   
}
