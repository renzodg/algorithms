package examples.randomly_reorder_array;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] array = { 1, 0, 3, 9, 2 };
        reOrder(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reOrder(int[] array) {
        int size = array.length;

        for (int i = size - 1; i > 0; i--) {
            int pick = (int) Math.floor((i + 1) * Math.random());
            int temp = array[i];
            array[i] = array[pick];
            array[pick] = temp;
        }
    }

}
