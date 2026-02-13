/**
 * Q6. Implement Merge Sort
 * 
 * Problem:
 * Implement Merge Sort to sort an array.
 * 
 * Example:
 * Input: [5, 2, 4, 1]
 * Output: [1, 2, 4, 5]
 * 
 * Focus:
 * - Divide array into halves
 * - Recursion
 * - Time Complexity: O(n log n)
 * - Space Complexity: O(n)
 * 
 * Hint: Divide the array into two halves, recursively sort each half, then merge them.
 */
import java.util.Arrays;

public class P06_MergeSort {

    /**
     * TODO: Implement this method
     * Sort an array using Merge Sort algorithm
     * 
     * @param arr - array to sort
     * @param left - starting index
     * @param right - ending index
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // YOUR CODE HERE
    }

    /**
     * TODO: Implement this helper method
     * Merge two sorted halves of the array
     * 
     * @param arr - array containing both halves
     * @param left - start of left half
     * @param mid - end of left half / start of right half
     * @param right - end of right half
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // YOUR CODE HERE
    }

    public static void main(String[] args) {
        System.out.println("=== Implement Merge Sort ===\n");

        // Test Case 1: Example from problem
        int[] test1 = {5, 2, 4, 1};
        System.out.println("Test 1: " + Arrays.toString(test1));
        mergeSort(test1, 0, test1.length - 1);
        System.out.println("Expected: [1, 2, 4, 5]");
        System.out.println("Your Output: " + Arrays.toString(test1));
        System.out.println();

        // Test Case 2: Already sorted
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + Arrays.toString(test2));
        mergeSort(test2, 0, test2.length - 1);
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Your Output: " + Arrays.toString(test2));
        System.out.println();

        // Test Case 3: Reverse sorted
        int[] test3 = {5, 4, 3, 2, 1};
        System.out.println("Test 3: " + Arrays.toString(test3));
        mergeSort(test3, 0, test3.length - 1);
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Your Output: " + Arrays.toString(test3));
        System.out.println();

        // Test Case 4: Duplicates
        int[] test4 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Test 4: " + Arrays.toString(test4));
        mergeSort(test4, 0, test4.length - 1);
        System.out.println("Expected: [1, 1, 2, 3, 4, 5, 6, 9]");
        System.out.println("Your Output: " + Arrays.toString(test4));
        System.out.println();

        // Test Case 5: Single element
        int[] test5 = {42};
        System.out.println("Test 5: " + Arrays.toString(test5));
        mergeSort(test5, 0, test5.length - 1);
        System.out.println("Expected: [42]");
        System.out.println("Your Output: " + Arrays.toString(test5));
        System.out.println();

        // Test Case 6: Negative numbers
        int[] test6 = {-5, 10, -3, 0, 7, -1};
        System.out.println("Test 6: " + Arrays.toString(test6));
        mergeSort(test6, 0, test6.length - 1);
        System.out.println("Expected: [-5, -3, -1, 0, 7, 10]");
        System.out.println("Your Output: " + Arrays.toString(test6));
    }
}
