/** @author 
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {
    // Exercise 1
	/**
	 * returns a new tree containing all the elements of a with their sign negated
	 * @return t
	 */
    public static Tree<Integer> negateAll(Tree<Integer> t) {
    	if(t.isEmpty()) {
    		return t;
    	}else {
    		return new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
    	}
				//return new Tree();
    }

    // Exercise 2
    /**
	 * return a boolean value indicating whether all the values in its nodes are positive
	 * @return a
	 */
    public static boolean allPositive(Tree<Integer> a) {
    	if(a.isEmpty()) {
    		return true;
    	}else if(a.getValue() >= 0){        	
    		return allPositive(a.getRight()) && allPositive(a.getLeft());
    	}else {
    		return false; 
    	}
				//return true;
    }

    // Exercise 3
    /**
	 * return a tree that is the mirror image of a along the left-right axis
	 * @return t
	 */
    public static<E> Tree<E> mirror(Tree<E> t) {
    	if(t.isEmpty()) {
    		return t;
    	}else {
    		return new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
    	}
    	
				//return new Tree();
	}

    // Exercise 4
    /**
	 * return a list containing the values in a by trvaersing the nodes in postorder
	 * @return List<E> postorder
	 */
    public static<E> List<E> postorder(Tree<E> t) {
    	if(t.isEmpty()) {
    		return new List();
    	}else {
    		return ListOpsGeneric.append((postorder(t.getLeft())), 
            		ListOpsGeneric.addtoend(postorder(t.getRight()), 
            				t.getValue()));
    	}
				
    	//return new List();
    }

		// Exercise 5
    /**
	 * returns a boolean value indicating whether a is a binary search tree
	 * @return boolean isSearchTree
	 */
    public static boolean isSearchTree(Tree<Integer> a) {
    	if(a.isEmpty()|| a.getRight().isEmpty()&&a.getLeft().isEmpty()) {
    		return true;
    	}else if(a.getLeft().isEmpty()){ 
    		if(a.getValue() < a.getRight().getValue()){
    			return true;
    		}else {
    			return false;
    					//isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
    		}   		
    	}else if(a.getRight().isEmpty()){ 
    		if(a.getValue() > a.getLeft().getValue()){
    			return true;
    		}else {
    			return false;
    		}
    	}else if(a.getValue() < a.getRight().getValue()&&a.getValue() > a.getLeft().getValue()){ 
  
    		return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
    	}else {
    		
					return false;
    	}
    	/*System.out.println(a.getValue());
    		System.out.println(a.getLeft().getValue());
    		System.out.println(a.getRight().getValue());*/
				//return true;
    }

    // Exercise 6
    /**
	 * prints the values stored in it in descending order
	 * @return printDescending
	 */
    public static void printDescending(Tree<Integer> a) {
    	if (a.isEmpty())
			return ;
    	else {
			printDescending(a.getRight());
			System.out.print(a.getValue());
			printDescending(a.getLeft());
		}	
    }

		// Exercise 7
    /**
	 * return the maximum value stored in the tree.
	 * @return max
	 */
    public static int max(Tree<Integer> a) {
    	if(a.isEmpty()) {
    		return 0;
    	}else if(a.getRight().isEmpty()){
     		return a.getValue();
     		
    	}else if(a.getValue() < a.getRight().getValue()){
    		
     		int m=(a.getValue());
     		return max(a.getRight());
    	}else {
    		return a.getValue();
    	}
				//return 0;
    }

    // Exercise 8
    /**
	 * delete the value x from a and return the resulting tree
	 * @return a
	 */
    public static Tree<Integer> delete(Tree<Integer> a, int x) {
    	if (a.isEmpty())
			return a;
    	else if(a.getValue() == x){
			int b = max(a.getLeft());
			if(a.getRight().isEmpty()){
				return new Tree();
			}else {
				return new Tree(b, delete(a.getLeft(), b), delete(a.getRight(), b));
			}
			
		}else {
			return new Tree(a.getValue(), delete(a.getLeft(), x), delete(a.getRight(), x));
		}
				//return new Tree();
    }

		// Exercise 9
    /**
	 * check to see if it is height-balanced, returning a boolean value
	 * @return boolean isHeightBalanced
	 */
    public static<E> boolean isHeightBalanced(Tree<E> a) {
    	if (a.isEmpty())
			return true;
    	else if(a.getLeft().getHeight() - a.getRight().getHeight() > 1 ||
    			a.getLeft().getHeight() - a.getRight().getHeight() < -1){
			return false;
			
		}else {
			return isHeightBalanced(a.getLeft())&&isHeightBalanced(a.getRight());
		}
    	
				//return true;
    }

		// Exercise 10
    /**
	 * insert methods that maintain the height-balanced property of trees
	 * @return boolean isHeightBalanced
	 */
    public static Tree<Integer> insertHB(int x, Tree<Integer> a) {
    	if (a.isEmpty())
    		return a;
    	else if(a.getValue() < x){
    		if(a.getRight().isEmpty() ){
        		
    			return new Tree(a.getValue(), 
    					a.getLeft(), 
    					new Tree(x, new Tree(), new Tree()));
    		}else {
    			return new Tree(a.getValue(), a.getLeft(), insertHB(x, a.getRight()));
    		}	
    	}else if(a.getValue() > x){
    		if(a.getLeft().isEmpty()){
       		
    			return new Tree(a.getValue(), 
    					new Tree(x, new Tree(), new Tree()), 
    					a.getRight());
    		}else {
    			return new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight());
    		}
									
		}else {
			
			return new Tree(a.getValue(), a.getLeft(), a.getRight());
		}
				//return new Tree();
    }
    /**
	 * delete methods that maintain the height-balanced property of trees
	 * @return a
	 */
    public static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
    	if (a.isEmpty())
			return a;
    	else if(a.getValue() == x){
			int b = max(a.getLeft());
			if(a.getRight().isEmpty()){
				return new Tree();
			}else {
				return new Tree(b, delete(a.getLeft(), b), delete(a.getRight(), b));
			}
			
		}else {
			return new Tree(a.getValue(), deleteHB(a.getLeft(), x), deleteHB(a.getRight(), x));
		}
				//return new Tree();
    }
	
}
