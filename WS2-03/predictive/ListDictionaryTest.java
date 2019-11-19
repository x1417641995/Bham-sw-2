package predictive;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ListDictionaryTest {
	
	
	Set<String> set1 = new HashSet<>();
	Set<String> set2 = new HashSet<>();
	
	//String path="words";
	String path="/usr/share/dict/words";
	ListDictionary ListDictionary=new ListDictionary(path);
	@Test
	public void test() {
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
		Set<String> set1 = ListDictionary.signatureToWords("97");
		
		assertEquals(expected1, set1);

		Set<String> expected2 = new HashSet<String>();
		expected2.add("cc");
		expected2.add("bb");
		expected2.add("aa");
		expected2.add("bc");
		expected2.add("ab");
		expected2.add("ac");
		expected2.add("ca");
		expected2.add("cb");
		expected2.add("ba");
		Set<String> set2 = ListDictionary.signatureToWords("22");
		
		assertEquals(expected2, set2);
	}

}
