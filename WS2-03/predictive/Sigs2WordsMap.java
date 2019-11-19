package predictive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sigs2WordsMap {
	public static void main(String[] args) {

		//long startTime = System.currentTimeMillis(); // start time
		Set<String> a = new HashSet<>();
		
		//String path = "words";
		String path = "/usr/share/dict/words";
		MapDictionary nDictionary = new MapDictionary(path);
		for (int i = 0; i < args.length; i++) {
			a = nDictionary.signatureToWords(args[i]);
			System.out.println(args[i] + ":" + a);
		}
		/*long finishTime = System.currentTimeMillis();  //end time
		long elapsedTime = finishTime - startTime; // elapsed time in milliseconds
		System.out.println("Sigs2WordsMap elapsedTime="+elapsedTime+" milliseconds");*/

	}
}
