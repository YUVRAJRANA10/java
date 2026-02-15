/**
 * R07: Lexicographical Counting
 * ==============================
 * 
 * Problem:
 * Print all numbers from 1 to n in lexicographical (dictionary) order.
 * 
 * What is Lexicographical Order?
 * In dictionary order, "1" comes before "2", and "10" comes before "2"
 * because we compare digit by digit like strings.
 * 
 * Examples:
 * 
 * Input: n = 13
 * Output: 1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9
 * 
 * Input: n = 25
 * Output: 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8, 9
 * 
 * Input: n = 100
 * Output: 1, 10, 100, 11, 12, ..., 19, 2, 20, 21, ..., 99
 * 
 * Why this order?
 * When numbers are treated as strings:
 * "1" < "10" < "11" < "2" < "20" < "21" < "3" ...
 * 
 * Focus:
 * - Understanding lexicographical ordering
 * - Building numbers by appending digits
 * - Knowing when to stop
 * 
 * Hints:
 * - Start from number 1 (not 0)
 * - From current number, try appending digits 0-9
 * - Stop when you exceed n
 * - Base case: if current > n, return
 * - Print current number first, then explore further
 * 
 * Algorithm:
 * 1. Start with numbers 1 to 9
 * 2. For each number, try appending 0-9 to create next numbers
 * 3. Example: From 1 → try 10, 11, 12, ..., 19
 *             From 10 → try 100, 101, 102, ..., 109
 * 
 * Think about it for n=15:
 *          1
 *      /   |   ...
 *    10   11   12  13  14  15  16(stop) 17(stop)...
 *    |
 *   100(stop)
 * 
 * Output: 1, 10, 11, 12, 13, 14, 15, 2, 3, 4, 5, 6, 7, 8, 9
 */

public class R07_LexicographicalCounting {

    /**
     * TODO: Implement this method
     * Print numbers from 1 to n in lexicographical order
     * 
     * Approach: Call helper function for each starting digit (1-9)
     */
    public static void printLexicographical(int n) {
        // YOUR CODE HERE
        // Hint: Call lexicographicalHelper for each digit 1 to 9
    }

    /**
     * TODO: Implement this helper method
     * Recursively print numbers starting from 'current'
     * 
     * @param current - current number being processed
     * @param n - upper limit
     */
    private static void lexicographicalHelper(int current, int n) {
        // YOUR CODE HERE
    }

    public static void main(String[] args) {
        System.out.println("=== Lexicographical Counting ===\n");

        // Test Case 1: Small number
        System.out.println("Test 1: Numbers 1 to 13");
        System.out.println("Expected: 1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9");
        System.out.print("Your Output: ");
        printLexicographical(13);
        System.out.println("\n");

        // Test Case 2: Includes 20s
        System.out.println("Test 2: Numbers 1 to 25");
        System.out.println("Expected: 1, 10, 11, 12, ..., 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, ..., 9");
        System.out.print("Your Output: ");
        printLexicographical(25);
        System.out.println("\n");

        // Test Case 3: Single digit
        System.out.println("Test 3: Numbers 1 to 9");
        System.out.println("Expected: 1, 2, 3, 4, 5, 6, 7, 8, 9");
        System.out.print("Your Output: ");
        printLexicographical(9);
        System.out.println("\n");

        // Test Case 4: Reaches 100
        System.out.println("Test 4: Numbers 1 to 100");
        System.out.println("Expected: 1, 10, 100, 11, 12, ..., 19, 2, 20, ..., 99");
        System.out.print("Your Output: ");
        printLexicographical(100);
        System.out.println("\n");

        // Test Case 5: Larger number
        System.out.println("Test 5: Numbers 1 to 50");
        System.out.print("Your Output: ");
        printLexicographical(50);
        System.out.println("\n");
    }
}
