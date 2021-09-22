/* isPalindromeDriver.java
**
** Author:   P. M. J. 
** Course:   CMPS 134
** Semester: Fall 2017
**
** Last Modified: October 15, 2017
** Collaboration: 
**
** Java application that 
**
*/
import java.util.Scanner;
public class isPalindromeDriver {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      String aString;
      do {
         System.out.print("Enter a String:>");  aString = keyboard.nextLine().trim();
         if(aString.length() > 0) {
            boolean determination = isPalindrome(aString);
            System.out.print(quoted(aString) + " is ");
            if(!determination) {
               System.out.print("not ");
            }
            System.out.println("a palindrome!");
         }
      } while(aString.length() > 0);
      System.out.println("Done!!!");
   }

   public static boolean isPalindrome(String s) {
   String reverse="";
   for(int i = s.length()-1;i>=0;i--){
      reverse+=s.charAt(i);
   }
   if(reverse.equals(s)){
      return true;}
   else{
   return false;}
   }
   
   public static final String QUOTE = "\"";
   public static String quoted(String s) {
      return QUOTE + s + QUOTE;
   }
}