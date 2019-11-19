package predictive;

import java.util.HashSet;
import java.util.Set;

public class Sigs2WordsTree {
	/**
	 * calling the Sigs2WordsList method to test
	 * 
	 * in 9 test case
	 * Sigs2WordsMap elapsedTime=717 milliseconds
	 * Sigs2WordsTree elapsedTime=2049 milliseconds
	 */
	public static void main(String[] args) {

		//long startTime = System.currentTimeMillis(); // start time
		Set<String> a = new HashSet<>();
		
		//String path = "words";
		String path = "/usr/share/dict/words";
		TreeDictionary nDictionary = new TreeDictionary(path);
		for (int i = 0; i < args.length; i++) {
			a = nDictionary.signatureToWords(args[i]);
			System.out.println(args[i] + ":" + a);
		}
		/*long finishTime = System.currentTimeMillis();  //end time
		long elapsedTime = finishTime - startTime; // elapsed time in milliseconds
		System.out.println("Sigs2WordsTree elapsedTime="+elapsedTime+" milliseconds");*/

	}

}
