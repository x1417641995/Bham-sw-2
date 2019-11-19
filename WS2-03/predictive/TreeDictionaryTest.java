package predictive;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TreeDictionaryTest {
	
		Set<String> set1 = new TreeSet<>();
		Set<String> set2 = new TreeSet<>();		
		//TreeDictionary TreeDictionary= new TreeDictionary("/usr/share/dict/words");
		TreeDictionary TreeDictionary= new TreeDictionary("words");
	
		@Test
		public void test() {
	
			Set<String> expected1 = new HashSet<String>();
			expected1.add("xyz");
			expected1.add("xxx");
			expected1.add("zyz");
			expected1.add("zzz");
	
			set1 =TreeDictionary.signatureToWords("999");
	
			assertEquals(expected1, set1);
	
			Set<String> expected2 = new HashSet<String>();
			
			expected2.add("cc");
			expected2.add("aa");
			expected2.add("bb");
			expected2.add("ab");
			expected2.add("bc");
			expected2.add("ac");
			expected2.add("ca");
			expected2.add("ba");
			expected2.add("cb");
			set2 = TreeDictionary.signatureToWords("22");
	
			assertEquals(expected2, set2);
		}
}
