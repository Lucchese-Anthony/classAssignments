import java.util.Scanner;

/* Java application having as its purpose to test the features of the
** AryListViaLink1 class.
**
** Author: R. McCloskey
** Date: March 5, 2019
*/

public class AryListTester {

   private static Scanner keyboard = new Scanner(System.in);
   private static boolean keepGoing = true;;
   private static AryListViaLink1<String> aList = new AryListViaLink1();

   public static void main(String[] args)
   {
      while (keepGoing) {
         String command;
         // Prompt user until a non-empty string is entered
         do {
            System.out.print("\n>");
            command = keyboard.nextLine().trim();
         }
         while (command.length() == 0);

         try {
            performCommand(command);
         }
         catch (Exception e) {
            e.printStackTrace(System.out);
            print("\n Something went wrong; try again\n");
         }
      }
      System.out.println("Goodbye.");
   }

   /* Performs the specified command upon aList.
   */
   private static void performCommand(String command) {
         
      Scanner comScan = new Scanner(command);
      String commandCode = comScan.next();
      if (commandCode.length() != 1) {
         print("Command code must be a single letter; try again.\n");
      }
      else {
         char cc = commandCode.charAt(0);
         if (cc == 'h') {    // help
            printHelp();
         }
         else if (cc == 'q') {  // quit
            keepGoing = false;
         }
         else if (cc == 'c') {  // create new list
            if (comScan.hasNext()) {
               String[] elems = comScan.nextLine().trim().split(" ");
               aList = new AryListViaLink1(elems);
            }
            else {   // create empty list
               aList = new AryListViaLink1();
            }
            print("New list created...\n");
            displayList();
         }
         else if (cc == 'L') {   // display Length
            System.out.printf("%d\n", aList.lengthOf());
         }
         else if (cc == 'g') {   // get
            int k = comScan.nextInt();
            print(aList.get(k) + "\n");
         }
         else if (cc == 'd') {   // delete
            int k = comScan.nextInt();
      
            String deletedStr = aList.delete(k);
            print("Deleted item is " + deletedStr + "\n");
            displayList();
         }
         else if (cc == 'r') {   // replace
            int k = comScan.nextInt();
            String str = comScan.nextLine().trim();
            aList.replace(k, str);
            displayList();
         }
         else if (cc == 'i') {   // insert
            int k = comScan.nextInt();
            String newElem = comScan.next();
            aList.insert(k, newElem);
            displayList();
         }
         else if (cc == 'a') {   // append
            String newElem = comScan.next();
            aList.append(newElem);
            displayList();
         }
         else if (cc == 't') {   // tsil (reverse)
            aList.tsil();
            displayList();
         }
         else if (cc == 'p') {  // print/display
            if (!comScan.hasNext()) {  // display whole list
               aList.display();
            }
            else {
               int start = comScan.nextInt();
               int stop = comScan.nextInt();
               aList.display(start, stop);
            }
            print("\n");
         }
         else {
            print("Unrecognized command; try again.");
         }
      }
   }

   /* Displays aList.
   */
   private static void displayList() {
      //print("List is now: ");
      aList.display();
      print("\n");
   }

   private static void printHelp() {
      print("Examples of commands:\n");
      print("---------------------\n");
      print("q : to quit\n");
      print("h : for help!\n");
      print("L : to display length of list\n");
      print("t : to apply tsil() (to reverse the list)\n");
      print("g 5 : to get the item at position 5\n");
      print("d 3 : to delete the item at position 3\n");
      print("r 2 cow : to replace the item at position 2 with \"cow\"\n");
      print("i 6 cow : to insert \"cow\" at position 6\n");
      print("a moose : to append \"moose\" to the end of the list\n");
      print("p : to print/display all list items\n");
      print("p 2 7: to print/display list items in positions 2 through 6\n");
      print("c dog cat pig : populates new list with three animals\n");
      print("c :  makes new empty list\n");
   }


   /* Surrogate for System.out.print()
   */
   private static void print(String s) 
      { System.out.print(s); }
}
