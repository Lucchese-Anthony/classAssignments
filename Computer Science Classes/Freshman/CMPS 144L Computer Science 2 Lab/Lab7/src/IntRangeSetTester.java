import java.util.Scanner; 

/* IntRangeSetTester.java
** Java application having as its purpose to test the methods in the
** IntRangeSet class.
** Author: R. McCloskey
** Date: Dec. 2018, updated March 2020.
*/
public class IntRangeSetTester {

   private static Scanner input = new Scanner(System.in);

   private static int[] a0 = new int[] { 0, 3, 7, 10, 15, 23 };
   private static IntRangeSet s0 = new IntRangeSet(30, a0);

   private static int[] a1 = new int[] { 0, 1, 3, 6, 9, 10, 12, 21 };
   private static IntRangeSet s1 = new IntRangeSet(25, a1);

   private static int[] a2 = new int[] { 3, 6, 10, 12 };
   private static IntRangeSet s2 = new IntRangeSet(20, a2);

   private static int[] a3 = new int[] { 1, 5, 17, 20 };
   private static IntRangeSet s3 = new IntRangeSet(30, a3);

   private static IntRangeSet[] sets = new IntRangeSet[] { s0, s1, s2, s3 };

   public static void main(String[] args) {
      testCardinality();   advance();
      testMinMember();     advance();
      testMaxMember();     advance();
      testIsSubsetOf();    advance();
      testDisjointFrom();  advance();
      testComplement();    advance();
      testUnion();         advance();
      testIntersection();  advance();
      testAbsorb();
      System.out.println("\nGoodbye.");
   }

   private static void advance() {
      System.out.print("\nPress Enter to continue...");
      input.nextLine();
      System.out.println();
   }

   public static void testCardinality() { 
      for (int i = 0; i != sets.length; i++) {
         System.out.println("Cardinality of " + sets[i].toString() + " is " +
                            sets[i].cardinalityOf());
      }
   }

   public static void testMinMember() { 
      for (int i = 0; i != sets.length; i++) {
         System.out.println("Minimum member of " + sets[i].toString() + " is " +
                            sets[i].minMember());
      }
   }

   public static void testMaxMember() { 
      for (int i = 0; i != sets.length; i++) {
         System.out.println("Maximum member of " + sets[i].toString() + " is " +
                            sets[i].maxMember());
      }
   }

   public static void testIsSubsetOf() {
      for (int i = 0; i != sets.length; i++) {
         for (int j = 0; j != sets.length; j++) {
            boolean result = sets[j].isSubsetOf(sets[i]);
            System.out.print("Is " + sets[j].toString() + " a subset of " +
                             sets[i].toString() + "?  ");
            System.out.println(result ? "YES" : "NO");
         }
      }
   }

   public static void testDisjointFrom() {
      for (int i = 0; i != sets.length; i++) {
         for (int j = 0; j != sets.length; j++) {
            boolean result = sets[j].isDisjointFrom(sets[i]);
            System.out.print("Is " + sets[j].toString() + " disjoint from " +
                             sets[i].toString() + "?  ");
            System.out.println(result ? "YES" : "NO");
         }
      }
   }

   public static void testComplement() {
      for (int i = 0; i != sets.length; i++) {
         IntRangeSet comp = sets[i].complement();
         System.out.println("The complement of " + sets[i] + " is " + comp);
      }
   }

   public static void testUnion() {
      for (int i = 0; i != sets.length; i++) {
         for (int j = 0; j != sets.length; j++) {
            IntRangeSet unionSet = sets[i].union(sets[j]);
            System.out.println("Union of " + sets[i] + " and " + sets[j] +
                               " is " + unionSet);
         }
      }
   }

   public static void testIntersection() {
      for (int i = 0; i != sets.length; i++) {
         for (int j = 0; j != sets.length; j++) {
            IntRangeSet intersectSet = sets[i].intersection(sets[j]);
            System.out.println("Intersection of " + sets[i] + " and " + 
                               sets[j] + " is " + intersectSet);
         }
      }
   }

   public static void testAbsorb() {
      for (int i = 0; i < sets.length-1; i++) {
         for (int j = i+1; j < sets.length; j++) {
            IntRangeSet setIClone = sets[i].clone();
            System.out.println("After absorbing " + sets[j] + 
                               " into " + setIClone);
            setIClone.absorb(sets[j]);
            System.out.println("  the latter becomes " + setIClone);
         }
      }
   }

}
