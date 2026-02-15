/**
 * Q10. Check if Two Numbers Differ by Exactly One Bit
 * 
 * Problem:
 * Write a function to check if two numbers differ by exactly one bit.
 * 
 * Example:
 * Input: a = 5, b = 4
 * Binary: 101, 100
 * Output: true (only one bit differs)
 * 
 * Focus:
 * - XOR usage
 * - Count set bits in (a ^ b)
 * - Bit difference logic
 * 
 * Hint: XOR gives bits that are different. Count set bits in (a ^ b).
 * If count is exactly 1, they differ by one bit.
 */
public class P10_OneBitDifference {

    /**
     * TODO: Implement this method
     * Check if two numbers differ by exactly one bit
     * 
     * @param a - first number
     * @param b - second number
     * @return true if they differ by exactly one bit, false otherwise
     */
    public static boolean differByOneBit(int a, int b) {
        // YOUR CODE HERE
int count = 0;
        for (int i = 0; i < 32; i++) {
            
            if(((a >> i) & 1) == ((b >> i) & 1)) {
                 continue;
            }

            count++;
        }
        if(count == 1){
            return true;
        }
        else{
        return false; // placeholder
        }
    }

    /**
     * Helper method to count set bits (you can implement or reuse from P02)
     */
    private static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Check if Two Numbers Differ by Exactly One Bit ===\n");

        // Test Case 1: Example from problem
        int a1 = 5, b1 = 4;
        System.out.println("Test 1: a = " + a1 + " (101), b = " + b1 + " (100)");
        System.out.println("Expected: true (differ in 1 bit)");
        System.out.println("Your Output: " + differByOneBit(a1, b1));
        System.out.println();

        // Test Case 2: Same numbers
        int a2 = 7, b2 = 7;
        System.out.println("Test 2: a = " + a2 + " (111), b = " + b2 + " (111)");
        System.out.println("Expected: false (same numbers)");
        System.out.println("Your Output: " + differByOneBit(a2, b2));
        System.out.println();

        // Test Case 3: Differ by multiple bits
        int a3 = 5, b3 = 6;
        System.out.println("Test 3: a = " + a3 + " (101), b = " + b3 + " (110)");
        System.out.println("Expected: false (differ in 2 bits)");
        System.out.println("Your Output: " + differByOneBit(a3, b3));
        System.out.println();

        // Test Case 4: Power of 2 difference
        int a4 = 8, b4 = 0;
        System.out.println("Test 4: a = " + a4 + " (1000), b = " + b4 + " (0000)");
        System.out.println("Expected: true (differ in 1 bit)");
        System.out.println("Your Output: " + differByOneBit(a4, b4));
        System.out.println();

        // Test Case 5: Adjacent numbers
        int a5 = 10, b5 = 11;
        System.out.println("Test 5: a = " + a5 + " (1010), b = " + b5 + " (1011)");
        System.out.println("Expected: true (differ in 1 bit)");
        System.out.println("Your Output: " + differByOneBit(a5, b5));
        System.out.println();

        // Test Case 6: Large difference
        int a6 = 15, b6 = 7;
        System.out.println("Test 6: a = " + a6 + " (1111), b = " + b6 + " (0111)");
        System.out.println("Expected: true (differ in 1 bit)");
        System.out.println("Your Output: " + differByOneBit(a6, b6));
        System.out.println();

        // Test Case 7: Multiple bits differ
        int a7 = 3, b7 = 12;
        System.out.println("Test 7: a = " + a7 + " (0011), b = " + b7 + " (1100)");
        System.out.println("Expected: false (differ in 4 bits)");
        System.out.println("Your Output: " + differByOneBit(a7, b7));
    }
}
