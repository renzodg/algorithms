package examples.counting_sort;

import java.util.Arrays;

public class Solution {

    public static void main(String args[]) {
        int array[] = { 53, 89, 150, 36, 633, 233 };

        sort(array);

        System.out.print("Sorted character array is: " + Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int fixedPossibleNumber = 999;
        int size = array.length;

        // The output character array that will have sorted array
        int sortedArray[] = new int[size];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int counts[] = new int[fixedPossibleNumber];
        Arrays.fill(counts, 0);

        // store count of each character
        for (int i = 0; i < size; i++)
            counts[array[i]]++;

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = size - 1; i >= 0; i--) {
            int value = array[i];
            int index = counts[value] - 1;
            
            sortedArray[index] = value;
            counts[value]--;
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    public static void sort2(int[] array) {
        int size = array.length;

        int sortedArray[] = new int[size];

        int counts[] = new int[4];
        Arrays.fill(counts, 0);

        for (int i = 0; i < size; i++)
            counts[array[i]]++;

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            
            while (count-- > 0) {
                sortedArray[index] = i;
                index++;
            }
            
        }

        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }
}
