// Author: Anthony Lucchese, help from Jacob Fink and Matthew Babinski
// AS08

public class DieBlackJackCompetition {
   private int goal;
   private int[] playerScore;
   private DieBlackJack[] playerNumber;
   private boolean turnTaken;
   
   
   public DieBlackJackCompetition(int players, int goal){
      playerNumber = new DieBlackJack[players];
      playerScore = new int[players];
      init();
      this.goal = goal;
   }
   private void init(){
      for(int i = 0; i < playerNumber.length; i++){
         playerNumber[i] = new DieBlackJack();
         playerScore[i] = 0;
      }
   } 
   
   public int getNumberOfPlayers(){
      return playerNumber.length;
   }
   
   public String toString(){
      String print = "(";
      for(int i = 0; i < playerNumber.length; i++){
        print = print + playerScore[i];
        if(i <= playerNumber.length - 1){
           print = print + ", ";
        } else print = print + ") of " + goal;
      }
      return print;
   }
   
   public String getStatus(int player){
      String result = "";
      if(playerScore[player] == goal && playerScore[player] >= (goal-3)){
         result = "W";
      } else if(playerScore[player] <= (goal - 4)){
         result = "A";
      } else if(playerScore[player] > goal){
         result = "L";
      } return result;
   }
   
   

    public String playRound(){
      turnTaken = false;
      String result = "";
      for(int i = 0; i < playerNumber.length; i++){
         if(playerNumber[i].shouldTakeTurn()){
            result = result + toString() + "#" + i + "rolls " + playerNumber[i].takeTurn() + "\n";
            turnTaken = true;
         }       
         }     
         return result;
         
     }    
     
   
   
   
   public boolean over(){
      boolean result = false;
      String statusString = "";
      for(int i = 0; i < playerNumber.length; i++){
         statusString = statusString + getStatus(playerScore[i]);
      }
      if(statusString.length() == playerNumber.length && statusString.contains("A")){
         statusString = "";
      } else {result = !result;} 
      
      return result;
   }
}