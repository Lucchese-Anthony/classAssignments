/* Clock.java
** An instance of this class represents a clock that "keeps" the time of day 
** to the precision of one second.  
**
** Author: R. McCloskey and < students' names >
** Date: February 2020
** Known flaws: ...
*/

public class Clock {

   // instance variables
   // ------------------

   private RollOverCounter hour;    // # hours since midnight
   private RollOverCounter minute;  // # minutes since beginning of hour
   private RollOverCounter second;  // # seconds since beginning of minute


   private boolean isTheModeTwentyFourHoursMaybe = true;
   
   
   // constructors
   // ------------

   /* Initializes this clock to the time of day described by the parameters.
   */
   public Clock(int hr, int min, int sec) {
       hour = new RollOverCounter(0, 23);
       minute = new RollOverCounter(0, 59);
       second = new RollOverCounter(0, 59);
	   setTo(hr, min, sec);
   }

   /* Initializes this clock to midnight.
   */
   public Clock() { this(0,0,0); }


   // observers
   // ---------

   /* Returns the hour attribute of the time of day indicated by this clock. 
   */
   public int getHour() { 
	   return hour.countVal(); 
   }

   /* Returns the minute attribute of the time of day indicated by this clock. 
   */
   public int getMinute() {
	   return minute.countVal();
   }

   /* Returns the second attribute of the time of day indicated by this clock. 
   */
   public int getSecond() {
	   return second.countVal();
   }

   /* Returns a String describing the time of day indicated by this clock, 
   ** in 24-hour notation.  (E.g., 14:45:05)
   */
   public String toString() { 
	   if(isTheModeTwentyFourHoursMaybe) {
		   return toString24();
	   } else return toStringAmPm();
   }

   /* Returns a String describing the time of day indicated by this clock, 
   ** in 24-hour notation.  (E.g., 14:45:05)
   */
   public String toString24() {
      return withLeadingZeros(getHour(), 2) + ":" + withLeadingZeros(getMinute(), 2) + ":" + withLeadingZeros(getSecond(), 2);
   }

   /* Returns a String describing the time of day indicated by this clock, 
   ** in AM/PM notation.  (E.g., 2:45:05PM, 11:07:55AM)
   */
   public String toStringAmPm() {
      if(getHour() > 12){
    	  return withLeadingZeros(getHour() % 12, 2) + ":" + withLeadingZeros(getMinute(), 2) + ":" + withLeadingZeros(getSecond(), 2) + "PM";
      } else return toString24() + "AM";
   }

   // mutators
   // --------

   /* Advances this clock by one second.
   */
   public void tick() {
      second.increment();
      if(getSecond() == 0) {
    	  minute.increment();
    	  if(getMinute() == 0) {
    		  hour.increment();
    		  
    	  }
      } 
   }

   /* Sets this clock's hour, minute, and second attributes to 
   ** those indicated by the parameters.
   */
   public void setTo(int hr, int min, int sec) {
      hour.setTo(hr);
      minute.setTo(min);
      second.setTo(sec);
   }

   /* Sets this clock's hour attribute to that indicated by the 
   ** parameter (without changing its minute or second attributes).
   */
   public void setHourTo(int hr) { hour.setTo(hr); }   

   /* Sets this clock's minute attribute to that indicated by the 
   ** parameter (without changing its hour or second attributes).
   */
   public void setMinuteTo(int min) {
	   minute.setTo(min);
   }

   /* Sets this clock's second attribute to that indicated by the 
   ** parameter (without changing its hour or minute attributes).
   */
   public void setSecondTo(int sec) {
	   second.setTo(sec);
   }

   /* Sets the clock's display to 24-hour mode, meaning that subsequent
   ** calls to toString() will return the same string as toString24().
   */
   public void setTo24Mode() {
	   isTheModeTwentyFourHoursMaybe = true;
	   toString24();
   }

   /* Sets the clock's display to 24-hour mode, meaning that subsequent
   ** calls to toString() will return the same string as toStringAmPm().
   */
   public void setToAmPmMode() {
	   isTheModeTwentyFourHoursMaybe = false;
	   toStringAmPm();
   }


   // private methods
   // ---------------

   /* Returns a string corresponding to the given integer, with as many
   ** leading 0's as necessary to make the string the specified length.
   ** E.g., If num is 17 and length is 5, the result is "00017".
   */
   private String withLeadingZeros(int num, int length) {
      return padLeft(""+num, '0', length);
   }

   /* Returns the string produced by placing as many copies of the specified 
   ** character ('padChar') to the left of the specified string ('str') so 
   ** that the resulting string has the specified length.
   */
   private String padLeft(String str, char padChar, int length) {
      while (str.length() < length) {
         str = padChar + str;
      } 
      return str;
   }

}
