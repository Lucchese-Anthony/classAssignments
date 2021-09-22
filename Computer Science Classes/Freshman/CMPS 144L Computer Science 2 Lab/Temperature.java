/* Temperature.java
** An instance of this class represents a temperature whose value can be
** expressed on the Celsius scale.
*/

public class Temperature {

   // instance variable
   // -----------------
   private double degCelsius;     // Number of degrees on the Celsius scale


   // constructor
   // -----------

   /* Initializes this Temperature to be the specified # of degrees Celsius.
   */
   public Temperature(double degrees) { setTo(degrees); }


   /* Initializes this Temperature to be zero degrees Celsius.
   */
   public Temperature() { this(0.0); }


   // observer
   // --------

   /* Returns this Temperature's value as expressed on the Celsius scale.
   */
   public double degrees() { return degCelsius; }


   // mutators
   // --------

   /* Sets this Temperature to the specified number of degrees (Celsius).
   */
   public void setTo(double newDegrees) { degCelsius = newDegrees; }

   /* Changes this Temperature by the specified number of degrees (Celsius).
   */
   public void changeBy(double deltaDegrees) { 
      setTo(degCelsius + deltaDegrees);
   }

}