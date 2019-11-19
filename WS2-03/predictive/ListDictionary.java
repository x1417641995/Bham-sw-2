/**@author Ta-Ju
 * 
 *This class contains the solution for Worksheet3-2
 */
package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ListDictionary implements Dictionary{
	
	/**
     *  Constructor for building ListDictionary.
     *  @param ArrayList<WordSig> a The List of the Dictionary.
     */
	private ArrayList<WordSig> a = new ArrayList(); 
	
	public ListDictionary(String path) {
		
		Set<String> set = new HashSet<String>();
		try {
			
			 Scanner sc = new Scanner(new File(path));
			 while (sc.hasNextLine()) {
		          String line = sc.nextLine().toLowerCase();
		          if(PredictivePrototype.isValidWord(line) == true) {
		        	  WordSig w = new WordSig(line, PredictivePrototype.wordToSignature(line));
		        	  a.add(w);
		          }		          
		      }
			 sc.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(a);
	}
	/**
	 * re-written as an instance method in the List-Dictionary class to use the stored dictionary.
	 * @return b
	 */
	@Override
	public Set<String> signatureToWords(String signature){
		
		Set<String> b = new HashSet(); 
		WordSig find = new WordSig("", signature);
		
		int index = Collections.binarySearch(a, find);
		if(index > 0) {
			String indexsig = a.get(index).getSignature();
			
			int indexfront = index;
			int indexback = index;
			
			b.add(a.get(index).getWords());
			
			while(Objects.equals(indexsig, a.get(indexfront).getSignature())) {
				
				b.add(a.get(indexfront).getWords());
				indexfront++;
				if( indexfront > a.size() || indexfront < 0) {
					//break;
				}			
			}
			while(Objects.equals(indexsig, a.get(indexback).getSignature())) {
				
				b.add(a.get(indexback).getWords());
				indexback--;
				if( indexback > a.size() || indexback < 0) {
					break;
				}
				
			}
			
			
			return b;
		}else {
			return new HashSet<String>();
		}
				
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<WordSig> na=new ArrayList();
		Set<String> pw = new HashSet<>();
		String path="words";
		ListDictionary nDictionary=new ListDictionary(path);
		pw=nDictionary.signatureToWords("97");
		System.out.println(pw);
		
		
	}*/

}
