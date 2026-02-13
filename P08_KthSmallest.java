/**
 * Q8. Kth Smallest Element using Quick Sort Partition
 * 
 * Problem:
 * Find the kth smallest element in an array using Quick Select (partition logic).
 * 
 * Example:
 * Input: [7, 10, 4, 3, 20, 15], k = 3
 * Output: 7
 * 
 * Focus:
 * - Partition logic reuse
 * - Quick Select
 * - Average O(n)
 * 
 * Hint: Use partition to place pivot in correct position. If pivot position == k-1, found!
 * Otherwise, recurse on left or right partition based on comparison with k.
 */
import java.util.Arrays;

public class P08_KthSmallest {

    /**
     * TODO: Implement this method
     * Find the kth smallest element using Quick Select
     * 
     * @param arr - input array
     * @param k - find kth smallest (1-indexed)
     * @return kth smallest element
     */
    public static int findKthSmallest(int[] arr, int k) {
        // YOUR CODE HERE
        return quickSelect(arr, 0, arr.length - 1, k - 1); // Convert to 0-indexed
    }

    /**
     * TODO: Implement this helper method
     * Quick Select algorithm
     * 
     * @param arr - array
     * @param low - start index
     * @param high - end index
     * @param k - target index (0-indexed)
     * @return kth smallest element
     */
    private static int quickSelect(int[] arr, int low, int high, int k) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    /**
     * TODO: Implement partition method (same as QuickSort)
     */
    private static int partition(int[] arr, int low, int high) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Kth Smallest Element using Quick Select ===\n");

        // Test Case 1: Example from problem
        int[] test1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test 1: " + Arrays.toString(test1) + ", k = " + k1);
        System.out.println("Expected: 7 (3rd smallest)");
        System.out.println("Your Output: " + findKthSmallest(test1.clone(), k1));
        System.out.println();

        // Test Case 2: Find minimum
        int[] test2 = {5, 3, 8, 1, 9};
        int k2 = 1;
        System.out.println("Test 2: " + Arrays.toString(test2) + ", k = " + k2);
        System.out.println("Expected: 1 (minimum)");
        System.out.println("Your Output: " + findKthSmallest(test2.clone(), k2));
        System.out.println();

        // Test Case 3: Find maximum
        int[] test3 = {5, 3, 8, 1, 9};
        int k3 = 5;
        System.out.println("Test 3: " + Arrays.toString(test3) + ", k = " + k3);
        System.out.println("Expected: 9 (maximum)");
        System.out.println("Your Output: " + findKthSmallest(test3.clone(), k3));
        System.out.println();

        // Test Case 4: Find median
        int[] test4 = {12, 3, 5, 7, 19};
        int k4 = 3;
        System.out.println("Test 4: " + Arrays.toString(test4) + ", k = " + k4);
        System.out.println("Expected: 7 (median)");
        System.out.println("Your Output: " + findKthSmallest(test4.clone(), k4));
        System.out.println();

        // Test Case 5: Duplicates
        int[] test5 = {4, 2, 7, 2, 9, 4};
        int k5 = 4;
        System.out.println("Test 5: " + Arrays.toString(test5) + ", k = " + k5);
        System.out.println("Expected: 4 (4th smallest)");
        System.out.println("Your Output: " + findKthSmallest(test5.clone(), k5));
        System.out.println();

        // Test Case 6: Negative numbers
        int[] test6 = {-5, 10, -3, 0, 7};
        int k6 = 2;
        System.out.println("Test 6: " + Arrays.toString(test6) + ", k = " + k6);
        System.out.println("Expected: -3 (2nd smallest)");
        System.out.println("Your Output: " + findKthSmallest(test6.clone(), k6));
    }
}
