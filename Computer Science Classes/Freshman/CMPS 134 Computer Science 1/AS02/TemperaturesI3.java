import java.util.Scanner;

public class TemperaturesI3 {

   static Scanner keyboard = new Scanner(System.in); 
   static double celsius, fahrenheit, kelvin, rankine, delisle, newton, reaumur, romer;

   public static void main(String[] args) { 
      System.out.println("PMJ's TemperaturesI0...");
      
      System.out.print("Enter a start value >:");
      double celsius = keyboard.nextDouble();
      System.out.print("Enter a stop value >:");
      double celsiusCieling = keyboard.nextDouble();
      System.out.print("Enter a interval value >:");
      double increment = keyboard.nextDouble();
      System.out.println("      C ||      F |      K |      R |     De |      N |     Re |     Ro |");
      
      for(double startpoint = celsius ; startPoint <= celsiusCieling; startPoint = startPoint + increment){
      fahrenheit = celsius * (9/5) + 32;
      kelvin = celsius + 273.15;
      rankine = kelvin * (9/5);
      delisle = (100 - celsius) * 3/2;
      newton = celsius * 33/100;
      reaumur = celsius * 4/5;
      romer = celsius * 21/40 + 7.5;
      System.out.printf("%7.2f ||", celsius);
      printReal(fahrenheit);
      printReal(kelvin);
      printReal(rankine);
      printReal(delisle);
      printReal(newton);
      printReal(reaumur);
      printReal(romer);
      System.out.println();
      }
   }
    public static void printReal(double real) {
         System.out.printf("%7.2f |",real);
   }
      
}