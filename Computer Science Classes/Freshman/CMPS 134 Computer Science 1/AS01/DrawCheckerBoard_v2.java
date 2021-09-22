/* Checkerboard Program v2**
** Author: Anthony Lucchese
** Course: CMPS 134
** Assignment: #1 9/4/19
** No collaboration
*/


// I used for loops on this version, for the version according to the homework, check the file without the 'v2' in the name

public class DrawCheckerBoard_v2 {

   public static void main(String[] args) {
      drawBoard();
   }
   
   public static void drawBoard() {
   
      // Declare top and bottom boundary
      String boundary = "+--------------------------------+";
      
      // Print top boundary
      System.out.println(boundary);
      
      // Declare the Black row
      String BWrow = "|****    ****    ****    ****    |";
      
      // Declare the White row
      String WBrow = "|    ****    ****    ****    ****|";
         
      // the while loop reiterates the print lines below 3 more times
      for(int n = 0; n<4; n++){
          // The two prints below print out the first three lines
          System.out.println(BWrow + "\n" + BWrow + "\n" + BWrow);
          System.out.println(WBrow + "\n" + WBrow + "\n" + WBrow);
          }
           
      // Print final boundary
      System.out.println(boundary);
   }

}

