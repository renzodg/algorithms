package examples.kadane;

public class Solution {
    
    public static void main(String[] args) {
        int result = maxSumSubstring(new int[] {-2, 3, 2, -1, 7});
        System.out.println(result);
    }
    
    public static int maxSumSubstring(int[] array) {
        int maxCurrent = array[0];
        int maxGlobal =  array[0];
        
        for (int i = 1; i < array.length; i++) {
            maxCurrent = Math.max(array[i], maxCurrent + array[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        
        return maxGlobal;
    }
}
