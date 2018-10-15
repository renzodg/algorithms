package examples.recursive_staircase;

public class Solution {

    public static void main(String[] args) {
        // int result1 = countPathsWithoutMemo(35);
        int result2 = countPathsUsingMemo(35);
        int result3 = countPathsUsingDP(4);
        System.out.println(result3);
    }

    public static int countPathsWithoutMemo(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        return countPathsWithoutMemo(steps - 1) + countPathsWithoutMemo(steps - 2) + countPathsWithoutMemo(steps - 3);
    }

    public static int countPathsUsingMemo(int steps) {
        return countPathsUsingMemo(steps, new int[steps + 1]);
    }

    public static int countPathsUsingMemo(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        if (memo[steps] == 0) {
            memo[steps] = countPathsUsingMemo(steps - 1, memo) + countPathsUsingMemo(steps - 2, memo)
                    + countPathsUsingMemo(steps - 3, memo);
        }

        return memo[steps];
    }

    public static int countPathsUsingDP(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps <= 1) {
            return 1;
        }

        int[] paths = new int[steps + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;

        for (int i = 3; i <= steps; i++) {
            paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
        }

        return paths[steps];
    }

    public static int countPathsUsingIterative(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps <= 1) {
            return 1;
        }

        int[] paths = { 1, 1, 2 };

        for (int i = 3; i <= steps; i++) {
            int count = paths[2] + paths[1] + paths[0];
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = count;
        }

        return paths[steps];
    }
}
