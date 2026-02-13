/**
 * Q5. Merge Two Sorted Arrays
 * 
 * Problem:
 * Write a function to merge two sorted arrays into one sorted array.
 * 
 * Example:
 * Input: [1, 3, 5] and [2, 4, 6]
 * Output: [1, 2, 3, 4, 5, 6]
 * 
 * Focus:
 * - Two pointer technique
 * - Stability of Merge Sort
 * - O(n) merging logic
 * 
 * Hint: Use two pointers, one for each array. Compare elements and pick the smaller one.
 */
import java.util.Arrays;

public class P05_MergeSortedArrays {

    /**
     * TODO: Implement this method
     * Merge two sorted arrays into one sorted array
     * 
     * @param arr1 - first sorted array
     * @param arr2 - second sorted array
     * @return merged sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // YOUR CODE HERE
        return new int[0]; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Merge Two Sorted Arrays ===\n");

        // Test Case 1: Example from problem
        int[] test1a = {1, 3, 5};
        int[] test1b = {2, 4, 6};
        System.out.println("Test 1: [1, 3, 5] and [2, 4, 6]");
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]");
        System.out.println("Your Output: " + Arrays.toString(mergeSortedArrays(test1a, test1b)));
        System.out.println();

        // Test Case 2: Different sizes
        int[] test2a = {1, 2, 3};
        int[] test2b = {4, 5};
        System.out.println("Test 2: [1, 2, 3] and [4, 5]");
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Your Output: " + Arrays.toString(mergeSortedArrays(test2a, test2b)));
        System.out.println();

        // Test Case 3: One empty array
        int[] test3a = {1, 2, 3};
        int[] test3b = {};
        System.out.println("Test 3: [1, 2, 3] and []");
        System.out.println("Expected: [1, 2, 3]");
        System.out.println("Your Output: " + Arrays.toString(mergeSortedArrays(test3a, test3b)));
        System.out.println();

        // Test Case 4: Both empty
        int[] test4a = {};
        int[] test4b = {};
        System.out.println("Test 4: [] and []");
        System.out.println("Expected: []");
        System.out.println("Your Output: " + Arrays.toString(mergeSortedArrays(test4a, test4b)));
        System.out.println();

        // Test Case 5: Overlapping values
        int[] test5a = {1, 3, 5, 7};
        int[] test5b = {2, 3, 4, 8};
        System.out.println("Test 5: [1, 3, 5, 7] and [2, 3, 4, 8]");
        System.out.println("Expected: [1, 2, 3, 3, 4, 5, 7, 8]");
        System.out.println("Your Output: " + Arrays.toString(mergeSortedArrays(test5a, test5b)));
        System.out.println();

        // Test Case 6: Negative numbers
        int[] test6a = {-5, -1, 0};
        int[] test6b = {-3, 2, 4};
        System.out.println("Test 6: [-5, -1, 0] and [-3, 2, 4]");
        System.out.println("Expected: [-5, -3, -1, 0, 2, 4]");
        System.out.println("Your Output: " + Arrays.toString(mergeSortedArrays(test6a, test6b)));
    }
}
