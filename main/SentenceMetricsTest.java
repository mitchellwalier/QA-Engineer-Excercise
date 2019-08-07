package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SentenceMetricsTest {
	SentenceMetrics testObject;
	
	@Test 
	void specificQATest() {
		String sentence = "The cow jumped over the moon.";
		testObject = new SentenceMetrics(sentence); 
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are correct
		String longestWord = "jumped";
		ArrayList<String> results = testObject.getLongestWord();
		assertEquals(results.size(), 1);
		assertEquals(longestWord, results.get(0));
		
		// Confirm longest word length is correct
		assertEquals(testObject.getLength(), longestWord.length());
	}

	@Test
	void oneLongWordTest() {
		String sentence = "The longest word in the world is pneumonoultramicroscopicsilicovocanoconiosis";
		testObject = new SentenceMetrics(sentence); 
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are correct
		String longestWord = "pneumonoultramicroscopicsilicovocanoconiosis";
		ArrayList<String> results = testObject.getLongestWord();
		assertEquals(1, results.size());
		assertEquals(longestWord, results.get(0));
		
		// Confirm longest word length is correct
		assertEquals(longestWord.length(), testObject.getLength());
	}
	
	@Test
	void multiLongWordTest() {
		String sentence = "The two long words are Software and Engineer";
		testObject = new SentenceMetrics(sentence);
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are correct
		ArrayList<String> longestWord = new ArrayList<String>() { 
            { 
                add("Software"); 
                add("Engineer"); 
            } 
        }; 
		ArrayList<String> results = testObject.getLongestWord();
		assertEquals(longestWord.size(),results.size());
		assertEquals(longestWord, results);
		
		// Confirm longest word length is correct
		assertEquals(longestWord.get(0).length(), testObject.getLength());
	}
	
	@Test
	void emptySentenceTest() {
		String sentence = "";
		testObject = new SentenceMetrics(sentence);
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are the same
		ArrayList<String> results = testObject.getLongestWord();
		ArrayList<String> expectedResults = new ArrayList<String>();
		assertEquals(expectedResults, results);
		
		// Confirm longest word length is correct
		assertEquals(0, testObject.getLength());
	}
	
	@Test
	void nullSentenceTest() {
		String sentence = null;
		testObject = new SentenceMetrics(sentence);
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are the same
		ArrayList<String> results = testObject.getLongestWord();
		ArrayList<String> expectedResults = new ArrayList<String>();
		assertEquals(expectedResults, results);
		
		// Confirm longest word length is correct
		assertEquals(0, testObject.getLength());
	}
	
	@Test
	void oneWordTest() {
		String sentence = "Awesome";
		testObject = new SentenceMetrics(sentence);
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are correct
		ArrayList<String> longestWord = new ArrayList<String>() { 
            { 
                add(sentence); 
            } 
        }; 
		ArrayList<String> results = testObject.getLongestWord();
		assertEquals(results.size(), longestWord.size());
		assertEquals(results, longestWord);
		
		// Confirm longest word length is correct
		assertEquals(longestWord.get(0).length(), testObject.getLength());
	}
	
	@Test
	void oneSpaceTest() {
		String sentence = " ";
		testObject = new SentenceMetrics(sentence);
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are the same
		ArrayList<String> results = testObject.getLongestWord();
		ArrayList<String> expectedResults = new ArrayList<String>();
		assertEquals(expectedResults, results);
		
		// Confirm longest word length is correct
		assertEquals(0, testObject.getLength());
	}
	
	@Test
	void multiSpaceTest() {
		String sentence = "           ";
		testObject = new SentenceMetrics(sentence);
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are the same
		ArrayList<String> results = testObject.getLongestWord();
		ArrayList<String> expectedResults = new ArrayList<String>();
		assertEquals(expectedResults, results);
		
		// Confirm longest word length is correct
		assertEquals(0, testObject.getLength());
	}
	
	@Test 
	void specialCharactersTest() {
		String sentence = "The cow jumped over the moon...........";
		testObject = new SentenceMetrics(sentence); 
		
		// Confirm returns the sentence
		assertEquals(sentence, testObject.getSentence());
		
		// Confirm longest words are correct
		String longestWord = "jumped";
		ArrayList<String> results = testObject.getLongestWord();
		assertEquals(1, results.size());
		assertEquals(longestWord, results.get(0));
		
		// Confirm longest word length is correct
		assertEquals(longestWord.length(), testObject.getLength());
	}
	
	// Implementation should be reasonably quick. Inconsistency in execution time should never result in a half second result
	@Test
	void speedTest() {
		String sentence = "The longest word in the world is pneumonoultramicroscopicsilicovocanoconiosis, which is pretty interesting.";
		
		/* ASSUMPTION : 1000 iterations is a lot */
		int iterations = 10000;
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < iterations; i++) {
			testObject = new SentenceMetrics(sentence);
		}
		long endTime = System.currentTimeMillis();
		
		// Test to be finished in under quarter second
		assertTrue((startTime - endTime) < 500);
	}
	
	

}
