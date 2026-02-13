/**
 * Q4. Generate All Subsets using Bit Masking
 * 
 * Problem:
 * Given an array of n elements, generate all possible subsets using bit masking.
 * 
 * Example:
 * Input: [1, 2]
 * Output:
 * []
 * [1]
 * [2]
 * [1, 2]
 * 
 * Focus:
 * - 2^n subsets
 * - Bit representation of numbers from 0 to (2^n - 1)
 * - Mask checking
 * 
 * Hint: For n elements, there are 2^n subsets. Each number from 0 to 2^n-1 represents
 * a subset. If ith bit is 1, include arr[i] in that subset.
 */
import java.util.*;

public class P04_GenerateSubsets {

    /**
     * TODO: Implement this method
     * Generate all subsets of the given array using bit masking
     * 
     * @param arr - array of integers
     * @return list of all subsets
     */
    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        int totalSubsets = (1 << n);  // 2^n subsets
        
        // Iterate through all numbers from 0 to 2^n - 1
        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            
            // Check each bit position
            for (int i = 0; i < n; i++) {
                // If ith bit is set, include arr[i]
                if ((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                }
            }
            
            result.add(subset);
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Generate All Subsets using Bit Masking ===\n");

        // Test Case 1: Example from problem
        int[] test1 = {1, 2};
        System.out.println("Test 1: [1, 2]");
        System.out.println("Expected: [], [1], [2], [1, 2]");
        System.out.println("Your Output:");
        List<List<Integer>> result1 = generateSubsets(test1);
        for (List<Integer> subset : result1) {
            System.out.println(subset);
        }
        System.out.println();

        // Test Case 2: Three elements
        int[] test2 = {1, 2, 3};
        System.out.println("Test 2: [1, 2, 3]");
        System.out.println("Expected: [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]");
        System.out.println("Your Output:");
        List<List<Integer>> result2 = generateSubsets(test2);
        for (List<Integer> subset : result2) {
            System.out.println(subset);
        }
        System.out.println();

        // Test Case 3: Single element
        int[] test3 = {5};
        System.out.println("Test 3: [5]");
        System.out.println("Expected: [], [5]");
        System.out.println("Your Output:");
        List<List<Integer>> result3 = generateSubsets(test3);
        for (List<Integer> subset : result3) {
            System.out.println(subset);
        }
        System.out.println();

        // Test Case 4: Four elements
        int[] test4 = {1, 2, 3, 4};
        System.out.println("Test 4: [1, 2, 3, 4]");
        System.out.println("Expected: 16 subsets total (2^4)");
        List<List<Integer>> result4 = generateSubsets(test4);
        System.out.println("Your Output: " + result4.size() + " subsets");
        for (List<Integer> subset : result4) {
            System.out.println(subset);
        }
    }
}
