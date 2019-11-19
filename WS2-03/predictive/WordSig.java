package predictive;

public class WordSig implements Comparable<WordSig>{
	
		/**
	     *  Constructor for WordSig setting the two field variables.
	     *  @param words The words of the word and the signature.
	     *  @param signature The words of the signature.
	     */	
		private String words;
		private String signature;
		public WordSig(String words, String signature) {
			this.words = words;
			this.signature = signature;
		}

	    /**
	     *  Getter for the Words of words
	     *  @return The Words of the words. 
	     */
		public String getWords(){
			return words;
		}
		/**
	     *  Getter for the Words of signature
	     *  @return The Words of the signature. 
	     */
		public String getSignature(){
			return signature;
		}
		public String toString(){
			return words +": "+ signature + "\n";
		}
		//@Override
		public int compareTo(WordSig ws) {
			if(this.signature.compareTo(ws.signature) > 0) {
				return 1;
			}else if(this.signature.compareTo(ws.signature) < 0) {
				return -1;
			}else {
				return 0;
			}
		}
		

}
