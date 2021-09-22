/* Java class that contains methods for converting calendar dates in 
** various formats into yyyymmdd format.  The date formats supported 
** are the following (with examples):
**
**   Format           Examples
**   ---------------  ------------------------------------------
**   mm/dd/yyyy       "10/08/2019", "10/8/2019", "5/15/1965"
**   dd-mm-yyyy       "08-10-2019", "8-10-2019", "15-5-1965"
**   yyyy-mm-dd       "2019-10-08", "2019-10-8", "1965-5-15"
**   dd-Mon-yyyy      "08-Oct-2019", "8-Oct-2019", "15-May-1965"
**   Month day, year  "October 08, 2019", "October 8, 2019"
**   day Month year   "08 October 2019", "8 October 2019"
**
** As implied by the examples, day and month numerals can include leading
** zeros but they need not.  (Year numerals can also be less than four
** digits, but no such examples are shown.)
**
** Each method attempts to convert the date given to it (via a parameter)
** into the corresponding date in the yyyymmdd format (e.g., "20191008").
** Each method has as a pre-condition that the date given to it is in the
** format that it expects, and therefore it is not responsible for what 
** it does if the string passed to it is not of the expected form.  For
** example, in such a case it may return a nonsensical string or it may
** cause an exception to be thrown.
** 
** None of the methods attempts to determine whether the date given to it
** is "semantically" (as opposed to "syntactically") correct.  For example,
** the method that handles mm/dd/yyyy dates will happily produce "19852357"
** when given the string "23/57/1985", even though there is no 23rd month 
** and no month has a 57th day.
**
** Author: P.M. Jackowitz & R. McCloskey
** Date: October 2019
*/

public class DateConverters {

   // Global constants
   // ----------------
   private static final char QUOTES = '"';
   private static final char SLASH = '/';
   private static final char BLANK = ' ';
   public static final char DASH   = '-';
   public static final char COMMA  = ',';
   
   /* Converts the given string, which is assumed to be a calendar date
   ** in mm/dd/yyyy form, to the corresponding date in yyyymmdd form.
   ** Example: Given "04/15/1985", returns "19850415".
   */
   public static String convertMMDDYYYY(String given) {
      String result = "";
      given = given.trim();  //Trim leading and trailing white space
      // Locate the two SLASHs
      int leftIndex = given.indexOf(SLASH);
      int rightIndex = given.lastIndexOf(SLASH);
      // Check to determine if both a left and right SLASH have been found
      if(leftIndex < rightIndex) {
         // Extract each of the three parts
         String month = given.substring(0,leftIndex).trim();
         String day   = given.substring((leftIndex+1),rightIndex).trim();
         String year  = given.substring(rightIndex+1).trim();
         // Formulate the rearrangementMMDDs of the parts
         result = Pad.padLeft(year,4,'0') + Pad.padLeft(month,2,'0') + Pad.padLeft(day,2,'0');
      }
      
      return result;
   }
   
   /* Converts the given string, which is assumed to be a calendar date
   ** in dd-mm-yyyy form, to the corresponding date in yyyymmdd form.
   ** Example: Given "24-10-2019", returns "20191024".
   */
   public static String convertDDMMYYYY(String given) {
      String result = "";
      given = given.trim();
      int leftIndex = given.indexOf(DASH);
      int rightIndex = given.lastIndexOf(DASH);
      if(leftIndex < rightIndex) {
         String day = given.substring(0,leftIndex).trim();
         String month = given.substring((leftIndex+1),rightIndex).trim();
         String year = given.substring(rightIndex+1).trim();
         result = Pad.padLeft(year,4,'0') + Pad.padLeft(month,2,'0') + Pad.padLeft(day,2,'0');
      }
      return result;
   }

   /* Converts the given string, which is assumed to be a calendar date
   ** in yyyy-mm-dd form, to the corresponding date in yyyymmdd form.
   ** Example: Given "2019-07-21", returns "20190721".
   */
   public static String convertYYYYMMDD(String given) {
      String result = "";
      given = given.trim();
      int leftIndex = given.indexOf(DASH);
      int rightIndex = given.lastIndexOf(DASH);
      if(leftIndex < rightIndex) {
         String year = given.substring(0,leftIndex).trim();
         String month = given.substring((leftIndex+1),rightIndex).trim();
         String day = given.substring(rightIndex+1).trim();
         result = Pad.padLeft(year,4,'0') + Pad.padLeft(month,2,'0') + Pad.padLeft(day,2,'0');
      }
      return result;
   }

   /* Converts the given string, which is assumed to be a calendar date
   ** in dd-Mon-yyyy form, to the corresponding date in yyyymmdd form.
   ** Example: Given "24-Oct-2019", returns "20191024".
   */
   public static String convertDDMonYYYY(String given) {
      String result = "";
      given = given.trim();
      int leftIndex = given.indexOf(DASH);
      int rightIndex = given.lastIndexOf(DASH);
      if(leftIndex < rightIndex) {
         String day = given.substring(0,leftIndex).trim();
         String month = monthOfAbbreviation(given.substring((leftIndex+1),rightIndex).trim());
         String year = given.substring(rightIndex+1).trim();
         result = Pad.padLeft(year,4,'0') + Pad.padLeft(month,2,'0') + Pad.padLeft(day,2,'0');
      }
      return result;
   }

   /* Converts the given string, which is assumed to be a calendar date in
   ** "Month day, year" form, to the corresponding date in yyyymmdd form.
   ** Example: Given "April 8, 2019", returns "20190408".
   */
   public static String convertMonthDayYear(String given) {
      String result = "";
      given = given.trim();
      int leftIndex = given.indexOf(BLANK);
      int rightIndex = given.lastIndexOf(COMMA);
      if(leftIndex < rightIndex) {
         String month = monthOfName(given.substring(0,leftIndex).trim());
         String day = given.substring((leftIndex+1),rightIndex).trim();
         String year  = given.substring(rightIndex+1).trim();
         result = Pad.padLeft(year,4,'0') + Pad.padLeft(month,2,'0') + Pad.padLeft(day,2,'0');
      }
      return result;
   }

   /* Converts the given string, which is assumed to be a calendar date in
   ** "day Month year" form, to the corresponding date in yyyymmdd form.
   ** Example: Given "8 July 2014", returns "20140708".
   */
   public static String convertDayMonthYear(String given) {
      String result = "";
      given = given.trim();
      int leftIndex = given.indexOf(BLANK);
      int rightIndex = given.lastIndexOf(BLANK);
      if(leftIndex < rightIndex) {
         String day = given.substring(0,leftIndex).trim();
         String month = monthOfName(given.substring((leftIndex+1),rightIndex).trim());
         String year = given.substring(rightIndex+1).trim();
         result = Pad.padLeft(year,4,'0') + Pad.padLeft(month,2,'0') + Pad.padLeft(day,2,'0');
      }
      return result;
   }
   
   // Constant that contains each of the names of the months
   private static final String NAMES = ",january,february,march,april,may,june" +
                                       ",july,august,september,october,novmber,december";
   
   // Functional method that returns a two-digit string representing the month number
   // of the given month name abbreviation.  Example: "jul", "Jul" or "JUL" yields "07".
   public static String monthOfAbbreviation(String abbreviation) {
      return convertMonth(abbreviation);
   }
   
   // Functional method that returns a two-digit string representing the month number
   // of the given month name.  Example: "november" yields "11".
   public static String monthOfName(String name) {
      return convertMonth(name);
   }

   // Functional method that locates the given string in NAMES and returns the count
   // of the number of commas preceding it as a two-digit string.
   private static String convertMonth(String which) {
      String result = "??";
      int index = NAMES.indexOf(COMMA+which.toLowerCase());
      if(index >= 0) {
         result = Pad.padLeft((""+countBackInNAMES(index)),2,'0');
      }
      return result;
   }

   // Functional method that returns the count of the number of commas appearing in
   // NAMES at or before the given index position
   private static int countBackInNAMES(int index) {
      int result = 1;
      while (index > 0) {
         result = result + 1;
         index = NAMES.lastIndexOf(COMMA,(index-1));
      }
      return result;
   }

}