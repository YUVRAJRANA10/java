/**
 * Q1. Check if a Number is Power of 2
 * 
 * Problem:
 * Write a function to check whether a given number is a power of 2 using bit manipulation.
 * 
 * Example:
 * Input: 16  → Output: true
 * Input: 18  → Output: false
 * 
 * Focus:
 * - n & (n - 1) trick
 * - Binary representation thinking
 * - O(1) solution
 * 
 * Hint: A number is a power of 2 if it has exactly one set bit in its binary representation.
 * Using n & (n-1) removes the rightmost set bit. If result is 0, n was a power of 2.
 * 
 */
public class P01_PowerOfTwo {

    /**
     * TODO: Implement this method
     * Check if a number is a power of 2 using bit manipulation
     * 
     * @param n - the number to check
     * @return true if n is a power of 2, false otherwise
     */
    public static boolean isPowerOfTwo(int n) {
        // Bit manipulation approach: n & (n-1)
        // Powers of 2 have exactly ONE set bit in binary
        // When we do n & (n-1), it removes the rightmost set bit
        // If n is a power of 2, result is 0
        
        // Edge case: n must be positive
        if (n <= 0) {
            return false;
        }
        

        if((n & (n - 1)) == 0){
            return true;
        }

        else{

            return false;
        }
        
        
        // YOUR RECURSIVE SOLUTION (commented):
        // if(n == 1){
        //     return true;
        // }
        // if( n <= 0 || n % 2 != 0){
        //     return false;
        // }
        // return isPowerOfTwo(n/2);
    }

    public static void main(String[] args) {
        System.out.println("=== Check if a Number is Power of 2 ===\n");

        // Test Case 1: Power of 2
        int test1 = 16;
        System.out.println("Test 1: n = " + test1);
        System.out.println("Expected: true (16 = 2^4 = 10000)");
        System.out.println("Your Output: " + isPowerOfTwo(test1));
        System.out.println();

        // Test Case 2: Not a power of 2
        int test2 = 18;
        System.out.println("Test 2: n = " + test2);
        System.out.println("Expected: false (18 = 10010)");
        System.out.println("Your Output: " + isPowerOfTwo(test2));
        System.out.println();

        // Test Case 3: Power of 2
        int test3 = 1;
        System.out.println("Test 3: n = " + test3);
        System.out.println("Expected: true (1 = 2^0 = 1)");
        System.out.println("Your Output: " + isPowerOfTwo(test3));
        System.out.println();

        // Test Case 4: Power of 2
        int test4 = 64;
        System.out.println("Test 4: n = " + test4);
        System.out.println("Expected: true (64 = 2^6 = 1000000)");
        System.out.println("Your Output: " + isPowerOfTwo(test4));
        System.out.println();

        // Test Case 5: Not a power of 2
        int test5 = 100;
        System.out.println("Test 5: n = " + test5);
        System.out.println("Expected: false (100 = 1100100)");
        System.out.println("Your Output: " + isPowerOfTwo(test5));
        System.out.println();

        // Test Case 6: Edge case - zero
        int test6 = 0;
        System.out.println("Test 6: n = " + test6);
        System.out.println("Expected: false (0 is not a power of 2)");
        System.out.println("Your Output: " + isPowerOfTwo(test6));
        System.out.println();

        // Test Case 7: Edge case - negative number
        int test7 = -16;
        System.out.println("Test 7: n = " + test7);
        System.out.println("Expected: false (negative numbers cannot be powers of 2)");
        System.out.println("Your Output: " + isPowerOfTwo(test7));
    }
}
