import java.util.Scanner;

public class TemperaturesI1 {

   static Scanner keyboard = new Scanner(System.in); 
   static double celsius, fahrenheit, kelvin, rankine, delisle, newton, reaumur, romer;

   public static void main(String[] args) { 
      System.out.println("PMJ's TemperaturesI0...");
      
      System.out.print("Enter a Celsius value >:");
      celsius = keyboard.nextDouble();
      fahrenheit = celsius * (9/5) + 32;
      kelvin = celsius + 273.15;
      rankine = kelvin * (9/5);
      delisle = (100 - celsius) * 3/2;
      newton = celsius * 33/100;
      reaumur = celsius * 4/5;
      romer = celsius * 21/40 + 7.5;
      
      System.out.print(celsius + " || ");
      System.out.print(fahrenheit + " | ");
      System.out.print(kelvin + " | ");
      System.out.print(rankine + " | ");
      System.out.print(delisle + " | ");
      System.out.print(newton + " | ");
      System.out.print(reaumur + " | ");
      System.out.print(romer + " | ");
      
      
         
      System.out.println();
   
   }
      
}