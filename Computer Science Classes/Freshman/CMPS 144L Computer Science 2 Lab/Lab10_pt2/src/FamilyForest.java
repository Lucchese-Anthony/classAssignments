/* FamilyForest.java
**
** An instance of this class represents a forest of family trees (i.e., a
** collection of one or more such trees).  Each node is identified by a
** natural number.
**
** Authors: R. McCloskey and < STUDENTS' NAMES >
** Known Defects: ...
*/

public class FamilyForest {

   // class constant
   // --------------

   private static final int DEFAULT_NUM_NODES= 100;


   // instance variable
   // -----------------
   private int[] parent;    // parent[i] == j means that j is i's parent 
                            // parent[i] == -1 if i has no parent


   // constructors
   // ------------

   /* Initializes this forest to have the default number of nodes, 
   ** each of which has no parent. 
   */
   public FamilyForest() { this(DEFAULT_NUM_NODES); }

   /* Initializes this forest to have the specified number of nodes, 
   ** each of which has no parent.
   */
   public FamilyForest(int numNodes) { 
      parent = new int[numNodes];
      for (int i=0; i != numNodes; i++) {
         parent[i] = -1;       // Initially, no node has a parent
      }
   }


   // observers
   // ---------

   /* Returns the ID of the d-ancestor of node k (or -1 if such an
   ** ancestor does not exist).
   ** pre: d >= 0
   */
   public int ancestorOf(int k, int d) {
      int m = k;
      while (m != -1  &&  d != 0) {
         m = parent[m];
         d = d-1;
      }
      return m;
   }
   
   /* Returns the ID of the parent of node k, or -1 if k has no parent.
   */
   public int parentOf(int k) { return ancestorOf(k,1); }

   /* Returns the ID of the root of the tree containing node k (i.e., the 
   ** ancestor of k having no parent).
   */
   public int rootOf(int k) {
      int result = rootOf(parentOf(k));
      return result; 
   }

   /* Returns the ID of the nearest common ancestor of the two
   ** specified nodes.  If none exists, -1 is returned.
   */
   public int nearestCommonAncestor(int k, int m) {
      if(isAncestorOf(m, k)){
         while(distance(k, m) != 1){
            if(k > m){
               k = parentOf(k);
            } else{
               m = parentOf(m);
            }
         } return parentOf(k);
      } else { return -1; }   
      
      
      
      //Hint: Begin the search for the nearest common ancestor of k and m
      //      at ancestors of k and m, respectively, that are at the same
      //      distance from the root of the tree containing k and m
      //      (assuming, of course, that k and m are in the same tree).
   }

   /* If node m is an ancestor of node k, returns the distance from 
   ** k to m (i.e., number of generations).  Otherwise, returns -1.
   ** (Examples: The distance from a node to its grandparent is 2.)
   */
   public int distance(int k, int m) {
      int cntr = 0;
      while (k != -1  &&  k != m) {
         k = parent[k];
         cntr++;
      }
      if (k == -1) { return -1; }
      else { return cntr; }
   }

   /* Reports whether or not node m is an ancestor of node k.
   */
   public boolean isAncestorOf(int m, int k) {
      return distance(k,m) != -1;
   }


   // mutator
   // -------

   /* Assuming that node k is not a proper ancestor of node m, 
   ** makes m the parent of k and returns true (for success).
   ** Otherwise, makes no changes to the forest and returns false
   ** (for failure).
   */
   public boolean setParent(int k, int m) {
      boolean result;
      if (!isAncestorOf(k,m)) {
         parent[k] = m;
         result = true;
      }
      else {
         result = false;
      }
      return result;
   }

}
