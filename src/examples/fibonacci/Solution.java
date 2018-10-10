package examples.fibonacci;

import java.math.BigInteger;

public class Solution {

	public static BigInteger getFibonacciNumber(int n) {
		if (n == 1 || n == 2) {
			return new BigInteger("1");
		}
		
		BigInteger[] bottomUp = new BigInteger[2];
		bottomUp[0] = new BigInteger("1");
		bottomUp[1] = new BigInteger("1");
		for (int i = 3; i < n + 1; i++) {
		    BigInteger temp = bottomUp[1];
			bottomUp[1] = bottomUp[0].add(bottomUp[1]);
			bottomUp[0] = temp;
		}
		
		return bottomUp[1];
	}
	
	public static void main(String[] args) {
		BigInteger result = getFibonacciNumber(1000000);
		System.out.println(result);
	}
}
