/**@author Ta-Ju
 * 
 *This class contains the solution for Worksheet3-1
 */
package predictive;

import java.util.HashSet;
import java.util.Set;

public class Sigs2WordsProto {
	/**
	 * calling the signatureToWords method to test
	 */
	public static void main(String[] args) {
		
		//long startTime = System.currentTimeMillis(); // start time
		Set<String> b = new HashSet<String>();
		for(int i = 0; i < args.length ; i++) {
			Set a = PredictivePrototype.signatureToWords(args[i]);
			System.out.println(args[i] + ":" + a);
		}
		/*long finishTime = System.currentTimeMillis();  //end time
		long elapsedTime = finishTime - startTime; // elapsed time in milliseconds
		System.out.println("Sigs2WordsProto elapsedTime="+elapsedTime+" milliseconds");*/
	}
}
