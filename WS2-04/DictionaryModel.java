
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class DictionaryModel extends Observable implements DictionaryModelInterface {
	
	/**
	 * Constructor for building DictionaryModel.
	 *            
	 */
	private TreeDictionary treeDictionary;
    private Iterator<String> iterator;
  
    private String currentWord, lastEnteredWord;
    private StringBuffer buildWord;
    private StringBuilder sentence;
	public DictionaryModel(String dictionaryFile) throws java.io.IOException{
		 this.currentWord = "";
         this.treeDictionary = new TreeDictionary(dictionaryFile);        
         this.sentence = new StringBuilder(); 
         this.buildWord = new StringBuffer();
         this.lastEnteredWord = "";
	}
	public DictionaryModel() throws java.io.IOException{
		
		this.currentWord = "";
        this.treeDictionary = new TreeDictionary("C:/Users/user/eclipse-workspace/WS2-3/bin/words");//("/usr/share/dict/words");         
        //this.treeDictionary = new TreeDictionary("words");
        this.sentence = new StringBuilder();
        this.buildWord = new StringBuffer();
        this.lastEnteredWord = "";
		
	}
	/**
	 * Returns a list of the words typed in so far, including
	 * the last word (or prex) which has not yet been accepted.
	 * @return local
	 */
	@Override
	public List<String> getMessage() {
		ArrayList local = new ArrayList();
		String data = this.sentence.toString();
		String[] a = data.split("\n");
		for( int i = 0; i < a.length ; i++) {
			local.add(a[i]);
		}
		local.add(this.currentWord);
		return local;
	}
	/**
	 * Adds a numeric key that has been typed in by the user.
	 */
	@Override
	public void addCharacter(char key) {
				
		this.buildWord.append(key);
	    this.iterator = treeDictionary.signatureToWords(this.buildWord.toString()).iterator();
	    this.currentWord = this.iterator.next();
	    setChanged();
	    notifyObservers(this.sentence + this.currentWord);
		
	}
	/**
	 * Removes the last character typed in. This should 
	 * remove the last character from the current match, but it would in general enlarge the 
	 * possible matches for the current word.
	 */
	@Override
	public void removeLastCharacter() {
		if (currentWord != null && currentWord.length() >= 1) {
            currentWord = currentWord.substring(0, currentWord.length() - 1);
            this.iterator = this.treeDictionary.signatureToWords(PredictivePrototype.wordToSignature(this.currentWord)).iterator();
            if (currentWord.length() <= 0) {
                this.buildWord = new StringBuffer();
                this.currentWord = "";
                this.lastEnteredWord = "";
                this.iterator = new Iterator<String>() {
                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public String next() {
                        return null;
                    }
                };
            }
        } else {
        }
        setChanged();
        notifyObservers(this.sentence + this.currentWord);	
		
	}
	/**
	 * re-written as an instance method in the TreeDictionary class to use the dictionary.
	 * @return c
	 */
	@Override
	public void nextMatch() {
		if(this.iterator.hasNext()) {
			this.currentWord = this.iterator.next();
			this.lastEnteredWord = this.currentWord;
		}else {
            this.iterator = this.treeDictionary.signatureToWords
            		(PredictivePrototype.wordToSignature(this.lastEnteredWord)).iterator();
            this.currentWord = this.iterator.next(); 
        }
		 setChanged();
	     notifyObservers(this.sentence + this.currentWord);
	}
	
	/**
	 * Cycles through the possible matches for the current word
	 */
	@Override
	public void acceptWord() {
		this.buildWord = new StringBuffer();
        this.sentence.append(currentWord);
        this.sentence.append(" ");
        this.currentWord = "";
        this.lastEnteredWord = "";
        this.iterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };
       
        setChanged();
        notifyObservers(this.sentence);	
	}


}
