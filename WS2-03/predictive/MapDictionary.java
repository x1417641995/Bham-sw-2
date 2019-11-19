/**@author Ta-Ju
 * 
 *This class contains the solution for Worksheet3-2
 */
package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MapDictionary implements Dictionary{
	/**
     *  Constructor for building MapDictionary.
     *  @param ArrayListHashMap<String, Set<String>> a map of the Dictionary.
     */
	
	public HashMap<String, Set<String>> map;
	
	public MapDictionary(String path) {
		
		this.map = new HashMap();
		try {
			 
			 Scanner sc = new Scanner(new File(path));
			 while (sc.hasNextLine()) {
		          String line = sc.nextLine().toLowerCase();
		          if(PredictivePrototype.isValidWord(line) == true) {
		        	  String s = PredictivePrototype.wordToSignature(line);
		        	  buildMapWords(s, line);
		          }		          
		      }
			 sc.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * build a MapWords
	 * @return mapWords
	 */
	public Set<String> buildMapWords(String signature,String word){
		
		Set<String> mapWords = new HashSet<>();
		if (!map.containsKey(signature)){
			mapWords.add(word);
			map.put(signature, mapWords);
		}
		else {
			mapWords=map.get(signature);
			mapWords.add(word);
			map.put(signature, mapWords);
		}
		return mapWords;
		
	}
	/**
	 * re-written as an instance method in the MapDictionary class to use the dictionary.
	 * @return map.get(signature)
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		if(map.containsKey(signature)) {
			return map.get(signature); 
		}else {
			return Collections.emptySet();
		}
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Set<String>> na=new HashMap();
		Set<String> pw = new HashSet<>();
		String path="words";
		//String path="/usr/share/dict/words";
		MapDictionary nMapDictionary=new MapDictionary(path);
		pw=nMapDictionary.signatureToWords("4663");
		System.out.println(pw);
		pw=nMapDictionary.signatureToWords("97");
		System.out.println(pw);
	}*/

}
