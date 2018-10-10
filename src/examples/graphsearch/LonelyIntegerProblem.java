package examples.graphsearch;

public class LonelyIntegerProblem {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(lonelyInteger(new int[] {9, 1, 2, 3, 2, 9, 1, 7, 7, 3, 3, 3, 21}));
		
		long stopTime = System.currentTimeMillis();
      	System.out.println(stopTime - startTime);
	}
	
	private static int lonelyInteger(int[] array) {
		int result = 0;
		for (int value : array) {
			result ^= value;
		}
		
		return result;
	}
	
}
