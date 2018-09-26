import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**

 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Fritz Thelusca ft34
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram a k-gram of strings/words
	 * @param source array that is passed through WordGram
	 * @param start starting index of arrat
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int l=0; l<size; l++) {
		myWords[l]=source[start+l]; }
		// TODO: initialize myWords and ...
		myToString=null;
		 myHash=0 ;
			
		}
	

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * return the length of the myWords array
	 * @return length the size of the myWords array
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}
	/**
	 * Check to see the parameter has the same number of string and words the object
	 * @param last is last String of returned WordGram
	 * @return boolean check to determine if wg satisfies the conditions
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
	    // TODO: complete this method
		WordGram wg = (WordGram) o;
		if ( wg.length() != this.length()) {
			return false;}
		for(int j=0; j<this.length(); j++) {
		if (!(this.wordAt(j).equals(wg.wordAt(j)))) {
			return false; 
		}
		}
		return true;
	}
	/**
	 * Generates the hash code for the string
	 * @param the object that is passed through this method
	 * @return Hash code for the string
	 */
	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash ==  0) {		
			myHash = this.toString().hashCode() ;
		}		
		return myHash;
	}
	

	/**
	 * Removes the first string of wg and adds the last string to wg
	 * @param last is last String of returned WordGram
	 * @return altered wg array where each string is shifted forward by one and an insertion of the last String
	 */
	

	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for(int k=0; k< wg.myWords.length -1;k++ ) {
			wg.myWords[k]=wg.myWords[k+1]; }
		wg.myWords[wg.myWords.length -1]= last ;
		return wg;
	}

	/**
	 * Joins the elements in the WordGram object into a single string
	 * @param last is last String of returned WordGram
	 * @return  the conjoined string
	 */
	@Override
	public String toString(){
		// TODO: Complete this method	
		 String message = String.join(" ", myWords);
		return message;
	}
}
