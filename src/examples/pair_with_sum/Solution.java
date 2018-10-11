package examples.pair_with_sum;

import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {
		int[] array = {1, 2, 4 ,9};
		boolean result = hasPairWithSum(array, 8);
		System.out.println(result);
	}

	public static boolean hasPairWithSum(int[] array , int sum) {
		HashSet<Integer> complements = new HashSet<Integer>();
		
		for (int number : array) {
			if(complements.contains(number)) {
				return true;
			}
			
			complements.add(sum - number);
		}
		
		return false;
	}

}
