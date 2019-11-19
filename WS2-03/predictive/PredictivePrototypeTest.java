package predictive;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PredictivePrototypeTest {
		
	@Test
	public void test1() {

		String expected1 = "2844";
		String set1 = PredictivePrototype.wordToSignature("atgh");

		assertEquals(expected1, set1);

		String expected2 = "37673";
		String set2 = PredictivePrototype.wordToSignature("Mesore");

		assertEquals(expected2, set2);
		
		String expected3 = "464842";
		String set3 = PredictivePrototype.wordToSignature("Sinitic");

		assertEquals(expected3, set3);

	}
	@Test
	public void test2() {

		Set<String> expected1 = new HashSet<String>();
		expected1.add("yp");
		expected1.add("xp");
		expected1.add("zr");
		expected1.add("wp");
		expected1.add("xq");
		expected1.add("yr");
		expected1.add("zs");
		expected1.add("xr");
		expected1.add("ys");
		expected1.add("wr");
		expected1.add("xs");
		expected1.add("ws");
		Set<String> set1 = PredictivePrototype.signatureToWords("97");
		
		assertEquals(expected1, set1);

		Set<String> expected2 = new HashSet<String>();
		expected2.add("aa");
		expected2.add("bb");
		expected2.add("cc");
		expected2.add("ab");
		expected2.add("bc");
		expected2.add("ac");
		expected2.add("ca");
		expected2.add("ba");
		expected2.add("cb");
		Set<String> set2 = PredictivePrototype.signatureToWords("22");
		
		assertEquals(expected2, set2);
		
	}

}
