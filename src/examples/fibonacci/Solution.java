package examples.fibonacci;

import java.math.BigInteger;

public class Solution {

	public static BigInteger getFibonacciNumber(int n) {
		if (n == 1 || n == 2) {
			return new BigInteger("1");
		}
		
		BigInteger[] bottomUp = new BigInteger[n + 1];
		bottomUp[1] = new BigInteger("1");
		bottomUp[2] = new BigInteger("1");
		for (int i = 3; i < n + 1; i++) {
			bottomUp[i] = bottomUp[i-1].add(bottomUp[i-2]);
		}
		
		return bottomUp[n];
	}
	
	public static void main(String[] args) {
		BigInteger result = getFibonacciNumber(10000);
		System.out.println(result);
	}
}
