/* Java application that prompts the user to enter a string intended to 
** identify one of the following six possible date formats:
**
**   String           Format           Example
**   ---------------  ---------------  ---------------
**   MMDDYYYY         mm/dd/yyyy       10/08/2019
**   DDMMYYYY         dd-mm-yyyy       08-10-2019
**   YYYYMMDD         yyyy-mm-dd       2019-10-08
**   DDMonYYYY        dd-Mon-yyyy      08-Oct-2019
**   MonthDayYear     Month day, year  October 08, 2019
**   DayMonthYear     day Month year   08 October 2019
**
** The program then attempts to open a file for the purpose of reading
** specific date values in that format and converting each value into the
** corresponding value in the yyyymmdd format (e.g., "20191008"), and the 
** results are printed for the user to see.
**
** Author: P.M. Jackowitz & R. McCloskey
** Date: October 2019
*/
import java.util.Scanner;
import java.io.*;

public class DateConversionTester {

   // Global constants
   public static final char QUOTES = '"';
   public static final char BLANK = ' ';
   // String indicators for date formats
   private static final String MMDDYYYY = "MMDDYYYY";
   private static final String DDMMYYYY = "DDMMYYYY";
   private static final String YYYYMMDD = "YYYYMMDD";
   private static final String DDMonYYYY = "DDMonYYYY";
   private static final String MonthDayYear = "MonthDayYear";
   private static final String DayMonthYear = "DayMonthYear";
   
   // Scanner object through which input data is read from the keyboard.
   public static Scanner keyboard = new Scanner(System.in);
   
   public static void main(String[] args) throws FileNotFoundException {
      String format = getFormat();
      Scanner input = new Scanner(new File(format+".txt"));
      String givenDate;
      // Loop to read and process each line of the file
      while(input.hasNextLine()) {
         // Read next line from file
         givenDate = input.nextLine().trim();
         if(givenDate.length() > 0) {
            System.out.print(Pad.padRight(quoted(givenDate),28,' ') + " becomes ");
            doConversion(givenDate,format);
            System.out.println();
         }
      }
      System.out.println("Done!");
   }

   private static String getFormat() {
      String result = "";
      do {
         System.out.print("Indicate format:>");
         String attempt = keyboard.nextLine().trim();
         if(attempt.equals(MMDDYYYY) || attempt.equals(DDMMYYYY) || attempt.equals(YYYYMMDD) ||
            attempt.equals(DDMonYYYY) || attempt.equals(MonthDayYear) || attempt.equals(DayMonthYear)) {
            result = attempt;
         } else {
            System.out.println("Incorrect; please enter one of:\n" +
                               quoted(MMDDYYYY) + ", " +  quoted(DDMMYYYY) + ", " +  
                               quoted(YYYYMMDD) + ", " +  quoted(DDMonYYYY) + ", " +  
                               quoted(MonthDayYear) + ", " +  quoted(DayMonthYear) );
         }
      } while(result.length() == 0);
      return result;   
   }
   
   /* Applies each of the conversion methods in the DateConverters class
   ** to the given string, reporting each result.  (If a conversion method
   ** throws an exception, the reported result is the empty string.)
   */
   private static void doConversion(String date, String format) {
      String converted = "";
      if(format.equals(MMDDYYYY)) {
         // Convert assuming givenDate is in the mm/dd/yyyy form
         converted = DateConverters.convertMMDDYYYY(date);
      } else if(format.equals(DDMMYYYY)) {
         // Convert assuming date is in the dd-mm-yyyy form
         converted = DateConverters.convertDDMMYYYY(date);
      } else if(format.equals(YYYYMMDD)) {
         // Convert assuming date is in the yyyy-mm-dd form
         converted = DateConverters.convertYYYYMMDD(date);
      } else if(format.equals(DDMonYYYY)) {
         // Convert assuming date is in the dd-Mon-yyyy form
         converted = DateConverters.convertDDMonYYYY(date);
      } else if(format.equals(MonthDayYear)) {
         // Convert assuming date is in the "Month day, year" form
         converted = DateConverters.convertMonthDayYear(date);
      } else if(format.equals(DayMonthYear)) {
         // Convert assuming givenDate is in the "day Month year" form
         converted = DateConverters.convertDayMonthYear(date);
      }
      System.out.print(quoted(converted));
      if(!isValidYYYYMMDD(converted)) {
         System.out.print(" ERROR !!!");
      }
   }
   
   public static boolean isValidYYYYMMDD(String date) {
      boolean result = (date.length() == 8);
      for(int i=0; result && (i<8); i++) {
         result = Character.isDigit(date.charAt(i)); 
      }
      return result;
   }
   
   // utility method
   // --------------
   
   /* Functional method that merely returns the given string surrounded 
   ** by quotes.
   */
   public static String quoted(String s) {
      return QUOTES + s + QUOTES;
   }

}
