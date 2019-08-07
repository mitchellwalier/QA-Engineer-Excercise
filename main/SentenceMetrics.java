package main;

import java.util.ArrayList;

/* CLASS ASSUMPTIONS :
 * Special characters aren't counted
 * Class shouldn't worry about grammar, spelling or sentence structure 
 * Class shouldn't worry about multiple sentences being in the same string */

/* Sentence Metrics is expected to receive a sentence and return metrics related to it */
public class SentenceMetrics {
	private String sentence;
	private ArrayList<String> longestWords;
	private int lens;
	
	public SentenceMetrics(String sen) {
		this.sentence = sen;
		this.longestWords = new ArrayList<>();
		this.lens = 0;
		
		if (sen != null) {
			sen = sen.trim();
			if (sen.equals("")) {	
				// a string with only spaces was provided
				this.lens = 0;
			} else {
				// remove all special characters
				sen = sen.replaceAll("[^a-zA-Z0-9\\s]", "");
				
				String[] words = sen.split(" ");
				setClassVariables(words);
			}
		} 
		

	}
	
	public int getLength() {
		return this.lens;
	}
	
	public ArrayList<String> getLongestWord() {
		return this.longestWords;
	}
	
	public String getSentence() {
		return this.sentence;
	}
	
	private void setClassVariables(String[] words) {
		// O(n) execution
		for (String word : words) {
			int wordCount = word.length();

			/* ASSUMPTION : If-Else-If statement should reduce the number of checks slightly. 
			 * Better than having two different if statements */
        	if (wordCount > this.lens) {
        		
        		// reset longest word metrics
        		this.lens = wordCount;
        		this.longestWords = new ArrayList<>();
        		this.longestWords.add(word);
        		
        	} else if (wordCount == this.lens) {
        		 
        		// Multiple words with same length
        		this.longestWords.add(word);
        		
        	} else {
        		// Nothing : word count is less then the longest        		
        	}  
		}	
	}

}
