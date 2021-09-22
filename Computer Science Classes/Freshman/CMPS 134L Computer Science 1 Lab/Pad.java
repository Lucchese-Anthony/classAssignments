/* Java class that has methods to "pad" strings to a specified length 
** by appending or prepending occurrences of a specified character.
*/

public class Pad {

   /* Functional method that returns the string formed by prepending to 
   ** the given string the appropriate number of occurrences of the given 
   ** character so that the resultant string is of the specified length.
   ** In the event that the given string's length is greater than the 
   ** desired length, the given string is returned.
   ** Example: padLeft("Glorp", 9, 'x') yields "xxxxGlorp".
   */
   public static String padLeft(String string, 
                                int desiredLength,
                                char leadingChar) {
      String result = string;
      while(result.length() < desiredLength) {
         result = leadingChar + result;
      }
      return result;
   }
   
   /* Functional method that returns the string formed by appending to 
   ** the given string the appropriate number of occurrences of the given 
   ** character so that the resultant string is of the specified length.
   ** In the event that the given string's length is greater than the 
   ** desired length, the given string is returned.
   ** Example: padRight("Glorp", 8, '$') yields "Glorp$$$".
   */
   public static String padRight(String string, 
                                 int desiredLength,
                                 char trailingChar) {
      String result = string;
      while(result.length() < desiredLength) {
         result = result + trailingChar;
      }
      return result;
   }
   
}
