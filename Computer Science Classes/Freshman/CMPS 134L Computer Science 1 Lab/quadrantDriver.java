/* quadrantDriver.java
**
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2018
**
** Collaboration: 
**
** Java application that 
**
*/
import java.util.Scanner;
public class quadrantDriver {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      double x, y;
      do {
         System.out.print("Enter x:>");  x = keyboard.nextDouble();
         System.out.print("Enter y:>");  y = keyboard.nextDouble();
         if((x != 0.0) || (y != 0.0)) {
            System.out.printf("(%5.2f,%5.2f) is in quadrant ",x,y);
            System.out.println(quadrant(x,y));
         }
      } while((x != 0.0) || (y != 0.0));
      System.out.println("Done!!!");
   }
   
   public static int quadrant(double x, double y) {
      int result = 0;
      if(x>0&&y>0)
         return 1;
      
      else if(x<0&&y<0)
         return 3;
      
      else if(x<0&& y>0)
         return 2;
      
      else if (x>0&& y<0)
         return 4;
   
   
   
      return result;
   }
}