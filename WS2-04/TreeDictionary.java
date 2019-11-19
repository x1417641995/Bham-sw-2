

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeDictionary implements Dictionary {

	/**
	 * Constructor for building TreeDictionary.
	 * 
	 * @param TreeDictionary[] is
	 *            a The Tree of the Dictionary.
	 */
	public TreeDictionary[] t = new TreeDictionary[8];
	private Set<String> words;

	public TreeDictionary() {
		for (int i = 0; i < t.length; i++) {
			this.t[i] = null;
		}
		this.words = new HashSet();
	}

	public TreeDictionary(String path) {

		for (int i = 0; i < t.length; i++) {
			this.t[i] = new TreeDictionary();
		}
		this.words = new HashSet();
		try {

			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				String line = sc.nextLine().toLowerCase();
				if (PredictivePrototype.isValidWord(line) == true) {
					String s = PredictivePrototype.wordToSignature(line);
					int a = Integer.parseInt(s.substring(0, 1));
					this.t[a - 2].addTree(line, s, 1);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * build a Tree
	 */
	public void addTree(String word, String signature, int letter) {
		this.words.add(word);
		if (letter < signature.length()) {
			int a = Integer.parseInt(signature.substring(letter, letter + 1));
			letter++;
			if (this.t[a - 2] == null) {
				this.t[a - 2] = new TreeDictionary();
			}
			this.t[a - 2].addTree(word, signature, letter);
		}
	}
	/**
	 * re-written as an instance method in the TreeDictionary class to use the dictionary.
	 * @return c
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		int b = signature.length();
		Set<String> c = new HashSet<>();
		signatureToWordsHelper(signature).forEach(word -> c.add(word.substring(0, b)));
		return c;

	}
	/**
	 * signatureToWordsHelper is the method to help signatureToWords
	 */
	public Set<String> signatureToWordsHelper(String signature) {
		if (signature.isEmpty()) {
			return words;
		} else {
			int index = Integer.parseInt(signature.substring(0, 1));
			return t[index - 2].signatureToWordsHelper(signature.substring(1));
		}
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeDictionary td;
		// td = new TreeDictionary("/usr/share/dict/words");
		td = new TreeDictionary("words");

		Set<String> expected = new TreeSet<String>();
		expected = td.signatureToWords("999");
		System.out.println(expected);
		expected = td.signatureToWords("22");
		System.out.println(expected);
		expected = td.signatureToWords("4663");
		System.out.println(expected);
	}*/

}
