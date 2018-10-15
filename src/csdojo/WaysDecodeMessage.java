package csdojo;

import java.util.HashMap;

public class WaysDecodeMessage {

    public static void main(String[] args) {
        int result = getNumDays("123");  // 'a' + getNumDays("23") or
                                        // 'l + getNumDays("3")
        System.out.println(result);
    }

    private static int getNumDays(String data) {
        return getNumDays(data, data.length(), new HashMap<Integer, Integer>());
    }

    private static int getNumDays(String data, int k, HashMap<Integer, Integer> memo) {
        if (k == 0) {
            return 1;
        }
        
        int s = data.length() - k;
        if (data.charAt(s) < 'a' && data.charAt(s) > 'z')
            return 0;
        
        
        Integer result = memo.get(k); 
        if (result != null)
            return result;
        
                
        result = getNumDays(data, k-1, memo);
        
        if (k >= 2 && Integer.parseInt(data.substring(s, s + 2)) <= 26) {
            result += getNumDays(data, k - 2, memo);
        }
        
        memo.put(k, result);
        
        return result;
    }

}