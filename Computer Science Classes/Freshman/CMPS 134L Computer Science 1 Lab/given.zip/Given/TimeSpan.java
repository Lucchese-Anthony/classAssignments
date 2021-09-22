/* TimeSpan.java
**
** Author: P.M.J., but inspired by and very closely related to a class of the same name
**         by Stuart Reges & Marty Stepp and appearing in Building Java Programs, 4th Edition.
** Course:   CMPS 134
** Semester: Fall 2018
**
** Last Modified: October 15, 2018
** Collaboration: R.W.M.

** An instance of this class represents a time span measured to the 
** granularity of one minute.  This is the "alternate implementation" using only total minutes.
*/

public class TimeSpan {

   // instance variables
   // ------------------
   private int totalMinutes;   // instance variable
   private int hours;
   private int minutes;
   // constructors
   // ------------

   // Constructs a time span as described by the given parameters.
   // pre: (hours >= 0) && (minutes >= 0)
   public TimeSpan(String time){
      String h = time.substring(0,1);
      String m = time.substring(2,4);
      hours = Integer.parseInt(h);
      minutes = Integer.parseInt(m);
      add(hours, minutes);
   }
   public TimeSpan(int hours, int minutes) {
      totalMinutes = 0;
      add(hours, minutes);
   }

   // mutators
   // --------

   // Increases this time span by the time span described by the
   // given parameters. 
   // pre: (hours >= 0) && (minutes >= 0)
   public void add(int hours, int minutes) {
      totalMinutes = totalMinutes + ((60 * hours) + minutes);
   }

   // observers
   // ---------
   public int getMinutes(){
      int minutes = totalMinutes % 60; 
      return minutes;
   }
   public int getHours(){
      int hours = totalMinutes / 60; 
      return hours;
   }
   
   
   // Returns whether or not o is a TimeSpan object representing the 
   // same time span value as this TimeSpan object.
   public boolean equals(Object o) {
      boolean result = false;
      if (o instanceof TimeSpan) {   //Is a TimeSpan object
         TimeSpan other = (TimeSpan) o;
         result = (totalMinutes == other.totalMinutes);
      }
      return result;
   }

   // Returns a description of this time span value as measured in minutes.
   public int getTime() {
      return totalMinutes;
   }

   // Returns a description of this time span values as a string in terms of 
   // hours and minutes.  E.g., "6h15m", "0h14m", "37h2m"
   public String toString() {
      String minutes = Integer.toString(totalMinutes % 60);
   
      if(minutes.length() == 1){
         minutes = "0" + minutes; 
      }
      return (totalMinutes / 60) + ":" + minutes + "";
   }

}
