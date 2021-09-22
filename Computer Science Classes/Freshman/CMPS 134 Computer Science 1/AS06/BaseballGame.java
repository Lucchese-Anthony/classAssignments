//********************************************************************
//  BaseballGame.java       Authors: P.M.J. and R.W.M.
//
//  Represents the essential states and result of a baseball game,
//  with the primary operations being the recording of outs and runs.
//
//  Author(s): Anthony Lucchese
//  
//********************************************************************

public class BaseballGame {
   public static final char VISITOR = 'V';      //Indicator for visiting team
   public static final char HOME = 'H';         //Indicator for home team 

   private static final int INNINGS_REQUIRED_DEFAULT = 9;  //Default number of innings in a game
   private static final int OUTS_PER_HALF_INNING = 3;
   private static final int OUTS_PER_FULL_INNING = OUTS_PER_HALF_INNING * 2;
   
   private static int HIouts;
   private static int homeScore;
   private static int awayScore;
   private static boolean isHomeBatting = false;
   private static int inning = 1;
   private static int inningLimit;
   private static int homeOuts;
   private static int awayOuts;
   
 
//-----------------------------------------------------------------
//  Constructor: Uses the default number of innings for the game
//-----------------------------------------------------------------
   public BaseballGame() {
      //BaseballGame(INNINGS_REQUIRED_DEFAULT);
   }

//-----------------------------------------------------------------
//  Constructor: Uses the given number of innings for the game
//    Pre-Condition: innings > 0
//-----------------------------------------------------------------
   public BaseballGame(int innings) {
      inningLimit = innings;  
   }

//-----------------------------------------------------------------
//  Mutator: Records an out for the team currently "at bat".
//    Pre-Condition: !this.isOver
//-----------------------------------------------------------------
   public void recordOut() {
       if(HIouts > OUTS_PER_HALF_INNING - 2){
         HIouts = 0;
         isHomeBatting = !isHomeBatting;
          if(!isHomeBatting){
             inning++;
          }
       } else HIouts++;
       if(homeOuts > 2 && awayOuts > 2) {
		   homeOuts = 0;
		   awayOuts = 0;
	   }
       if(isHomeBatting) {
          homeOuts++;
       } else awayOuts++;
       
       
   }

//-----------------------------------------------------------------
//  Mutator: Records a run scored for the team currently "at bat".
//    Pre-Condition: !this.isOver
//-----------------------------------------------------------------
   public void recordRun() {
      if(isHomeBatting){
         homeScore++;
      } else awayScore++;
   }

//-----------------------------------------------------------------
//  Accessor: Returns the minimum number of innings required for
//  this game.
//-----------------------------------------------------------------
   public int inningsRequired() {
      return inningLimit;
   }
   
//-----------------------------------------------------------------
//  Accessor: Returns the number of completed innings for the given 
//  team, where team either equals VISITOR or HOME.
//    Pre-Condition: (team ==  VISITOR) || (team == HOME)
//-----------------------------------------------------------------
   public int inningsCompleted(char team) {
      if(team == HOME){
        return inning - 1;
      } else {
    	  if(!isHomeBatting) {
    		  return inning - 1;
    		 
    		  } else return inning;
      }
   }

//-----------------------------------------------------------------
//  Accessor: Returns the number of the current inning for this game.
//-----------------------------------------------------------------
   public int currentInning() {
      return inning;
   }

//-----------------------------------------------------------------
//  Accessor: Returns either VISITOR or HOME indicating which half of
//  the current inning is in progress;  that is, which team is currently
//  batting.
//-----------------------------------------------------------------
   public char currentHalfInning() {
      if(isHomeBatting){
      return HOME;
      } else return VISITOR;
      
   }

//-----------------------------------------------------------------
//  Accessor: Returns the number of outs recorded for the current
//  half inning.
//-----------------------------------------------------------------
   public int currentHalfInningOuts() {
      return HIouts;
   }

//-----------------------------------------------------------------
//  Accessor: Returns the number of runs recorded for the given team,
//  where team either equals VISITOR or HOME.
//    Pre-Condition: (team ==  VISITOR) || (team == HOME)
//-----------------------------------------------------------------
   public int runsScored(char team) {
      if(team == HOME){
         return homeScore;
      }else return awayScore;
   }

//-----------------------------------------------------------------
//  Accessor: Returns true if and only if the game is completed.
//-----------------------------------------------------------------
//   public boolean isOver() {
//      if(homeScore == awayScore && inning >= inningLimit && isHomeBatting){
//         return false;
//      } else if(homeScore <= awayScore && inning >= inningLimit){
//         if(awayScore > homeScore && isHomeBatting){
//            return false;
//         } else return true;
//      } else if(homeScore > awayScore && inning >= inningLimit && isHomeBatting) {
//         return true;
//      } else return false;
//   }
   
   public boolean isOver() {
	   if(homeScore > awayScore && inning >= inningLimit && isHomeBatting) {
		   return true;   
	   } else if(homeScore < awayScore && inning > inningLimit && homeOuts == 3 && awayOuts == 3) {
		   return true;
	   } else if(homeScore == awayScore) {
		   return false;
	   }return false;
   }

//-----------------------------------------------------------------
//  Accessor: Returns either VISITOR or HOME indicating which of the
//  two teams has won the game.
//    Pre-Condition: this.isOver
//-----------------------------------------------------------------
   public char winningTeam() {
      if(homeScore > awayScore){
         return HOME;
      } else return VISITOR;
   }

//-----------------------------------------------------------------
//  Returns a string representation of this object.
//-----------------------------------------------------------------
   public String toString() {
      String result = "["+runsScored(VISITOR)+"-"+runsScored(HOME)+"]["+
                       currentHalfInning()+currentInning()+","+
                       currentHalfInningOuts()+":"+
                       inningsRequired()+"]";
      if(isOver()) {
         result = result + " Game Over!";
      }
      return result;
   }
   
///////////////////////////////////////////////////////////////////
// P r i v a t e   
///////////////////////////////////////////////////////////////////

}