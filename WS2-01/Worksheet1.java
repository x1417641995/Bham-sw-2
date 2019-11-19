/** @author 
 * Ta-JU Liu
 * This class contains the solution for Worksheet1
 */

public class Worksheet1 {

  // Exercise 1
	/**
	 * calculate integer m to the power of integer n
	 * @return m
	 */
  public static int power(int m, int n) {
	  if(n == 0){
			return 1;
		}else {
			m = m*power(m, n-1);
			return m;
		}
			//return 0; // replace this by your code
	}
  /**
	 * calculate integer m to the power of integer n
	 * @return m
	 */
  public static int fastPower(int m, int n) {
	  if(n == 0){
			return 1;
		}else if(n % 2 == 0){
			m = power(fastPower(m, n/2), 2);
			return m;
		}else {
			m = m*fastPower(m, n-1);
			return m;
		} // replace this by your code
	}

  // Exercise 2
  /**
	 * returns a new list with all the elements of a with sign negated
	 * @return a
	 */
	public static List<Integer> negateAll(List<Integer> a) {
		if(a.isEmpty()) { 
			return a;
		}else {
			return new List<Integer>(-a.getHead(), negateAll(a.getTail()));
		}
	}

  // Exercise 3
	/**
	 * returns the position of the first occurrence of x in a
	 * @return f final position
	 */
	public static int find(int x, List<Integer> a) {
		int i;
		if(a.isEmpty()) { 
			 throw new IllegalStateException(
                     "IllegalStateException");
		}else if( x == a.getHead()){
			return 0;			
		}else {
			//i++;
			int f = find(x,a.getTail());
			return f+1;
		}
			//return 0; //replace this by your code
	}

	// Exercise 4
	/**
	 * return a boolean value indicating whether all its elements are positive
	 * @return boolean allPositive
	 */
	public static boolean allPositive(List<Integer> a) {
		if(a.isEmpty()) {
			return true;
		}else if(a.getHead() >= 0){
			boolean allPositive = allPositive(a.getTail());
			return allPositive;
		}else {
			return false;
		}
			//return true; //replace this by your code
	}

	// Exercise 5
	/**
	 * return a new list which contains all the positive elements of a
	 * @return a
	 */
	public static List<Integer> positives(List<Integer> a) {
		if(a.isEmpty()) 
			return new List() ;
		else if(a.getHead() >= 0) {
			return new List(a.getHead(), positives(a.getTail()));
		}else {
			return positives(a.getTail());
		}
		
			//return new List<Integer>(); //replace this by your code
	}
	
	// Exercise 6//err0r 1
	/**
	 * return a boolean value indicating whether a is sorted in increasing order
	 * @return boolean sorted
	 */
	public static boolean sorted(List<Integer> a) {
		if(a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		}else if(a.getHead() <= a.getTail().getHead()){
			boolean sorted = sorted(a.getTail());
			return sorted;
		}else {
			return false;
		}
			//return true; //replace this by your code
	}

	// Exercise 7
	/**
	 * new sorted list that contains all the elements of a and all the elements of b
	 * @return List<Integer> merge
	 */
	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if(a.isEmpty()) {
			return b;
		}else if(b.isEmpty()){
			return a;
		}else{
			if(a.getHead() <= b.getHead()) {
				return new List(a.getHead(), merge(a.getTail(), b));
			}else {
				return new List(b.getHead(), merge(b.getTail(), a));
			}
		}
				
	}

	// Exercise 8
	/**
	 * a copy of the list a with all duplicate copies removed
	 * @return List<Integer> removeDuplicates
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
			//int i = a.getHead();
			if(a.isEmpty() || a.getTail().isEmpty()) {
				return a;
			}else if(a.getHead() == a.getTail().getHead()) {
				return removeDuplicates(a.getTail());
			}else {
				return new List(a.getHead(), removeDuplicates(a.getTail()));
			}
			//return new List<Integer>(); //replace this by your code
	}	

}
