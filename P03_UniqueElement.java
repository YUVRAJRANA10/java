/**
 * Q3. Find Unique Element
 * 
 * Problem:
 * In an array where every element appears twice except one, find the unique element.
 * 
 * Example:
 * Input: [4, 1, 2, 1, 2]  → Output: 4
 * 
 * Focus:
 * - XOR properties
 * - a ^ a = 0
 * - O(n) time, O(1) space
 * 
 * Hint: XOR of two same numbers is 0. XOR of a number with 0 is the number itself.
 * XOR all elements together - duplicates cancel out, leaving only the unique element.
 */
public class P03_UniqueElement {

    /**
     * TODO: Implement this method
     * Find the unique element in an array where every other element appears twice
     * 
     * @param arr - array of integers
     * @return the unique element
     */
    public static int findUnique(int[] arr) {
        // YOUR CODE HERE
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){

              sum^= arr[i];

        }
         
        
        return sum; 
    }

    public static void main(String[] args) {
        System.out.println("=== Find Unique Element ===\n");

        // Test Case 1: Example from problem
        int[] test1 = {4, 1, 2, 1, 2};
        System.out.println("Test 1: [4, 1, 2, 1, 2]");
        System.out.println("Expected: 4");
        System.out.println("Your Output: " + findUnique(test1));
        System.out.println();

        // Test Case 2: Unique at start
        int[] test2 = {7, 1, 1, 2, 2, 3, 3};
        System.out.println("Test 2: [7, 1, 1, 2, 2, 3, 3]");
        System.out.println("Expected: 7");
        System.out.println("Your Output: " + findUnique(test2));
        System.out.println();

        // Test Case 3: Unique at end
        int[] test3 = {1, 1, 2, 2, 3, 3, 5};
        System.out.println("Test 3: [1, 1, 2, 2, 3, 3, 5]");
        System.out.println("Expected: 5");
        System.out.println("Your Output: " + findUnique(test3));
        System.out.println();

        // Test Case 4: Single element
        int[] test4 = {100};
        System.out.println("Test 4: [100]");
        System.out.println("Expected: 100");
        System.out.println("Your Output: " + findUnique(test4));
        System.out.println();

        // Test Case 5: Larger array
        int[] test5 = {5, 5, 8, 8, 10, 10, 12, 12, 99};
        System.out.println("Test 5: [5, 5, 8, 8, 10, 10, 12, 12, 99]");
        System.out.println("Expected: 99");
        System.out.println("Your Output: " + findUnique(test5));
        System.out.println();

        // Test Case 6: Negative numbers
        int[] test6 = {-1, -1, 0, 0, 42};
        System.out.println("Test 6: [-1, -1, 0, 0, 42]");
        System.out.println("Expected: 42");
        System.out.println("Your Output: " + findUnique(test6));
    }
}
