import java.util.Scanner;

/* FPAE_Utils.java
** CMPS 144L 
** Team members: Anthony Lucchese, Steven Prosperino
** Known defects: ...
*/

/* Java class that has static methods by which to determine whether or 
** not a given String is a well-formed (i.e., syntactically correct) FPAE
** (fully-parenthesized arithmetic expression) and to evaluate such
** an expression.
**
** To be a well-formed FPAE, a String must be either
**   (1) an integer literal (e.g., "534", "3") or
**   (2) of the form  ( E op F ) where op is an arithmetic operator
**       (i.e., one of +, -, *, or /) and both E and F are FPAE's.
**       In particular, adjacent elements of the expression must be
**       separated by at least one space.
**
** Expressions satisfying (1) are said to be "atomic" and those satisfying (2)
** are said to be "composite".  Examples of well-formed FPAE's:
** 
** "65", "( ( 3 - 7 ) * 352 )", "( ( 2 + 321 ) / ( 2 * ( 3 - ( 2 * 15 ) ) ) )"
*/

public class FPAE_Utils {

   // class constants
   // ---------------
   private static final String LEFT_PAREN = "(";
   private static final String RIGHT_PAREN = ")";
   private static final String PLUS = "+";
   private static final String MINUS = "-";
   private static final String TIMES = "*";
   private static final String DIVIDE = "/";
   private static final String ARITH_OPS = PLUS + MINUS + TIMES + DIVIDE;


   // main() method (for testing purposes)
   // ------------------------------------

   /* Prompts the user to enter an FPAE and, if it is found to be well-formed
   ** by the isWellFormed() method, the result of evaluating it using the
   ** valueOf() method is displayed.  If it is found not to be well-formed,
   ** a message conveying that fact is displayed.  This repeats until the 
   ** user enters the empty string in response to the prompt.
   */
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter FPAE: "); 
      String s = keyboard.nextLine();
      while (s.length() != 0) {
         if (!isWellFormed(s)) {
            System.out.println("Expression found not to be well-formed.");
         }
         else {
            System.out.println(valueOf(s));
         }

         System.out.print("\nEnter FPAE: "); 
         s = keyboard.nextLine();
      }
      System.out.println("Goodbye.");
   }


   // public methods
   // --------------

   /* Reports whether or not the given String describes a well-formed FPAE.
   ** pre: fpae has at least one non-space character in it.
   */
   public static boolean isWellFormed(String fpae)
   {
      final int LEFT_PAREN_CODE = 0;  // no need for a right paren code, as it
      final int OPERATOR_CODE = 1;    // would never be pushed onto the stack 
      final int OPERAND_CODE = 2;

      StackViaArray<Integer> stack = new StackViaArray(fpae.length());
      Scanner scanner = new Scanner(fpae);

      boolean goodSoFar = true;

      while (goodSoFar && scanner.hasNext()) {

         String token = scanner.next();
         
         if(isLeftParen(token)) {
        	 //add to parentheses stack
        	 stack.push(LEFT_PAREN_CODE);
         } else if(isIntegerLiteral(token)) {
        	 //if int
        	 stack.push(OPERAND_CODE);
         } else  if(isArithOperator(token)){
        	 //if its an operator
        	 stack.push(OPERATOR_CODE);
         } else if(isRightParen(token)){
        	 //right parentheses
        	 System.out.println(stack.toString());
        	 if(stack.pop() != OPERAND_CODE) {
        		 return false;
        	 }
        	 if(stack.pop() != OPERATOR_CODE) {
        		 return false;
        	 }
        	 if(stack.pop() != OPERAND_CODE){
        		 return false;
        	 }
        	 
        	 if(stack.pop() != LEFT_PAREN_CODE) {
        		 return false;
        		 
        	 }
        	 stack.push(OPERAND_CODE);
         } else {
        	 System.out.print("oopsies");
         }
         
         

      }
      System.out.println(stack.toString());
      return (stack.sizeOf() == 1 && stack.topOf() == OPERAND_CODE);// <-- Obviously needs modification
   }


   /* Evaluates the given FPAE and returns its value.
   ** pre: isWellFormed(fpae)
   */
   public static int valueOf(String fpae)
   {
      final int N = fpae.length();
      StackViaArray<Integer> operandStack = new StackViaArray((N+1) / 2);
      StackViaArray<String> operatorStack = new StackViaArray(N / 3);

      Scanner scanner = new Scanner(fpae);
      
      int equation = 0;
      
      while (scanner.hasNext()) {
         String token = scanner.next();
         
         if(isLeftParen(token)) {
        	 //add to parentheses stack
         } else if(isIntegerLiteral(token)) {
        	 //if int
        	 operandStack.push(Integer.parseInt(token));
         } else  if(isArithOperator(token)) {
        	 //if its an operator
        	 operatorStack.push(token);
         } else if(token.equals(RIGHT_PAREN)){
        	 //right parentheses
          int rightNumber = operandStack.topOf();
          	operandStack.pop();
          	
          String operator = operatorStack.topOf();
          	operatorStack.pop();
          	
          int leftNumber = operandStack.topOf();
          	operandStack.pop();
          	
          	operandStack.push(applyOperator(leftNumber, operator, rightNumber));
          
         } else {
        	 System.out.print("yeah theres an issue here...");
         }
         
      }
      
      return operandStack.topOf(); 
   }


   // private methods
   // ---------------

   /* Returns the result of applying the given operator to the given integers.
   ** pre: isArithOperator(operator)
   */
   private static int applyOperator(int left, String operator, int right)
   {
      if (operator.equals(PLUS)) { return left + right; }
      else if (operator.equals(MINUS)) { return left - right; }
      else if (operator.equals(TIMES)) { return left * right; }
      else if (operator.equals(DIVIDE)) { return left / right; }
      else { return 0; }   // this should be impossible!!
   }

   /* Reports whether or not the given String describes an integer literal,
   ** which would mean that it is a sequence of one or more digit characters 
   ** (i.e., characters in the range '0'..'9').
   */
   private static boolean isIntegerLiteral(String s) {
      boolean result;
      final int N = s.length();
      if (N == 0) { result = false; }
      else {
         int i = 0;
         // loop invariant: Every character in s[0..i) is a digit
         while (i != N  &&  Character.isDigit(s.charAt(i))) { 
            i = i+1;
         }
         // assertion: i==N implies that every character in s[0..N) is a digit,
         //            while i!=N implies that s[i] is not a digit
         result = i == N; 
      }
      return result;
   }

   /* Reports whether or not the given String describes an arithmetic operator,
   ** which would mean that it has length one and its lone character is one of
   ** the arithmetic operators.
   */
   private static boolean isArithOperator(String s) {
      return s.length() == 1  &&  ARITH_OPS.indexOf(s) != -1;
   }

   /* Reports whether or not the given String describes a left parenthesis,
   ** which would mean that it is equal to LEFT_PAREN declared above.
   */
   private static boolean isLeftParen(String s) {
      return s.equals(LEFT_PAREN);
   }

   /* Reports whether or not the given String describes a right parenthesis,
   ** which would mean that it is equal to RIGHT_PAREN declared above.
   */
   private static boolean isRightParen(String s) {
      return s.equals(RIGHT_PAREN);
   }

}
