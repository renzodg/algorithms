package examples.longest_common_subsequence;

import java.util.Arrays;

public class Solution {
    
    public static void main(String[] args) {
        int result = getLongestCommonSubsequence("CBAD", "BATD");
        System.out.println(result);
    }
    
    public static int getLongestCommonSubsequence(String a, String b) {
        int[][] memo = new int[a.length() + 1][b.length() + 1];
        
        for (int[] row: memo)
            Arrays.fill(row, -1);
        
        return getLongestCommonSubsequence(a, b, a.length(), b.length(), memo);
    }
    
    private static int getLongestCommonSubsequence(String a, String b, int n, int m, int[][] memo) {
        if (memo[n][m] != -1) {
            return memo[n][m];
        }
        
        int result = 0;
        if (n == 0 || m == 0) {
            result = 0;
        } else if (a.charAt(n-1) == b.charAt(m-1)) {
            result = 1 + getLongestCommonSubsequence(a, b, n-1, m-1, memo);
        } else if (a.charAt(n-1) != b.charAt(m-1)) {
            int tmp1 = getLongestCommonSubsequence(a, b, n-1, m, memo);
            int tmp2 = getLongestCommonSubsequence(a, b, n, m-1, memo);
            result = Math.max(tmp1, tmp2);
        }
        memo[n][m] = result;
        return result;
    }

}
