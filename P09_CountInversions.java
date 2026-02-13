/**
 * Q9. Count Inversions in an Array
 * 
 * Problem:
 * Count the number of inversions in an array.
 * An inversion is a pair (i, j) where i < j but arr[i] > arr[j].
 * 
 * Example:
 * Input: [2, 4, 1, 3, 5]
 * Output: 3
 * Inversions: (2,1), (4,1), (4,3)
 * 
 * Focus:
 * - Modified merge step
 * - Counting during merge
 * - O(n log n) solution
 * 
 * Hint: Use merge sort logic. While merging, if element from right half is smaller,
 * count all remaining elements in left half as inversions.
 */
import java.util.Arrays;

public class P09_CountInversions {

    /**
     * TODO: Implement this method
     * Count inversions in the array using modified merge sort
     * 
     * @param arr - input array
     * @return count of inversions
     */
    public static int countInversions(int[] arr) {
        // YOUR CODE HERE
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    /**
     * TODO: Implement this helper method
     * Merge sort that also counts inversions
     * 
     * @param arr - array
     * @param left - start index
     * @param right - end index
     * @return count of inversions
     */
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    /**
     * TODO: Implement this helper method
     * Merge two sorted halves and count inversions
     * 
     * @param arr - array
     * @param left - start of left half
     * @param mid - end of left half
     * @param right - end of right half
     * @return count of inversions during merge
     */
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Count Inversions in an Array ===\n");

        // Test Case 1: Example from problem
        int[] test1 = {2, 4, 1, 3, 5};
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Expected: 3 [(2,1), (4,1), (4,3)]");
        System.out.println("Your Output: " + countInversions(test1.clone()));
        System.out.println();

        // Test Case 2: Already sorted (no inversions)
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Expected: 0 (already sorted)");
        System.out.println("Your Output: " + countInversions(test2.clone()));
        System.out.println();

        // Test Case 3: Reverse sorted (maximum inversions)
        int[] test3 = {5, 4, 3, 2, 1};
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Expected: 10 (n*(n-1)/2 = 5*4/2)");
        System.out.println("Your Output: " + countInversions(test3.clone()));
        System.out.println();

        // Test Case 4: Simple case
        int[] test4 = {2, 1};
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Expected: 1 [(2,1)]");
        System.out.println("Your Output: " + countInversions(test4.clone()));
        System.out.println();

        // Test Case 5: No inversions
        int[] test5 = {1, 3, 5, 7, 9};
        System.out.println("Test 5: " + Arrays.toString(test5));
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + countInversions(test5.clone()));
        System.out.println();

        // Test Case 6: Duplicates
        int[] test6 = {3, 1, 2, 1};
        System.out.println("Test 6: " + Arrays.toString(test6));
        System.out.println("Expected: 4 [(3,1), (3,2), (3,1), (2,1)]");
        System.out.println("Your Output: " + countInversions(test6.clone()));
    }
}
