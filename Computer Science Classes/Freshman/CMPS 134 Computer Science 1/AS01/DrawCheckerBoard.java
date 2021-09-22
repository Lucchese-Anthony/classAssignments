/* Checkerboard Program**
** Author: Anthony Lucchese
** Course: CMPS 134
** Assignment: #1 9/4/19
** No collaboration
*/


public class DrawCheckerBoard {

   public static void main(String[] args) {
      boundary();
      printBlack();
      printWhite();
      printBlack();
      printWhite();
      printBlack();
      printWhite();
      printBlack();
      printWhite();
      boundary();
   }
   public static void printWhite(){
   System.out.println("|    ****    ****    ****    ****|");
   System.out.println("|    ****    ****    ****    ****|");
   System.out.println("|    ****    ****    ****    ****|");
   }
   public static void printBlack(){
   System.out.println("|****    ****    ****    ****    |");
   System.out.println("|****    ****    ****    ****    |");
   System.out.println("|****    ****    ****    ****    |");
   }
   
   public static void boundary(){
   System.out.println("+--------------------------------+");
   }

}

