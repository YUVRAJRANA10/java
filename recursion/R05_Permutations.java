/**
 * R05: Permutations of a String
 * ==============================
 * 
 * Problem:
 * Print all permutations of a given string.
 * A permutation is an arrangement where order matters.
 * 
 * Examples:
 * 
 * Input: "ab"
 * Output: ab, ba  (2 permutations)
 * 
 * Input: "abc"
 * Output: abc, acb, bac, bca, cab, cba  (6 permutations)
 * 
 * Input: "xyz"
 * Output: xyz, xzy, yxz, yzx, zxy, zyx  (6 permutations)
 * 
 * Pattern:
 * For a string of length n, there are n! (factorial) permutations
 * - 2 chars: 2! = 2
 * - 3 chars: 3! = 6
 * - 4 chars: 4! = 24
 * 
 * Focus:
 * - Backtracking technique
 * - Swapping elements
 * - Undoing changes (backtrack)
 * 
 * Hints:
 * - Base case: when index reaches end of string, print it
 * - For each position, try putting each remaining character there
 * - Use swapping: swap(i, j) → recurse → swap back(i, j)
 * - The "swap back" is the backtracking step!
 * 
 * Algorithm:
 * 1. For position i, try every character from i to end
 * 2. Swap character at position i with character at position j
 * 3. Recursively permute the rest (i+1 onwards)
 * 4. Swap back to restore original (BACKTRACK)
 * 
 * Think about it for "abc":
 *                     abc
 *         /           |           \
 *    (a at 0)    (b at 0)     (c at 0)
 *       abc          bac          cba
 *      /  \         /  \         /  \
 *   abc  acb     bac  bca     cab  cba
 */

public class R05_Permutations {

    /**
     * TODO: Implement this method
     * Print all permutations of the string
     * 
     * @param str - the string to permute
     * @param index - current index (start with 0)
     */
    public static void printPermutations(String str, int index) {
        // YOUR CODE HERE
    }

    /**
     * Helper function to swap characters in a string
     * Java strings are immutable, so we convert to char array
     */
    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    /**
     * TODO: Implement this method (BONUS)
     * Count total permutations (should return n!)
     * 
     * @param n - length of string
     * @return factorial of n
     */
    public static int countPermutations(int n) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Permutations of a String ===\n");

        // Test Case 1: 2 characters
        System.out.println("Test 1: Permutations of 'ab'");
        System.out.println("Expected: ab, ba (2 permutations)");
        System.out.println("Your Output:");
        printPermutations("ab", 0);
        System.out.println();

        // Test Case 2: 3 characters
        System.out.println("Test 2: Permutations of 'abc'");
        System.out.println("Expected: 6 permutations");
        System.out.println("Your Output:");
        printPermutations("abc", 0);
        System.out.println();

        // Test Case 3: Different characters
        System.out.println("Test 3: Permutations of 'xyz'");
        System.out.println("Expected: 6 permutations");
        System.out.println("Your Output:");
        printPermutations("xyz", 0);
        System.out.println();

        // Test Case 4: Single character
        System.out.println("Test 4: Permutations of 'a'");
        System.out.println("Expected: a (1 permutation)");
        System.out.println("Your Output:");
        printPermutations("a", 0);
        System.out.println();

        // Test Case 5: 4 characters (24 permutations!)
        System.out.println("Test 5: Permutations of 'abcd'");
        System.out.println("Expected: 24 permutations");
        System.out.println("Your Output:");
        printPermutations("abcd", 0);
        System.out.println();

        // BONUS: Test count function
        System.out.println("\n=== BONUS: Count Permutations ===\n");
        System.out.println("Count for 'ab' (2!): " + countPermutations(2) + " (Expected: 2)");
        System.out.println("Count for 'abc' (3!): " + countPermutations(3) + " (Expected: 6)");
        System.out.println("Count for 'abcd' (4!): " + countPermutations(4) + " (Expected: 24)");
    }
}
