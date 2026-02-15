/**
 * R02: Print All Subsequences
 * ============================
 * 
 * Problem:
 * Print all subsequences of a given string.
 * A subsequence is formed by deleting some (or no) characters from the string
 * without changing the order of remaining characters.
 * 
 * Examples:
 * 
 * Input: "ab"
 * Output: "", "a", "b", "ab"  (4 subsequences)
 * 
 * Input: "abc"
 * Output: "", "a", "b", "c", "ab", "ac", "bc", "abc"  (8 subsequences)
 * 
 * Input: "xyz"
 * Output: "", "x", "y", "z", "xy", "xz", "yz", "xyz"  (8 subsequences)
 * 
 * Pattern:
 * For a string of length n, there are 2^n subsequences
 * (Each character has 2 choices: include or exclude)
 * 
 * Focus:
 * - Include/Exclude pattern
 * - Building result string progressively
 * - Understanding decision trees
 * 
 * Hints:
 * - At each character, you have 2 choices: include it OR exclude it
 * - Base case: when you've processed all characters, print the result
 * - Use an index to track current position in original string
 * - Use another string to build the subsequence
 * 
 * Think about it:
 * For "abc":
 *                    ""
 *              /           \
 *         include a      exclude a
 *            "a"             ""
 *          /    \          /    \
 *      "ab"    "a"      "b"     ""
 *      / \     / \      / \     / \
 *   "abc" "ab" "ac" "a" "bc" "b" "c" ""
 */

public class R02_Subsequences {

    /**
     * TODO: Implement this method
     * Print all subsequences of the given string
     * 
     * @param str - original string
     * @param current - current subsequence being built
     * @param index - current position in original string
     */
    public static void printSubsequences(String str, String current, int index) {
        // YOUR CODE HERE
    }

    /**
     * TODO: Implement this method (BONUS)
     * Count total number of subsequences
     * 
     * @param str - original string
     * @param index - current position
     * @return count of subsequences
     */
    public static int countSubsequences(String str, int index) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Print All Subsequences ===\n");

        // Test Case 1: Simple 2-character string
        System.out.println("Test 1: Subsequences of 'ab'");
        System.out.println("Expected: \"\", \"b\", \"a\", \"ab\" (in some order)");
        System.out.println("Your Output:");
        printSubsequences("ab", "", 0);
        System.out.println();

        // Test Case 2: 3-character string
        System.out.println("Test 2: Subsequences of 'abc'");
        System.out.println("Expected: 8 subsequences");
        System.out.println("Your Output:");
        printSubsequences("abc", "", 0);
        System.out.println();

        // Test Case 3: Different characters
        System.out.println("Test 3: Subsequences of 'xyz'");
        System.out.println("Expected: 8 subsequences");
        System.out.println("Your Output:");
        printSubsequences("xyz", "", 0);
        System.out.println();

        // Test Case 4: Single character
        System.out.println("Test 4: Subsequences of 'a'");
        System.out.println("Expected: \"\", \"a\"");
        System.out.println("Your Output:");
        printSubsequences("a", "", 0);
        System.out.println();

        // Test Case 5: Empty string
        System.out.println("Test 5: Subsequences of ''");
        System.out.println("Expected: \"\"");
        System.out.println("Your Output:");
        printSubsequences("", "", 0);
        System.out.println();

        // BONUS: Test count function
        System.out.println("=== BONUS: Count Subsequences ===\n");
        System.out.println("Count for 'ab': " + countSubsequences("ab", 0) + " (Expected: 4)");
        System.out.println("Count for 'abc': " + countSubsequences("abc", 0) + " (Expected: 8)");
        System.out.println("Count for 'abcd': " + countSubsequences("abcd", 0) + " (Expected: 16)");
    }
}
