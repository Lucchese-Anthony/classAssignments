/* Temperatures Program** *
* Author: Anthony Lucchese *
* Course: CMPS 134 *
* Assignment: #2 9/15/19 *
* No collaboration */

import java.util.Scanner;

public class TemperaturesRevised {
   //lists the variables used, and the scanner
   static Scanner keyboard = new Scanner(System.in); 
   static double celsiusCieling, increment, celsius, fahrenheit, kelvin, rankine, delisle, newton, reaumur, romer;
//where the 3 inputs are processed
   public static void main(String[] args) { 
      System.out.println("PMJ's TemperaturesI0...");
      System.out.print("Enter a start value >:");
      celsius = keyboard.nextDouble();
      System.out.print("Enter a stop value >:");
      celsiusCieling = keyboard.nextDouble(); 
      System.out.print("Enter a interval value >:");
      increment = keyboard.nextDouble();
     //boundary is used twice so made it a variable, and then print the preliminary row 
      String boundary = "--------++--------+--------+--------+--------+--------+--------+--------+";
      System.out.println("      C ||      F |      K |      R |     De |      N |     Re |     Ro |\n" + boundary);
      //for loop calls the conversion and print statements from below in methods
      for(double startPoint = celsius ; startPoint <= celsiusCieling; startPoint = startPoint + increment){
         //exactly what printReal(); does but this uses two bars instead of one
         System.out.printf("%7.2f ||", celsius);
         fahrenheit();
         kelvin();    
         rankine();
         delisle();
         newton(); 
         reaumur();
         romer();
         System.out.println();
         celsius = celsius + increment;
      }
      System.out.print(boundary);
   }
   //given code, but added | to the string so i dont have to add it each time
   public static void printReal(double real) {
      System.out.printf("%7.2f |",real);
   }
   //the various temperature and print methods
   public static void fahrenheit(){
      fahrenheit = celsius * (9/5) + 32;
      printReal(fahrenheit);
   }
   public static void kelvin(){
      kelvin = celsius + 273.15;
      printReal(kelvin);
   } 
   public static void rankine(){
      rankine = kelvin * (9/5);
      printReal(rankine);
   }
   public static void delisle(){
      delisle = (100 - celsius) * 3/2;
      printReal(delisle);
   }
   public static void newton(){
      newton = celsius * 33/100;
      printReal(newton);
   }
   public static void reaumur(){
      reaumur = celsius * 4/5;
      printReal(reaumur);
   }
   public static void romer(){
      romer = celsius * 21/40 + 7.5;
      printReal(romer);
   }
}