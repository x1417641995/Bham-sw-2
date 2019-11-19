import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** @author 
 *  Ta-Ju Liu
 * This class contains the test cases for Worksheet1 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet1Test {
	
	List<Integer> d =  new List(2,
							new List(3,
									new List(-5, 
											new List(8,new List()))));
	List<Integer> dd =  new List(-3,
								new List(4,
										new List()));
	List<Integer> ddd =  new List();
	List<Integer> dddd =  new List(2,
								new List(3,
										new List(5, 
												new List(8,new List()))));
	List<Integer> d5 =  new List(-3,
								new List());
	List<Integer> d6 = new List(2,
			new List(5,
					new List(5, 
							new List(5,
									new List(7,
											new List(8,
													new List(8,
															new List(9,
																	new List()))))))));
	private final static double EPSILON = 1e-6;

	@Before
	/*public void setUp() {
		
	}*/

	// public test
	@Test
	public void test1() {

		int expected1 = 32;
		int power1 = Worksheet1.power(2, 5);
		
		assertEquals(expected1, power1);
		
		int expected2 = 81;
		int power2 = Worksheet1.power(3, 4);
		
		assertEquals(expected2, power2);
		
		int expected3 = 1024;
		int power3 = Worksheet1.power(2, 10);
		
		assertEquals(expected3, power3);
		
		int expected4 = 32;
		int fastPower4 = Worksheet1.fastPower(2, 5);
		
		assertEquals(expected4, fastPower4);
		
		int expected5 = 81;
		int fastPower5 = Worksheet1.fastPower(3, 4);
		
		assertEquals(expected5, fastPower5);
		
		int expected6 = 1024;
		int fastPower6 = Worksheet1.fastPower(2, 10);
		
		assertEquals(expected6, fastPower6);

		
	}
	@Test
	public void test2() {

		List<Integer> expected1 = new List(-2,
										new List(-3,
												new List(5, 
														new List(-8,new List()))));
		List<Integer> negateAll1= Worksheet1.negateAll(d);
		
		assertEquals(expected1, negateAll1);
		
		List<Integer> expected2  =  new List(3,
											new List(-4,
												new List()));
		List<Integer> negateAll2 = Worksheet1.negateAll(dd);
		
		assertEquals(expected2, negateAll2);
		
		List<Integer> expected3 = new List();;
		List<Integer> negateAll3 = Worksheet1.negateAll(ddd);
		
		assertEquals(expected3, negateAll3);
		
	}
	@Test
	public void test3() {

		int expected1 = 1;
		int find1= Worksheet1.find(3, d);
		assertEquals(expected1, find1);
		
		int expected2 = 0;
		int find2= Worksheet1.find(-3, dd);
		
		assertEquals(expected2, find2);
		
		int expected3 = 3;
		int find3= Worksheet1.find(8, d);
		
		assertEquals(expected3, find3);
				
	}
	@Test
	public void test4() {

		boolean expected1 = true;
		boolean allPositive1= Worksheet1.allPositive(dddd);
		
		assertEquals(expected1, allPositive1);
		
		boolean expected2 = false;
		boolean allPositive2= Worksheet1.allPositive(dd);
		
		assertEquals(expected2, allPositive2);
		
		boolean expected3 = true;
		boolean allPositive3= Worksheet1.allPositive(ddd);
		
		assertEquals(expected3, allPositive3);
				
	}
	@Test
	public void test5() {

		List<Integer> expected1 = new List(2,
										new List(3,
											new List(8,new List())));
		List<Integer> positives1= Worksheet1.positives(d);
		
		assertEquals(expected1, positives1);
		
		List<Integer> expected2 = new List(4,
										new List());
		List<Integer> positives2= Worksheet1.positives(dd);
		
		assertEquals(expected2, positives2);
		
		List<Integer> expected3 = new List();
		List<Integer> positives3= Worksheet1.positives(ddd);
		
		assertEquals(expected3, positives3);
		
		List<Integer> expected4 = new List();
		List<Integer> positives4= Worksheet1.positives(d5);
		
		assertEquals(expected4, positives4);
				
	}
	@Test
	public void test6() {

		boolean expected1 = false;
		boolean sorted1= Worksheet1.sorted(d);
		
		assertEquals(expected1, sorted1);
		
		boolean expected2 = true;
		boolean sorted2= Worksheet1.sorted(dd);
		
		assertEquals(expected2, sorted2);
		
		boolean expected3 = true;
		boolean sorted3= Worksheet1.sorted(ddd);
		
		assertEquals(expected3, sorted3);
		
		boolean expected4 = true;
		boolean sorted4= Worksheet1.sorted(d5);
		
		assertEquals(expected4, sorted4);
				
	}
	@Test
	public void test7() {

		List<Integer> expected1 = new List(2,
										new List(3,
												new List(5, 
														new List(8,new List()))));
		List<Integer> merge1= Worksheet1.merge(ddd, dddd);
		
		assertEquals(expected1, merge1);
		
		List<Integer> expected2 = new List(-3,
										new List(2,
												new List(3, 
														new List(4,
																new List(5,
																		new List(8,
																				new List()))))));
		List<Integer> merge2= Worksheet1.merge(dd, dddd);
		
		assertEquals(expected2, merge2);
		
		List<Integer> expected3 = new List(2,
										new List(3,
												new List(5, 
														new List(8,new List()))));
		List<Integer>  merge3= Worksheet1.merge(dddd, ddd);
		
		assertEquals(expected3,  merge3);
				
	}
	@Test
	public void test8() {

		List<Integer> expected1 = new List(2,
										new List(3,
												new List(5, 
														new List(8,new List()))));
		List<Integer> removeDuplicates1= Worksheet1.removeDuplicates(dddd);
		
		assertEquals(expected1, removeDuplicates1);
		
		List<Integer> expected2 = new List();
		List<Integer> removeDuplicates2= Worksheet1.removeDuplicates(ddd);
		
		assertEquals(expected2, removeDuplicates2);
		
		List<Integer> expected3 = new List(2,
				new List(5,
						new List(7, 
								new List(8,
										new List(9,
												new List())))));
		List<Integer> removeDuplicates3= Worksheet1.removeDuplicates(d6);
		
		assertEquals(expected3, removeDuplicates3);
		
				
	}
	
}
