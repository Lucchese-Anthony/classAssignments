//names: Anthony Lucchese Steven Prosperino

public class StoppingCounter extends BoundedCounter{
   
   public StoppingCounter(int init, int min, int max) { 
      super(init, min, max); 
   }
  
   @Override
   protected void decrementFromMin(){
     
   }
   @Override
   protected void incrementFromMax(){
   }
}