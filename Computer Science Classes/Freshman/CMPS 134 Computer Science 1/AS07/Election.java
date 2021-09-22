/* Java class instances of which represent an object meant to maintain the
** state and behavior of an election.  
**
** CMPS 134 Fall 2019 
** Authors: Anthony Lucchese
**
** Collaboration: Micheal Edwards
**
** Known defects: ...
*/
public class Election {

   // class constants
   // ---------------
   
   public static final int CANDIDATE_LIMIT = 16;   //Default upper limit

   // instance variables
   // ------------------
   private int limit;            //Limit on number of candidates for this object
   private String[] candidate;   //Array of candidate names
   private int[] voteCount;      //Array of candidate vote counts
   private int nextIndex;        //Index of next available element in the arrays

   
   //Used to control when votes can be cast 
   private boolean open = false;

   // constructors
   // ------------

   public Election() {
      initialize(CANDIDATE_LIMIT);
   }
   
   public Election(int candidateLimit) {
      initialize(candidateLimit);
   }

   // Does the actual work of constructing and initializing the data of the object
   private void initialize(int candidateLimit) {
      if(candidateLimit >= 0) {
         nextIndex = 0;
         candidate = new String[candidateLimit];
         voteCount = new int[candidateLimit];
      } else {
         throw new IllegalArgumentException("invalid candidate limit");            
      }
   }
   
   // mutators
   // --------

   /* Mutator that adds the given candidate to the ballot maintained by 
      the object.
   */
   public void addCandidate(String name) {
      int index = indexOf(name,candidate);
      if(index < 0) {
         candidate[nextIndex] = name;
         nextIndex++;
      } else {
         throw new IllegalArgumentException("candidate already added");            
      }
   }

   /* Mutator that changes the state of the object so as to allow the
      subsequent casting of votes.
   */
   public void openVoting() {
      if(!open) {
         open = !open;
      } else {
         throw new IllegalStateException("voting already open");            
      }
   }
   
   /* Mutator that changes the state of the object so as to prevent the
      subsequent casting of votes.
   */
   public void closeVoting() {
      if(open) {
         open = !open;
      } else {
         throw new IllegalStateException("voting not now open");            
      }
   }

   /* Essential mutator that records a vote for candidate with the given
      name.  Note that if no candidate with that name is currently on the
      ballot then the name is added, that is, as long as a spot remains.
   */
   public void castVote(String name) {
      if(open) {
         int placeHolder = indexOf(name, candidate);
         if(placeHolder != -1){
            voteCount[placeHolder]++;
         } else {
            addCandidate(name);
            castVote(name); 
         }
      } else {
         throw new IllegalStateException("voting not allowed now");            
      }
   }
   
   // Searches the given array returning the index of given target string
   // value or -1 if not found.
   private int indexOf(String target, String[] array) {
      int result = nextIndex - 1;
      while((result >= 0) && !array[result].equals(target)) {
         result = result - 1;
      }
      return result;
   }

   // observers
   // ---------

   /* Returns the count of the number of candidates on the ballot.
   */
   public int getCandidateCount() {
      return nextIndex;
   }
   
   /* Returns the name of the candidate at the given position on the ballot.
   */
   public String getCandidateName(int index) {
      return candidate[index];
   }
   
   /* Returns the count of the number of votes cast for the candidate at the given
      position on the ballot.
   */
   public int getCandidateVoteCount(int index) {
      return voteCount[index];
   }
   
   /* Returns true indicating that the election is open and votes may be cast.
   */
   public boolean isOpen() {
      return open;
   }
   
   private static final String COMMA = ",";
   private static final String BLANK = " ";
   private static final String NL = "\n";
   public String toString() {
      String result = "";
      for(int index=0; index<nextIndex; index++) {
         result = result + candidate[index] + COMMA + voteCount[index] + BLANK;
      }
      return result.trim();
   }

}
