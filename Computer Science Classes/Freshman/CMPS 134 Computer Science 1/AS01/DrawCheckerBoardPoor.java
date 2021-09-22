/* Java application that "draws" a (8x8) checkerboard, in a rather naive way.
** To illustrate, output would look like this:
**
**   +--------------------------------+
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |****    ****    ****    ****    |
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   |    ****    ****    ****    ****|
**   +--------------------------------+
**
** Author: R. McCloskey, P. M. Jackowitz
** Date: Aug. 2019
*/

public class DrawCheckerBoardPoor {

   public static void main(String[] args) {
      drawBoard();
   }
   
   public static void drawBoard() {
      // Draw boundary at top of board.
      System.out.println("+--------------------------------+");
   
      // Draw the first BW row.
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
   
      // Draw the first WB row.
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
   
      // Draw the second BW row.
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
   
      // Draw the second WB row.
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
   
      // Draw the third BW row.
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
   
      // Draw the third WB row.
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
   
      // Draw the fourth BW row.
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
      System.out.println("|****    ****    ****    ****    |");
   
      // Draw the fourth WB row.
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
      System.out.println("|    ****    ****    ****    ****|");
   
      // Draw boundary at bottom of board.
      System.out.println("+--------------------------------+");
   }

}

