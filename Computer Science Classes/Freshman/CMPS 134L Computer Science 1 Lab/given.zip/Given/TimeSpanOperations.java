/* TimeSpanOperations.java
** 
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2018
**
** Last Modified: October 15, 2018
** Collaboration: R. W. M.
**
** Java class containing a few "utility" methods pertaining to descriptions
** of time spans.
*/
public class TimeSpanOperations {

   private static final String COLON = ":";

   /* Given a String of the form x:y, where x and y are integer numerals,
   ** returns the integer represented by x.  If there is no colon, or a
   ** colon is the first character in the given String, zero is returned.
   ** Examples: "13:25" yields 13; ":47" yields 0.
   */
   public static int parseOutHour(String timeValue) {
      int result = 0;
      int index = timeValue.indexOf(COLON);
      if(index > 0) {
         result = Integer.parseInt(timeValue.substring(0,index).trim());
      }
      return result;
   }
   
   /* Given a String of the form x:y, where x and y are integer numerals,
   ** returns the integer represented by y.  If there is no colon, or
   ** colon is the last character in the given String, zero is returned.
   ** Examples: "13:25" yields 25; ":47" yields 47, "23:" yields zero.
   */
   public static int parseOutMinute(String timeValue) {
      int result = 0;
      int index = timeValue.lastIndexOf(COLON);
      if(index >= 0 && index < timeValue.length()-1) {
         result = Integer.parseInt(timeValue.substring(index+1).trim());
      }
      return result;
   }
      
   /* Given a number of minutes, returns the number of "full hours"
   ** that it covers.  E.g., 0-59 minutes covers zero full hours,
   ** 60-119 minutes covers one full hour, 120-179 minutes covers
   ** two full hours, etc., etc.
   */
   public static int fullHoursOf(int minutes) {
      return minutes / 60;
   }
   
   /* Given a number of minutes, returns the number of "residual minutes"
   ** left over after "subtracting out" all the covered full hours.
   ** E.g., 143 minutes covers two full hours, with 23 residual minutes
   ** left over.
   */
   public static int fullResidualMinutesOf(int minutes) {
      return minutes % 60;
   }
   
}
