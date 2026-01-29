/**
 * Problem 4: Warehouse Rearrangement (Reverse Array)
 * 
 * A warehouse stores packages in a straight line. Due to a conveyor belt issue, the order of
 * packages must be completely reversed using an automated robot.
 * 
 * The robot swaps the first and last package, then calls itself to rearrange the remaining middle
 * section.
 * 
 * Task: Use recursion to reverse the array of package IDs.
 */
import java.util.Arrays;

public class Q04_ReverseArray {

    /**
     * TODO: Implement this method
     * Reverse the array in-place using recursion
     * 
     * @param arr - array of package IDs
     * @param left - left index (start)
     * @param right - right index (end)
     */
    public static void reverseArray(int[] arr, int left, int right) {
        // YOUR CODE HERE
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Rearrangement (Reverse Array) ===\n");

        // Test Case 1: Normal array
        int[] test1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: Original = {1, 2, 3, 4, 5}");
        System.out.println("Expected: [5, 4, 3, 2, 1]");
        reverseArray(test1, 0, test1.length - 1);
        System.out.println("Your Output: " + Arrays.toString(test1));
        System.out.println();

        // Test Case 2: Even length array
        int[] test2 = {10, 20, 30, 40};
        System.out.println("Test 2: Original = {10, 20, 30, 40}");
        System.out.println("Expected: [40, 30, 20, 10]");
        reverseArray(test2, 0, test2.length - 1);
        System.out.println("Your Output: " + Arrays.toString(test2));
        System.out.println();

        // Test Case 3: Single element
        int[] test3 = {99};
        System.out.println("Test 3: Original = {99}");
        System.out.println("Expected: [99]");
        reverseArray(test3, 0, test3.length - 1);
        System.out.println("Your Output: " + Arrays.toString(test3));
        System.out.println();

        // Test Case 4: Two elements
        int[] test4 = {100, 200};
        System.out.println("Test 4: Original = {100, 200}");
        System.out.println("Expected: [200, 100]");
        reverseArray(test4, 0, test4.length - 1);
        System.out.println("Your Output: " + Arrays.toString(test4));
        System.out.println();

        // Test Case 5: Array with negative numbers
        int[] test5 = {-5, -3, 0, 3, 5};
        System.out.println("Test 5: Original = {-5, -3, 0, 3, 5}");
        System.out.println("Expected: [5, 3, 0, -3, -5]");
        reverseArray(test5, 0, test5.length - 1);
        System.out.println("Your Output: " + Arrays.toString(test5));
        System.out.println();

        // Test Case 6: Package IDs
        int[] test6 = {1001, 1002, 1003, 1004, 1005, 1006};
        System.out.println("Test 6: Original = {1001, 1002, 1003, 1004, 1005, 1006}");
        System.out.println("Expected: [1006, 1005, 1004, 1003, 1002, 1001]");
        reverseArray(test6, 0, test6.length - 1);
        System.out.println("Your Output: " + Arrays.toString(test6));
    }
}
