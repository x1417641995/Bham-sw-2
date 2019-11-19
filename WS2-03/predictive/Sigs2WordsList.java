package predictive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sigs2WordsList {
	/**
	 * calling the Sigs2WordsList method to test
	 * 
	 * in 9 test case
	 * Sigs2WordsList elapsedTime=731 milliseconds
	 * Sigs2WordsProto elapsedTime=3959 milliseconds
	 * Sigs2WordsList build a Dictionary first,
	 * then is just search words.
	 * Sigs2WordsList elapsedTime is more efficient than Sigs2WordsProto in more test case 
	 */
	public static void main(String[] args) {
		
		//long startTime = System.currentTimeMillis(); // start time
		Set<String> a = new HashSet<>();
		ArrayList<WordSig> b=new ArrayList();
		
		//String path = "words";
		String path = "/usr/share/dict/words";
		ListDictionary nDictionary=new ListDictionary(path);
		for(int i = 0 ; i < args.length ; i++)  {			
			 a = nDictionary.signatureToWords(args[i]);
			 System.out.println(args[i] + ":" + a);
		}
		/*long finishTime = System.currentTimeMillis();  //end time
		long elapsedTime = finishTime - startTime; // elapsed time in milliseconds
		System.out.println("Sigs2WordsList elapsedTime="+elapsedTime+" milliseconds");*/
		 
	  }
}
		
	 


