/**
 * Q2. Count Set Bits
 * 
 * Problem:
 * Write a function to count the number of 1s in the binary representation of a number.
 * 
 * Example:
 * Input: 13  → Output: 3  (13 → 1101)
 * 
 * Focus:
 * - Right shift operator
 * - n & 1 check
 * - Brian Kernighan's Algorithm
 * 
 * Hint: Use n & 1 to check if the last bit is 1, then right shift.
 * Or use Brian Kernighan's: n & (n-1) removes the rightmost set bit each time.
 */
public class P02_CountSetBits {

    /**
     * TODO: Implement this method
     * Count the number of 1s in the binary representation of a number
     * 
     * @param n - the number
     * @return count of set bits (1s)
     */
    public static int countSetBits(int n) {
        // YOUR CODE HERE'



        return Integer.bitCount(n); // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Count Set Bits ===\n");

        // Test Case 1: Example from problem
        int test1 = 13;
        System.out.println("Test 1: n = " + test1 + " (Binary: 1101)");
        System.out.println("Expected: 3");
        System.out.println("Your Output: " + countSetBits(test1));
        System.out.println();

        // Test Case 2: All bits set
        int test2 = 15;
        System.out.println("Test 2: n = " + test2 + " (Binary: 1111)");
        System.out.println("Expected: 4");
        System.out.println("Your Output: " + countSetBits(test2));
        System.out.println();

        // Test Case 3: Single bit set
        int test3 = 8;
        System.out.println("Test 3: n = " + test3 + " (Binary: 1000)");
        System.out.println("Expected: 1");
        System.out.println("Your Output: " + countSetBits(test3));
        System.out.println();

        // Test Case 4: Zero
        int test4 = 0;
        System.out.println("Test 4: n = " + test4 + " (Binary: 0)");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + countSetBits(test4));
        System.out.println();

        // Test Case 5: Larger number
        int test5 = 255;
        System.out.println("Test 5: n = " + test5 + " (Binary: 11111111)");
        System.out.println("Expected: 8");
        System.out.println("Your Output: " + countSetBits(test5));
        System.out.println();

        // Test Case 6: Random number
        int test6 = 127;
        System.out.println("Test 6: n = " + test6 + " (Binary: 1111111)");
        System.out.println("Expected: 7");
        System.out.println("Your Output: " + countSetBits(test6));
    }
}
