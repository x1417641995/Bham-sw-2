package predictive;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MapDictionaryTest {
	
	
	HashMap<String, Set<String>> na=new HashMap();
	Set<String> set1 = new HashSet<>();
	Set<String> set2 = new HashSet<>();
	
	//String path="words";
	String path="/usr/share/dict/words";
	MapDictionary MapDictionary=new MapDictionary(path);

	@Test
	public void test() {
		
		
		Set<String> expected1 = new HashSet<String>();
		expected1.add("xyz");
		expected1.add("xxx");
		expected1.add("zzz");
		
		set1 = MapDictionary.signatureToWords("999");
		
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
		set2 = MapDictionary.signatureToWords("22");
		
		assertEquals(expected2, set2);
	}
	

}
