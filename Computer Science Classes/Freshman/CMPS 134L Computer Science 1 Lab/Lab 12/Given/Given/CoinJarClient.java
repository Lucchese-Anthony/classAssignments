/* CoinJarClient.java
**
** Author:   P. M. J. 
** Course:   CMPS 134L
** Semester: Spring 2018
**
** Last Modified: April 16, 2018
** Collaboration: Dr. McCloskey and the GTAs.
**
** Java application that exercises the CoinJar class.
*/
import java.util.*;
import java.io.*;
public class CoinJarClient {
   
   public static void main(String[] args) throws FileNotFoundException {
      File file;
      Scanner input;
      CoinJar piggyBank = new CoinJar();
      
      //Use the run-time argument to accept the name of the file to be read
      if(args.length == 1) {
         file = new File(args[0]);
         input = new Scanner(file);
         readAndProcessInput(input, piggyBank);
         reportResults(piggyBank);
      }      
      else {
         throw new IllegalArgumentException("Incorrect number of run-time arguments");
      } 
   }
   
   public static void readAndProcessInput(Scanner input, CoinJar cp) {
      String line;
      while(input.hasNextLine()) {
         line = input.nextLine().trim();
         for(int i=0; i<line.length(); i++) {
            cp.addCoin(line.charAt(i));
         }
      }
   }
   
   public static void reportResults(CoinJar cp) {
      int countTotal = 0;
      int centsTotal = 0;
      char coin;
      int count;
      int cents;
      for(int index=0; index<CoinJar.COINS.length(); index++) {
         coin = CoinJar.COINS.charAt(index);
         count = cp.numberOf(coin);
         cents = cp.valueOf(coin);
         countTotal = countTotal + count;
         centsTotal = centsTotal + cents;
         System.out.printf("%c (%d) yields $%s.%s, filling %d rolls.\n",
                 coin, count, 
                 dollarsOf(cents), centsOf(cents),
                 cp.numberOfFullRolls(coin));
      }
      System.out.printf("  (%d) yields $%s.%s\n",countTotal,
                        dollarsOf(centsTotal), centsOf(centsTotal));
   }

   public static String dollarsOf(int centsTotal) {
      return "" + (centsTotal/100);
   }
   
   public static String centsOf(int centsTotal) {
      String result = "" + (centsTotal % 100);
      if(result.length() < 2) { result = "0" + result; }
      return result;
   }

  
}