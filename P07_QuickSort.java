/**
 * Q7. Implement Quick Sort
 * 
 * Problem:
 * Implement Quick Sort to sort an array using partition logic.
 * 
 * Example:
 * Input: [10, 7, 8, 9, 1, 5]
 * Output: [1, 5, 7, 8, 9, 10]
 * 
 * Focus:
 * - Pivot selection
 * - Partition algorithm
 * - Average: O(n log n)
 * - Worst Case: O(n²)
 * 
 * Hint: Choose a pivot, partition array so elements < pivot are on left, > pivot on right.
 * Recursively sort left and right partitions.
 */
import java.util.Arrays;

public class P07_QuickSort {

    /**
     * TODO: Implement this method
     * Sort an array using Quick Sort algorithm
     * 
     * @param arr - array to sort
     * @param low - starting index
     * @param high - ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        // YOUR CODE HERE
    }

    /**
     * TODO: Implement this helper method
     * Partition the array around a pivot
     * 
     * @param arr - array to partition
     * @param low - starting index
     * @param high - ending index (pivot location)
     * @return final position of pivot
     */
    public static int partition(int[] arr, int low, int high) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Implement Quick Sort ===\n");

        // Test Case 1: Example from problem
        int[] test1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Test 1: " + Arrays.toString(test1));
        quickSort(test1, 0, test1.length - 1);
        System.out.println("Expected: [1, 5, 7, 8, 9, 10]");
        System.out.println("Your Output: " + Arrays.toString(test1));
        System.out.println();

        // Test Case 2: Already sorted
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + Arrays.toString(test2));
        quickSort(test2, 0, test2.length - 1);
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Your Output: " + Arrays.toString(test2));
        System.out.println();

        // Test Case 3: Reverse sorted
        int[] test3 = {5, 4, 3, 2, 1};
        System.out.println("Test 3: " + Arrays.toString(test3));
        quickSort(test3, 0, test3.length - 1);
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Your Output: " + Arrays.toString(test3));
        System.out.println();

        // Test Case 4: Duplicates
        int[] test4 = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.println("Test 4: " + Arrays.toString(test4));
        quickSort(test4, 0, test4.length - 1);
        System.out.println("Expected: [1, 1, 2, 3, 4, 5, 5, 6, 9]");
        System.out.println("Your Output: " + Arrays.toString(test4));
        System.out.println();

        // Test Case 5: Single element
        int[] test5 = {42};
        System.out.println("Test 5: " + Arrays.toString(test5));
        quickSort(test5, 0, test5.length - 1);
        System.out.println("Expected: [42]");
        System.out.println("Your Output: " + Arrays.toString(test5));
        System.out.println();

        // Test Case 6: Negative numbers
        int[] test6 = {-5, 10, -3, 0, 7, -1};
        System.out.println("Test 6: " + Arrays.toString(test6));
        quickSort(test6, 0, test6.length - 1);
        System.out.println("Expected: [-5, -3, -1, 0, 7, 10]");
        System.out.println("Your Output: " + Arrays.toString(test6));
    }
}
