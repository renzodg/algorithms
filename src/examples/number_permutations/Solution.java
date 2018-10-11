package examples.number_permutations;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		String s = "abcb";
		String b = "babcabbacaabcbabcacbb123213213213213213213213213kjgsjdgsahdgsajdgsahdg127832362173821yt3u12dg3yu21d3j21hvgd3jk21h3gd21iuk3dy129fn";
		int result = getNumberPermutations(s, b);
		System.out.println(result);
	}

	private static int getNumberPermutations(String s, String b) {
		int index = 0;
		int count = 0;
		int size = s.length();
		char[] charArrayToBeTested = s.toCharArray();
		Arrays.sort(charArrayToBeTested);
		while(index <= b.length() - 4) {
			String possiblePermutation = b.substring(index, index + size);
			count += isPermutation(charArrayToBeTested, possiblePermutation.toCharArray()) ? 1 : 0;
			index++;
		}
		
		return count;
	}

	private static boolean isPermutation(char[] a, char[] b) {
		Arrays.sort(b);
		return Arrays.equals(a, b);
	}

}
