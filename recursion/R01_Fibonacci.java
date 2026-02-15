/**
 * R01: Fibonacci Number
 * ======================
 * 
 * Problem:
 * Write a recursive function to find the nth Fibonacci number.
 * The Fibonacci sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
 * 
 * Formula:
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2) for n > 1
 * 
 * Examples:
 * fibonacci(0) → 0
 * fibonacci(1) → 1
 * fibonacci(5) → 5 (because 0,1,1,2,3,5)
 * fibonacci(7) → 13
 * fibonacci(10) → 55
 * 
 * Focus:
 * - Multiple recursive calls (branching)
 * - Understanding exponential time complexity
 * - Base cases (two base cases needed!)
 * 
 * Hints:
 * - You need TWO base cases: one for n=0, one for n=1
 * - For any other n, return sum of previous two Fibonacci numbers
 * - This will be SLOW for large n (you'll understand why when you learn memoization)
 * 
 * Challenge:
 * Can you draw the recursion tree for fibonacci(5) on paper?
 */

public class R01_Fibonacci {

    /**
     * TODO: Implement this method
     * Calculate the nth Fibonacci number using recursion
     * 
     * @param n - the position in Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // YOUR CODE HERE
        if( n < 2){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Fibonacci Number (Recursive) ===\n");

        // Test Case 1: Base cases
        System.out.println("Test 1: fibonacci(0)");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + fibonacci(0));
        System.out.println();

        System.out.println("Test 2: fibonacci(1)");
        System.out.println("Expected: 1");
        System.out.println("Your Output: " + fibonacci(1));
        System.out.println();

        // Test Case 2: Small values
        System.out.println("Test 3: fibonacci(5)");
        System.out.println("Expected: 5");
        System.out.println("Your Output: " + fibonacci(5));
        System.out.println();

        System.out.println("Test 4: fibonacci(7)");
        System.out.println("Expected: 13");
        System.out.println("Your Output: " + fibonacci(7));
        System.out.println();

        // Test Case 3: Medium values
        System.out.println("Test 5: fibonacci(10)");
        System.out.println("Expected: 55");
        System.out.println("Your Output: " + fibonacci(10));
        System.out.println();

        System.out.println("Test 6: fibonacci(12)");
        System.out.println("Expected: 144");
        System.out.println("Your Output: " + fibonacci(12));
        System.out.println();

        // Test Case 4: Larger value (will be slow - that's expected!)
        System.out.println("Test 7: fibonacci(15)");
        System.out.println("Expected: 610");
        System.out.println("Your Output: " + fibonacci(15));
        System.out.println();

        // Note: Don't try fibonacci(40) or higher - it will take forever!
        // That's why we need Dynamic Programming (memoization)
    }
}
