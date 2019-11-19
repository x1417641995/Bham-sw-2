import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author 
 * @param <E>
 * 
 *
 */

public class Worksheet2Test<E> {
	
	
	
	Tree<Integer> t =new Tree (6,
			new Tree(4,
					new Tree(2,
							new Tree(1, new Tree(),
									new Tree()),
							new Tree()),
					new Tree(5, new Tree(), new Tree())),    
			new Tree(8, 
					new Tree(7, new Tree(), new Tree()),
					new Tree(9, new Tree(), new Tree())));
	
	Tree<Integer> t2 =new Tree (0,
			new Tree(4,
					new Tree(2,
							new Tree(1, new Tree(),
									new Tree()),
							new Tree()),
					new Tree(-5, new Tree(), new Tree())),    
			new Tree(-8, 
					new Tree(7, new Tree(), new Tree()),
					new Tree(-9, new Tree(), new Tree())));
	
	Tree<Integer> t3 =new Tree();
	
	Tree<Integer> t4 =new Tree(-4,new Tree(), new Tree());
	
	Tree<Integer> t5 = new Tree (5,
			new Tree(3,
					new Tree(1,	 new Tree(), new Tree()),							
					new Tree(4, new Tree(), new Tree())),    
			new Tree(8, 
					new Tree(6, new Tree(), new Tree()),
					new Tree()));
	
	Tree<Integer> t6 = new Tree (5,
			new Tree(-3,
					new Tree(1,	 new Tree(), new Tree()),							
					new Tree(-4, new Tree(), new Tree())),    
			new Tree(8, 
					new Tree(-6, new Tree(), new Tree()),
					new Tree()));
	
	Tree<Integer> t7 = new Tree (6,
			new Tree(4,
					new Tree(2,new Tree(),new Tree()),
					new Tree(5, new Tree(), new Tree())),    
			new Tree(8, 
					new Tree(7, new Tree(), new Tree()),
					new Tree(9, new Tree(), new Tree())));
	Tree<Integer> t8 = new Tree (7,
			new Tree(4,
					new Tree(3, 
							new Tree(2,new Tree(),new Tree()),
							new Tree()),
					new Tree()),    
			new Tree(9, 
					new Tree(8, new Tree(), new Tree()),
					new Tree(10, new Tree(), new Tree())));
	
	private final static double EPSILON = 1e-6;

	@Before
	/*public void setUp() {
		
	}*/

	// public test
	@Test
	public void test1() {

		Tree<Integer> expected1 = new Tree (-6,
				new Tree(-4,
						new Tree(-2,
								new Tree(-1, new Tree(),
										new Tree()),
								new Tree()),
						new Tree(-5, new Tree(), new Tree())),    
				new Tree(-8, 
						new Tree(-7, new Tree(), new Tree()),
						new Tree(-9, new Tree(), new Tree())));
		Tree<Integer> negateAll1 = Worksheet2.negateAll(t);
		
		assertEquals(expected1, negateAll1);
		
		Tree<Integer> expected2 = new Tree (0,
				new Tree(-4,
						new Tree(-2,
								new Tree(-1, new Tree(),
										new Tree()),
								new Tree()),
						new Tree(5, new Tree(), new Tree())),    
				new Tree(8, 
						new Tree(-7, new Tree(), new Tree()),
						new Tree(9, new Tree(), new Tree())));
		Tree<Integer> negateAll2 = Worksheet2.negateAll(t2);
		
		assertEquals(expected2, negateAll2);
		
		Tree<Integer> expected3 = new Tree ();
		Tree<Integer> negateAll3 = Worksheet2.negateAll(t3);
		
		assertEquals(expected3, negateAll3);
		
		Tree<Integer> expected4 = new Tree(4,new Tree(), new Tree());
		Tree<Integer> negateAll4 = Worksheet2.negateAll(t4);
		
		assertEquals(expected4, negateAll4);						
	}
	
	@Test
	public void test2() {

		boolean expected1 = true;
		boolean allPositive1 = Worksheet2.allPositive(t);
		
		assertEquals(expected1, allPositive1);
		
		boolean expected2 = false;
		boolean allPositive2 = Worksheet2.allPositive(t2);
		
		assertEquals(expected2, allPositive2);
		
		boolean expected3 = true;
		boolean allPositive3 = Worksheet2.allPositive(t3);
		
		assertEquals(expected3, allPositive3);
		
		boolean expected4 = false;
		boolean allPositive4 = Worksheet2.allPositive(t4);
		
		assertEquals(expected4, allPositive4);
	}
	
	@Test
	public void test3() {

		Tree<E> expected1 = new Tree (5,    
				new Tree(8, 
						new Tree(),
						new Tree(6, new Tree(), new Tree())),
				new Tree(3,
						new Tree(4,	 new Tree(), new Tree()),							
						new Tree(1, new Tree(), new Tree())));
		Tree<E> mirror1 = (Tree<E>) Worksheet2.mirror(t5);
		
		assertEquals(expected1, mirror1);
		
		Tree<E> expected2 = new Tree (5,    
				new Tree(8, 
						new Tree(),
						new Tree(-6, new Tree(), new Tree())),
				new Tree(-3,
						new Tree(-4,new Tree(), new Tree()),							
						new Tree(1, new Tree(), new Tree())));
		Tree<E> mirror2 = (Tree<E>) Worksheet2.mirror(t6);
		
		assertEquals(expected2, mirror2);
		
		Tree<E> expected3 = new Tree();
		Tree<E> mirror3 = (Tree<E>) Worksheet2.mirror(t3);
		
		assertEquals(expected3, mirror3);
		
		Tree<E> expected4 = new Tree(-4,new Tree(), new Tree());
		Tree<E> mirror4 = (Tree<E>) Worksheet2.mirror(t4);
		
		assertEquals(expected4, mirror4);
	}
	
	@Test
	public void test4() {

		List<E> expected1 = new List(1,
				new List(4,
						new List(3, 
								new List(6,
										new List(8,
												new List(5,
														new List()))))));
		
		List<E> postorder1 = (List<E>) Worksheet2.postorder(t5);
		
		assertEquals(expected1, postorder1);
		
		List<E> expected2 = new List(1,
				new List(-4,
						new List(-3, 
								new List(-6,
										new List(8,
												new List(5,
														new List()))))));
				
		List<E> postorder2 = (List<E>) Worksheet2.postorder(t6);
		
		assertEquals(expected2, postorder2);
		
		List<E> expected3 = new List();
		List<E> postorder3 = (List<E>) Worksheet2.postorder(t3);
		
		assertEquals(postorder3, postorder3);
		
		List<E> expected4 = new List(4,
									new List());
		List<E> postorder4 = (List<E>) Worksheet2.postorder(t4);
		
		assertEquals(postorder4, postorder4);
	}
	
	@Test
	public void test5() {

		boolean expected1 = true;
		boolean isSearchTree1 = Worksheet2.isSearchTree(t);
		
		assertEquals(expected1, isSearchTree1);
		
		boolean expected2 = false;
		boolean isSearchTree2 = Worksheet2.isSearchTree(t6);
		
		assertEquals(expected2, isSearchTree2);
		
		boolean expected3 = true;
		boolean isSearchTree3 = Worksheet2.isSearchTree(t3);
		
		assertEquals(expected3, isSearchTree3);
		
		boolean expected4 = true;
		boolean isSearchTree4 = Worksheet2.isSearchTree(t4);
		
		assertEquals(expected4, isSearchTree4);
	}
	
	/*@Test
	public void test6() {

		String expected1 = true;
		boolean isSearchTree1 = Worksheet2.isSearchTree(t);
		
		assertEquals(expected1, isSearchTree1);
		
		boolean expected2 = false;
		boolean isSearchTree2 = Worksheet2.isSearchTree(t6);
		
		assertEquals(expected2, isSearchTree2);
		
		boolean expected3 = true;
		boolean isSearchTree3 = Worksheet2.isSearchTree(t3);
		
		assertEquals(expected3, isSearchTree3);
		
		boolean expected4 = true;
		boolean isSearchTree4 = Worksheet2.isSearchTree(t4);
		
		assertEquals(expected4, isSearchTree4);
	}*/
	
	@Test
	public void test7() {

		int expected1 = 9;
		int max1 = Worksheet2.max(t);
		
		assertEquals(expected1, max1);
		
		int expected2 = 8;
		int max2 = Worksheet2.max(t5);
		
		assertEquals(expected2, max2);
		
		int expected3 = 0;
		int max3 = Worksheet2.max(t3);
		
		assertEquals(expected3, max3);
		
		int expected4 = -4;
		int max4 = Worksheet2.max(t4);
		
		assertEquals(expected4, max4);
	}
	
	@Test
	public void test8() {

		Tree<E> expected1 = new Tree (6,
				new Tree(4,
						new Tree(2,
								new Tree(1, new Tree(),
										new Tree()),
								new Tree()),
						new Tree(5, new Tree(), new Tree())),    
				new Tree(7, 
						new Tree(),
						new Tree(9, new Tree(), new Tree())));
		Tree<E> delete1 = (Tree<E>) Worksheet2.delete(t, 8);
		
		assertEquals(expected1, delete1);
		
		Tree<E> expected2 = new Tree (6,
				new Tree(2,
						new Tree(),
						new Tree(5, new Tree(), new Tree())),    
				new Tree(8, 
						new Tree(7, new Tree(), new Tree()),
						new Tree(9, new Tree(), new Tree())));
		Tree<E> delete2 = (Tree<E>) Worksheet2.delete(t7, 4);
		
		assertEquals(expected2, delete2);		
	}
	
	@Test
	public void test9() {

		boolean expected1 = true;
		boolean isHeightBalanced1 = Worksheet2.isHeightBalanced(t);
		
		assertEquals(expected1, isHeightBalanced1);
		
		boolean expected2 = false;
		boolean isHeightBalanced2 = Worksheet2.isHeightBalanced(t8);
		
		assertEquals(expected2, isHeightBalanced2);
		
		boolean expected3 = true;
		boolean isHeightBalanced3 = Worksheet2.isHeightBalanced(t3);
		
		assertEquals(expected3, isHeightBalanced3);
		
		boolean expected4 = true;
		boolean isHeightBalanced4 = Worksheet2.isHeightBalanced(t4);
		
		assertEquals(expected4, isHeightBalanced4);
	}
	
	@Test
	public void test10() {

		Tree<E> expected1 = new Tree (6,
				new Tree(4,
						new Tree(2,
								new Tree(1, new Tree(),
										new Tree()),
								new Tree()),
						new Tree(5, 
								new Tree(), new Tree())),    
				new Tree(8, 
						new Tree(7, new Tree(), new Tree()),
						new Tree(9, 
								new Tree(),
								new Tree(10, new Tree(), new Tree()))));
		Tree<E> insertHB1 = (Tree<E>) Worksheet2.insertHB(10, t);
		
		assertEquals(expected1, insertHB1);
		
		Tree<E> expected2 = new Tree (6,
				new Tree(4,
						new Tree(2, 
								new Tree(), 
								new Tree(3, new Tree(), new Tree())),
						new Tree(5, new Tree(), new Tree())),    
				new Tree(8, 
						new Tree(7, new Tree(), new Tree()),
						new Tree(9, new Tree(), new Tree())));
		Tree<E> insertHB2 = (Tree<E>) Worksheet2.insertHB(3, t7);
		
		assertEquals(expected2, insertHB2);
		
		Tree<E> expected3 = new Tree (6,
				new Tree(4,
						new Tree(2,
								new Tree(1, new Tree(),
										new Tree()),
								new Tree()),
						new Tree(5, new Tree(), new Tree())),    
				new Tree(7, 
						new Tree(),
						new Tree(9, new Tree(), new Tree())));
		Tree<E> deleteHB1 = (Tree<E>) Worksheet2.deleteHB(t, 8);
		
		assertEquals(expected3, deleteHB1);
		
		Tree<E> expected4 = new Tree (6,
				new Tree(2,
						new Tree(),
						new Tree(5, new Tree(), new Tree())),    
				new Tree(8, 
						new Tree(7, new Tree(), new Tree()),
						new Tree(9, new Tree(), new Tree())));
		Tree<E> deleteHB2 = (Tree<E>) Worksheet2.deleteHB(t7, 4);
		
		assertEquals(expected4, deleteHB2);
	}
	
}
