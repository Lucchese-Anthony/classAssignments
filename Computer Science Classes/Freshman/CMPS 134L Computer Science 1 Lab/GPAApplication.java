/* GPAApplication.java
**
** Java application that, given an input file containing raw data about
** students, the courses that they took, and the grades they earned in
** those courses, produces a report showing each student's GPA.
**
** CMPS 134 Fall 2019 Prog. Assg. #5
** Authors: R. McCloskey and ...
** Known defects: ...
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GPAApplication {

   private static Scanner keyboard;  // to read input entered by user
   private static Scanner input;     // to read data from input file

   public static void main(String[] args) throws FileNotFoundException {
      keyboard = new Scanner(System.in);
      String fileName = getStringFromUser("Enter name of input file: ");
   
     // Establish a Scanner to read from the file with the specified name.
      input = new Scanner(new File(fileName));  
   
      printHeading();
   
      while (input.hasNextLine()) {
         processStudent();
      }
   
      System.out.println("\nGoodbye!");
   }

   /* Reads the data pertinent to a single student (name, birthdate, etc.)
   ** using the 'input' Scanner and prints the resulting output record (name,
   ** birthdate (in the required forms), gpa, and a remark, if appropriate.
   */
   private static void processStudent() {
     // STUB!
   }

   /* Given a student's name, birthdate, GPA, and an annotation, prints
   ** an output record, properly formatted.
   */
   private static void printStudent(String name, String birthDate,
                                    double gpa, String annotation) {
      System.out.printf("%-25s%11s    %4.2f  %s\n", 
                        name, birthDate, gpa, annotation);
   }

   /* Given a name in the "first middle last" format, (with middle name 
   ** possibly absent), returns the corresponding name in "last, first" format.
   ** Examples:
   **  "Roger Edwin Goofball" maps to "Goofball, Roger"
   **  "Amy Klunkhead" maps to "Klunkhead, Amy"
   */
   private static String convertedName(String fullName) {
      return "?????, ???";   // STUB!
   }

   /* Given a calendar date expressed in yyyymmdd format, returns the
   ** same date expressed in dd-Mon-yyyy format.
   ** Examples: 
   **   "20191016" maps to "16-Oct-2019"
   **   "19870309" maps to "09-Mar-1987"
   */
   private static String convertedDate(String yyyymmdd) {
      return "??-???-????";   // STUB!
   }

   /* Given a month number, returns the corresponding 3-character abbreviation.
   ** Each month's abbreviation is the first three letters of its name, with
   ** only the first letter capitalized.
   ** Examples:
   **   3 maps to "Mar"
   **   8 maps to "Aug"
   */
   private static String abbreviationOf(int monthNumber) {
      return "???";   // STUB!
   }

   /* Returns an annotation appropriate to the given GPA.  Specifically, it
   ** returns one of the three strings "Dean's List", "Academic Probation",
   ** or "" (the empty string), according to whether the given GPA value is
   ** at least 3.5, less than 2.0, or neither, respectively.
   */
   private static String annotationOf(double GPA) {
      return "?????";   // STUB!
   }

   /* Returns the number of quality points awarded according to the given 
   ** letter grade in a course worth the given number of credits.
   */
   private static double courseQualityPointsOf(int credits, String letterGrade) {
      return 0.0;   // STUB!
   }

   /* Returns the number of quality points associated to the given letter grade.
   ** Exhaustive mapping:
   **  "A"  maps to 4.0      "C+" maps to 2.33     "F" maps to 0.0
   **  "A-" maps to 3.67     "C"  maps to 2.0
   **  "B+" maps to 3.33     "C-" maps to 1.67
   **  "B"  maps to 3.0      "D+" maps to 1.33
   **  "B-" maps to 2.67     "D"  maps to 1.0
   */
   private static double qualityPointsOf(String grade) {
      double result = 0.0;
      if (grade.equals("A")) { result = 4.0; }
      else if (grade.equals("A-")) { result = 3.67; }
      else if (grade.equals("B+")) { result = 3.33; }
      else if (grade.equals("B"))  { result = 3.0; }
      else if (grade.equals("B-")) { result = 2.67; }
      else if (grade.equals("C+")) { result = 2.33; }
      else if (grade.equals("C"))  { result = 2.0; }
      else if (grade.equals("C-")) { result = 1.67; }
      else if (grade.equals("D+")) { result = 1.33; }
      else if (grade.equals("D"))  { result = 1.0; }
      else if (grade.equals("F"))  { result = 0.0; }
      return result;
   }

   /* Prints the given prompt and reads/returns a line of data read
   ** using the keyboard Scanner.
   */
   private static String getStringFromUser(String prompt) {
      System.out.print(prompt);
      return keyboard.nextLine();
   }

   /* Prints the heading of the report.
   */
   private static void printHeading() {
      System.out.printf("%-25s%13s  %3s   %10s\n", 
                        "Name", "Date of Birth", "GPA", "Annotation");
      printChars('-', 64);
      System.out.println();
   }

   /* Prints the specified character the specified number of times.
   */
   private static void printChars(char ch, int numTimes) {
      for (int i=0; i != numTimes; i++) {
         System.out.print(ch);
      }
   }

}
