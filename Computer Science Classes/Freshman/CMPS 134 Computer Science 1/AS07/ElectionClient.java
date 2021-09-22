/* ElectionClient.java
**
** Java application that, accepts the name of an "election file" as its first
** run argument and reads it to simulate the running of an election.  An integer,
** indicating the limit on the number of candidates maintained in the election,
** may be provided as the second run argument.
** 
** The first line in an election file contains the title of the election, and
** the second line contains the names of the candidates as a CSV string.  Each
** subsequent line contains a vote cast in the election; as the name of the person
** for whom the vote was cast.
**
** A blank line in the file indicates that the election has closed, and thus any
** subsequent votes are considered to have been cast after the election has been
** closed.
**
** CMPS 134 Fall 2019 
** Authors: P.M.J & R.W.M. & ...
**
** Collaboration:
**
** Known defects: ...
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ElectionClient {

   private static Scanner keyboard;  // to read input entered by user
   private static Scanner input;     // to read data from input file

   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("Election Client ...");
      String fileName = getFirstArg(args);
      // Establish a Scanner to read from the file with the specified name.
      input = new Scanner(new File(fileName));  
      // Read first line to get election title
      String identification = input.nextLine().trim();
      // Read second line to get election candidate list
      String candidateList = input.nextLine().trim();
      // Declare object
      Election election;
      // Construct object based on optional run argument
      if(args.length>1) {
         election = new Election(Integer.parseInt(args[1]));
      } else {
         election = new Election();
      }
      // Add candidates to the election
      addCandidates(election,candidateList);
      printElectionStatus(identification,election);
      // Open voting and read votes
      election.openVoting();
      System.out.println("Voting Opened ..................");
      // Now process voting
      printElectionStatus(identification,election);
      String vote = "";
      if(input.hasNextLine()) {
         do {
            try {
               vote = input.nextLine().trim();
               if(vote.length() > 0) {
                  election.castVote(vote);
                  printElectionStatus(identification,election);
               }
            } catch (Exception e) {
               System.out.println(e+"\nContinuing ...\n");
            }
         } while((vote.length() > 0) && input.hasNextLine());
      }
      // Close voting
      election.closeVoting();
      System.out.println("Voting Closed ..................");
      printElectionStatus(identification,election);
      System.out.println();
      // Read any remaining votes and try to cast them
      while(input.hasNextLine()) {
         try {
            vote = input.nextLine().trim();
            election.castVote(vote);
            printElectionStatus(identification,election);
         }
         catch (Exception e) {
            System.out.println(e+"\nContinuing ...\n");
         }
      }
      // Print final results
      System.out.println("Final Results:");
      printElectionStatus(identification,election);
      System.out.println("\nDone!");
   }

   private static final String COLON = ":";
   private static final String BLANK = " ";
   private static void printElectionStatus(String title, Election election) {
      System.out.println(title+COLON+BLANK+election.toString());
   }

   private static String getFirstArg(String args[]) {
      String result = "";
      if(args.length > 0) {
         result = args[0];
      } else {
         result = getStringFromUser("Enter name of input file: ",
                                    new Scanner(System.in));
      }
      return result;
   }

   /* Prints the given prompt and reads/returns a line of data read
   ** using the given Scanner.
   */
   private static String getStringFromUser(String prompt, Scanner keyboard) {
      System.out.print(prompt);
      return keyboard.nextLine();
   }

   private static void addCandidates(Election election, String list) {
      Scanner scanner = new Scanner(list);
      scanner.useDelimiter(",");
      while(scanner.hasNext()) {
         String candidate = scanner.next();
         try {
            election.addCandidate(candidate);
         } catch (Exception e) {
            System.out.println(e+"\nContinuing ...\n");
         }
      }
   }
}
