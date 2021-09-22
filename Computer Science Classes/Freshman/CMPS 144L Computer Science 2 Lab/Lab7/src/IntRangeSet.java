/* IntRangeSet.java
** Author: R. McCloskey  and Anthony Lucchese, Steven Prosperino and Jacob Fink
** Date: Dec. 2018, April 2020
** Known Defects: ...
** 
** An instance of this class represents a subset of the natural numbers in
** the range [0..N), where N (referred to as the upper bound of the set's 
** "universe") is specified at the time of construction.
*/

public class IntRangeSet {

   // instance variables
   // ------------------
   private int N;             // upper bound of this set's universe
   private boolean[] member;  // member[i] is true iff i is a member of this set

   // class invariant: N = member.length 


   // constructor
   // -----------

   /* Initializes this set so that it is either empty or full, according
   ** to the value of the second parameter, and so that it is capable of 
   ** having as members values from zero up to, but not including, the 
   ** specified upper bound.
   */
   public IntRangeSet(int upperBound, boolean makeFull) {
      member = new boolean[upperBound];
      N = upperBound;
      if (makeFull) {
         for (int i=0; i != N; i++) { insert(i); }
      }
      else {
         // Do nothing, as false is default value for boolean array elements.
      }
   }

   /* Initializes this set so that it is empty and so that it is capable of 
   ** having as members values from zero up to, but not including, the 
   ** specified upper bound.
   */
   public IntRangeSet(int upperBound) { this(upperBound, false); }

   /* Initializes this set so that its members are the elements in the
   ** given array and its upper bound is the one specified.
   ** An IllegalArgumentException is thrown if any of the array elements
   ** is outside the range [0..upperBound).
   */
   public IntRangeSet(int upperBound, int[] elems) {
      this(upperBound, false);
      for (int i=0; i != elems.length; i++) {
         int elem = elems[i];
         if (elem < 0  ||  elem >= upperBound) {
            throw new IllegalArgumentException(elem + " is outside [0.." +
                                               upperBound + ")"); 
         }
         insert(elems[i]);
      }
   }


   // observers
   // ---------

   /* Returns the upper bound of this set's universe.
   */
   public int upperBoundOf() { return N; }


   /* Returns true iff the given value is a member of this set.
   */
   public boolean isMember(int k) { 
      return 0 <= k  &&  k < upperBoundOf()  &&  member[k];
   }

   /* Returns the number of members in this set.
   */
   public int cardinalityOf() {
	   int cardinality = 0;
	   for(int i = 0; i != N; i++) {
		   if(member[i]) {
			   cardinality++;
		   }
		   
	   }return cardinality;
   }

   /* Returns the minimum member of this set, or upperBound() if this set 
   ** is empty.
   */
   public int minMember() {
      boolean min = false;
      int position = 0;
	   while(!min){
		   if(member[position] != min) {
			   min = !min;
		   } else position++;
	   } return position;
	   
	   
   }

   /* Returns the maximum member of this set, or -1 if this set is empty.
   */
   public int maxMember() {
	   boolean max = false;
	   int position = N - 1;
	   while(!max){
		   if(member[position] != max) {
			   max = !max;
		   } else position--;
	   } 
	   return position;
	
   }

   /* Returns true iff this set is a subset of the given one.
   */
   public boolean isSubsetOf(IntRangeSet s) {
	   boolean isSubset = false;
	   int position = 0;
	   for(int i= 0; i!= N - 1; i++) {
		   if(member[position] == s.isMember(i)) {
			   isSubset = !isSubset;
		   }
		   position++;
	   }
	   
	   return isSubset;
   }
   

   /* Returns true iff this set and the given one have no members in common.
   */
   public boolean isDisjointFrom(IntRangeSet s) {
	   boolean isSubset = true;
	   int position = 0;
       while(isSubset  && position != (N-1)) {
		   for(int i = 0; i != N - 1; i++) {
			   if(member[i] == s.isMember(position)) {
				   isSubset = !isSubset;
			   }  
		   } position++;
	   } return isSubset;
	   
   }

   /* Returns true iff the given object is an instance of this class
   ** and it has exactly the same members as this set.  (The two universes
   ** need not correspond.)
   */
   public boolean equals(Object obj) {
      boolean noDiffYet = true;
      if (obj instanceof IntRangeSet) {
         IntRangeSet s = (IntRangeSet)obj;
         final int M = upperBoundOf();
         final int N = s.upperBoundOf();
         // Look for members of one set that are outside the universe of
         // the other.
         if (M > N  &&  maxMember() > N) {
            noDiffYet = false;
         }
         else if (M < N  &&  M < s.maxMember()) {
            noDiffYet = false;
         }
         if (noDiffYet) {
            int i = Math.min(M,N) - 1;
            while (i != -1  &&  (isMember(i) == s.isMember(i))) {
               i = i-1;
            }
            noDiffYet = i == -1;
         } 
      }
      else {
         noDiffYet = false;
      }
      return noDiffYet;
   }


   /* Returns a string listing the elements of this set, in ascending order,
   ** between a pair of curly braces.  (E.g., "{3,7,16}")
   */
   public String toString() {
      String result = "";
      for (int i=0; i != N; i++) {
         if (isMember(i)) { result = result + "," + i; }
      }
      if (result.length() != 0) {
         return '{' +  result.substring(1) + '}';
      }
      else {
         return "{}";
      }
   }

   
   // mutators
   // --------

   /* Inserts the specified value into this set.
   ** pre: 0 <= k < upperBoundOf()
   */
   public void insert(int k) { member[k] = true; }

   /* Removes the specified value from this set.
   ** pre: 0 <= k < upperBoundOf()
   */
   public void remove(int k) { member[k] = false; }

   /* Inserts all the members of the given set into this one,
   ** excluding members that are not in this set's universe
   ** (i.e., those having value upperBoundOf() or greater).
   */
   public void absorb(IntRangeSet s) {
      int position = 0;
	   while(position != N) {
		   if(member[position] && !s.isMember(position)) {
			   s.insert(position);
		   }
		   position++;
	   }
	   
   } 
  
   // generators
   // ----------

   /* Returns a clone of this set.
   */
   public IntRangeSet clone() {
      IntRangeSet result = new IntRangeSet(upperBoundOf(), false);
      result.absorb(this);
      return result;
   }

   /* Returns a new object of this class that corresponds to the complement
   ** of this set.  By definition, a set and its complement have the same
   ** universe and, for each element x of that universe, x is a member of 
   ** the set's complement if and only if it is not a member of the set.
   */
   public IntRangeSet complement() {
      IntRangeSet result = new IntRangeSet(N, false);
      int position = 0;
      while(position != N) {
    	  result.insert(position) = member[position];
    	  position++;
      }return result;
    
   }
 

   /* Returns a new object of this class that corresponds to the union
   ** of this set and the given 'other' one.  The upper bound of the new 
   ** set is the larger of this set's and the other one's.
   */
   public IntRangeSet union(IntRangeSet other) {
	   IntRangeSet result = new IntRangeSet(other.upperBoundOf(), false);
	   int position = 0;
	   while(position != result.upperBoundOf()) {
		   if(member[position] || other.isMember(position)) {
			   result.insert(position);
		   }
	   } return result;
   
   }

   /* Returns a new object of this class that corresponds to the intersection
   ** of this set and the given 'other' one.  The upper bound of the new 
   ** set is the larger of this set's and the other one's.
   */
   public IntRangeSet intersection(IntRangeSet other) {
	   IntRangeSet result = new IntRangeSet(other.upperBoundOf(), false);
	   int position = 0;
	   while(position != result.upperBoundOf()) {
		   if(member[position] && other.isMember(position)) {
			   result.insert(position);
		   }
	   } return result;
   }
}
