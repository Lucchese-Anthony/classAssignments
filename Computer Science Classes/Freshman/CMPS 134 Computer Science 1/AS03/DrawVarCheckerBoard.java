import java.util.Scanner;

public class DrawVarCheckerBoard {
   public static int numberOfRows, numberOfColumns, squareWidth, squareHeight;

   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      
   
      numberOfRows = getInt("Enter number of rows:>", keyboard, 0, 24);
      numberOfColumns = getInt("Enter number of columns :>", keyboard, 0, 24);
      squareWidth = getInt("Enter square width :>", keyboard, 0, 16);
      squareHeight = getInt("Enter square height :>", keyboard, 0, 8);
   
      drawBoard();   
   }
   public static void drawBoard(){
      drawColumns();
   }
   
   public static void drawBlackHeight(){
      for(int i = 0; i < squareHeight; i++){
         drawBlackWidth();
      }
   }
   
   public static void drawBlackWidth(){
      sideBoundary();
      boxFull();
      boxEmpty();
      sideBoundary();
   }
   
   public static void drawWhiteHeight(){
      for(int i = 0; i < squareHeight; i++){
         drawBlackWidth();
      }
   }
   
   public static void drawWhiteWidth(){
      sideBoundary();
      boxEmpty();
      boxFull();
      sideBoundary();
   }
   
   public static void boxEmpty(){
      for(int i = 0; i < squareWidth; i++){
         System.out.print(" ");
      }
   }
   
   public static void boxFull(){
      for(int i = 0; i < squareWidth; i++){
         System.out.print("*");
      }
   }
   
   public static void drawRows(){
      for(int i = 0; i < numberOfRows; i++){
         drawBlackHeight();
         drawWhiteHeight();
      }
   }
   
   public static void drawColumns(){
      for(int i = 0; i < numberOfColumns; i++){
         drawRows();
      }
   }
   
   public static void sideBoundary(){
      System.out.print("|");
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