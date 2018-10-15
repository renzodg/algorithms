package csdojo;

import java.util.Arrays;
import java.util.HashMap;

public class StaircaseProblem {

    public static void main(String[] args) {
        int result = getNumWaysBottomUp(3, new int[] { 1, 3, 5 });
        System.out.println(result);
    }

    public static int getNumWays(int staircaseSize, int[] possibleSteps) {
        return getNumWays(staircaseSize, possibleSteps, new HashMap<>());
    }

    public static int getNumWays(int staircaseSize, int[] possibleSteps, HashMap<Integer, Integer> memo) {
        if (staircaseSize == 0)
            return 1;

        if (memo.containsKey(staircaseSize))
            return memo.get(staircaseSize);

        int total = 0;

        for (int i : possibleSteps) {
            if (staircaseSize - i >= 0) {
                total += getNumWays(staircaseSize - i, possibleSteps, memo);
            }
        }

        memo.put(staircaseSize, total);

        return total;

    }

    public static int getNumWaysBottomUp(int staircaseSize, int[] possibleSteps) {
        if (staircaseSize == 0)
            return 1;

        int[] nums = new int[staircaseSize + 1];
        nums[0] = 1;

        for (int i = 1; i <= staircaseSize; i++) {
            int total = 0;
            for (int j : possibleSteps) {
                if (i - j >= 0) {
                    total += nums[i - j];
                }
            }
            nums[i] = total;
        }

        System.out.println(Arrays.toString(nums));
        return nums[staircaseSize];
    }
}