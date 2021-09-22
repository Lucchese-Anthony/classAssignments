/*    Student Name: Anthony Lucchese
*/
public class Oops3 {
    public static void main(String[] args) {
        double y = 8.0;
        double x = 10.01;
        int z;
        z = printer(x, y);
        System.out.println("z = " + z);
    }
    
    public static int printer(double x, double y) {
        int z = 5;
        double bubble = 867.5309;
        System.out.println("x = " + x + " and y = " + y);
        System.out.println("x = " + x + " and y = " + bubble);
        System.out.println("The value from main is: " + bubble);
        return z;
    }
}