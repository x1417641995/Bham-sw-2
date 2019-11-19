/**@author Ta-Ju
 * 
 *This class contains the solution for Worksheet3-1
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {
	
	/**
	 * takes a word and returns a numeric signature.
	 * @return sbf
	 * 
	 * use StringBuffer do not need to build each String,
	 * so it is more efficient
	 */
	public static String wordToSignature(String word) {
		
		StringBuffer sbf = new StringBuffer();
		for (int i=0; i< word.length() ;i++) {
			  char a =word.charAt(i);				 
		        switch (a){
		            case 'a':  
		            case 'b':
		            case 'c': 
		            	sbf.append(2);
		            	break;		            	
		            case 'd':  
		            case 'e':
		            case 'f': 
		            	sbf.append(3);
		            	break;
		            case 'g':  
		            case 'h':
		            case 'i': 
		            	sbf.append(4);
		            	break;
		            case 'j':  
		            case 'k':
		            case 'l': 
		            	sbf.append(5);
		            	break;
		            case 'm':  
		            case 'n':
		            case 'o': 
		            	sbf.append(6);
		            	break;
		            case 'p':  
		            case 'q':
		            case 'r': 
		            case 's': 
		            	sbf.append(7);
		            	break;
		            case 't':  
		            case 'u':
		            case 'v': 
		            	sbf.append(8);
		            	break;
		            case 'w':  
		            case 'x':
		            case 'y': 
		            case 'z': 
		            	sbf.append(9);	  	
		            	break;
		            default:
		            	sbf.append("");
		            	break;
		        }
		  }
		  return sbf.toString(); 
	}
	/**
	 * returned list must not have duplicates and each word should be in lower-case
	 * @return set
	 */
	public static Set<String> signatureToWords(String signature){
		
		Set<String> set = new HashSet<String>();
		try {
			 Scanner sc = new Scanner(new File("/usr/share/dict/words"));
			 //Scanner sc = new Scanner(new File("words"));
			 while (sc.hasNextLine()) {
		          String line = sc.nextLine().toLowerCase();
		          if(signature.length() == line.length() && isValidWord(line) == true) {
		        	  if(wordToSignature(line).equals(signature)) {
		        		  set.add(line);
		        		  /*if(!(set).contains(line)) {
		        			  set.add(line);		        			  
		        		  }	*/	        		  
		        	  }
		          }		          
		      }
			 sc.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	/**
	 * returned if word is word or not
	 * @return boolean isValidWord
	 */
	public static boolean isValidWord(String word) {
		
		word = word.toLowerCase();
		for(int i = 0; i < word.length(); i++) {
			char a =word.charAt(i);
			if( a < 'a' || a > 'z') {
				return false;
			}
		}
		return true;
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test 1
		String x=wordToSignature("atgh");
		System.out.println(x); 
		boolean x1=isValidWord("A");
		System.out.print(x1);
		
		
		//////
		
		 Set<String> set1 = new HashSet<String>();
		 //set1=signatureToWords("97");
		 set1=signatureToWords("22");
		// set1=signatureToWords("758");
	     System.out.println((set1));
	        
	}*/
}
