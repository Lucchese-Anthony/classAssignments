/* Anthony Lucchese
Prof. Jackowitz
As 03
no collaborators
known defects: works slightly, i really tried my best, will talk to a friend in comp sci 2 (Thomas Emma), or one of the GA's
it does variate the rows and columns and sixe of square, but i lost track of where i went
*/

import java.util.Scanner;

public class drawVarSizeCheckerBoard {

   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      
      int numberOfRows, numberOfColumns, squareWidth, squareHeight;
      numberOfRows = getInt("Enter number of rows:>", keyboard, 0, 24);
      numberOfColumns = getInt("Enter number of columns :>", keyboard, 0, 24);
      squareWidth = getInt("Enter square width :>", keyboard, 0, 16);
      squareHeight = getInt("Enter square height :>", keyboard, 0, 8);
   
      printColumns(numberOfColumns, numberOfRows, squareHeight, squareWidth);
  
   }
   public static void printColumns(int numberOfColumns, int numberOfRows, int squareHeight, int squareWidth){
     for(int i = 0; i <= (numberOfColumns / 2); i++){
       printRows(numberOfRows, squareHeight, squareWidth);
     } 
   }
   
   public static void printRows(int numberOfRows, int squareHeight, int squareWidth){
      for(int i = 0; i <= (numberOfRows / 4) ; i++){
         for(int black = 0; black <= squareHeight / 2; black++){
            blackRows(squareHeight, squareWidth);
         }
         for(int white = 0; white <= squareHeight / 2; white++){
            whiteRows(squareHeight, squareWidth);
         }
      }
   }
   
   public static void blackRows(int squareHeight, int squareWidth){
      for(int i = 0; i < squareHeight; i++){
      
         blackBlock(squareWidth);
         whiteBlock(squareWidth);
      }
      
      System.out.println();
   }
   
   public static void whiteRows(int squareHeight, int squareWidth){
      for(int i = 0; i < squareHeight; i++){
         whiteBlock(squareWidth);
         blackBlock(squareWidth);
      }
      System.out.println(); 
   }
   
   public static void whiteBlock(int squareWidth){
      for(int i = 0; i < squareWidth; i++){
         System.out.print(" ");
      }
   }
   
   public static void blackBlock(int squareWidth){
      for(int i = 0; i< squareWidth; i++){
         System.out.print("*");
      }
   }
   
   public static int getInt(String prompt, Scanner input, int lower, int upper) {
      int result = 0;
      boolean keepAsking = true;
      while (keepAsking) {
         System.out.print(prompt);
         result = input.nextInt();
         if (result >= lower  &&  result <= upper) {
            keepAsking = false;
         }
         else {
            System.out.println("  Sorry, your input must be in the range " + lower + ".." + upper);
         }
      }
      return result;
   }   
}