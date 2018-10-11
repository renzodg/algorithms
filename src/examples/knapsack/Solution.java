package examples.knapsack;

import java.util.HashMap;

public class Solution {
    
    public static void main(String[] args) {
        int capacity = 10;
        int[] weights = { 10, 20, 30, 2, 1 };
        int[] values = { 60, 100, 5, 3, 2 };
       
        int result = maxValueSum(weights, values, capacity);
        System.out.println(result);
    }
    
    public static int maxValueSum(int[] weights, int[] values, int capacity) {
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        int size = weights.length;
        return maxValueSum(weights, values, size - 1, capacity, memo);
    }
    
    private static int maxValueSum(int[] weights, int[] values, int pointer, int capacity, HashMap<String, Integer> memo) {
        Integer result = memo.get(pointer + "-" + capacity);
        
        if (result != null) return result;
        
        if (pointer <= -1 || capacity == 0) {
            return 0;
        } else if (weights[pointer] > capacity) {
            result = maxValueSum(weights, values, pointer - 1, capacity, memo);
        } else {
            int sumIncluding = values[pointer] + maxValueSum(weights, values, pointer - 1, capacity - weights[pointer], memo);
            int sumExcluding = maxValueSum(weights, values, pointer - 1, capacity, memo);
            result = Math.max(sumIncluding, sumExcluding);
        }
        memo.put(pointer + "-" + capacity, result);
        return result;
    }
    
}
