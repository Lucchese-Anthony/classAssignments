/* Java class instances of which represent a pile/collection of U.S. coins
** of various denominations.
*/
public class CoinJar {

   // class constants
   // ---------------
   
   public static final char PENNY = 'P';
   public static final char NICKEL = 'N';
   public static final char DIME = 'D';
   public static final char QUARTER = 'Q';
   public static final char HALF_DOLLAR = 'H';

   public static final String COINS = "" + PENNY + NICKEL + 
                                           DIME + QUARTER + HALF_DOLLAR;

   // Array holding value of each coin denomination
   private static final int[] VALUE = { 1, 5, 10, 25, 50 };

   // Array holding roll capacity of each coin denomination

   // DECLARATION STUBBED!!!

   // instance variables
   // ------------------
   
   // Array holding the current number of coins of each denomination

   // DECLARATION STUBBED!!!

   // constructor
   // -----------

   public CoinJar() { 
   }

   // mutator
   // -------

   /* Adds to the pile one instance of the coin specified by the given code.
   ** In the event the coinCode is invalid the method has no effect.
   */
   public void addCoin(char coinCode) {
      int index = COINS.indexOf(coinCode);
      if(index >= 0) {
      //STUBBED!!!
      }
   }

   // observers
   // ---------

   /* Returns the number of coins of the specified denomination in the pile.
   ** In the event the coinCode is invalid zero is returned..
   */
   public int numberOf(char coinCode) { 
      int result = 0;
      int index = COINS.indexOf(coinCode);
      if(index >= 0) {
      //STUBBED!!!
      }
      return result;
   }

   /* Returns the total value of the coins of the specified denomination 
   ** currently in the pile. In the event the coinCode is invalid zero is 
   ** returned.
   */
   public int valueOf(char coinCode) { 
      int result = 0;
      int index = COINS.indexOf(coinCode);
      if(index >= 0) {
      //STUBBED!!!
      }
      return result;
   }

   /* Returns the number of full rolls of the specified denomination that can
   ** be formed from the coins in the pile. In the event the coinCode is invalid
   ** zero is returned.
   */
   public int numberOfFullRolls(char coinCode) {
      int result = 0;
      //STUBBED!!!
      return result;
   }

}
