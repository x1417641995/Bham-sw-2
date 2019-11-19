/**@author Ta-Ju
 * 
 *This class contains the solution for Worksheet3-1
 */
package predictive;

import java.util.HashSet;
import java.util.Set;

public class Words2SigProto {
	/**
	 * calling the signatureToWords method to test
	 */	
	public static void main(String[] args) {
		
		
		for(int i = 0; i < args.length ; i++) {
			String a = PredictivePrototype.wordToSignature(args[i]);
			System.out.println(args[i] + ":" + a);
		}
	}
}
