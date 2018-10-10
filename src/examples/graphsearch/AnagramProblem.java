package examples.graphsearch;

public class AnagramProblem {

	private static int NUMBER_LETTERS = 26;
	
	/*
	 * Given two strings (lowercase a->z), how many characters do we need to remove (from either)
	 * to make them anagrams?
	 * EXAMPLE: hello, billion --> ANSWER: 6 (he from hello and biin from billion)
	 */
	public static void main(String[] args) {
		int result = AnagramProblem.numberNeeded("hello", "billion");
		System.out.println(result);
	}
	
	public static int getDelta(int[] charCounts1, int[] charCounts2) {
		if (charCounts1.length != charCounts2.length) {
			return -1; // TODO: better error handling
		}
		
		int delta = 0;
		
		for (int i = 0; i < charCounts1.length; i++) {
			int difference = Math.abs(charCounts1[i] - charCounts2[i]);
			delta += difference;
		}
		
		return delta;
	}
	
	public static int[] getCharCounts(String s) {
		int[] charCounts = new int[NUMBER_LETTERS];
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int offset = (int) 'a';
			int code = (int) c - offset;
			charCounts[code]++;
		}
		
		return charCounts;
	}
	
	public static int numberNeeded(String first, String second) {
		int [] charCounts1 = getCharCounts(first);
		int [] charCounts2 = getCharCounts(second);
		
		return getDelta(charCounts1, charCounts2);
	}
	
}
